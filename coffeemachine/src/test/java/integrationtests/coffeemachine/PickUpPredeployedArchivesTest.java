package integrationtests.coffeemachine;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.jallaby.beans.sample.coffeemachine.business.CoffeeMachine;
import org.jallaby.beans.sample.coffeemachine.business.CoffeeMachineInterface;
import org.jallaby.beans.samples.test.common.EventResult;
import org.jallaby.beans.samples.test.common.JallabyApi;
import org.jallaby.beans.samples.test.common.JallabyApiProvider;
import org.jallaby.beans.samples.test.common.TestBase;
import org.testng.annotations.Test;

public class PickUpPredeployedArchivesTest extends TestBase {

	@Test
	public void shouldPickUpPredeployedArchives() throws Exception {
		deleteStateMachineArchive(
				String.format("%1$s%2$sdeploy%2$scoffeemachine-1.0.0-SNAPSHOT.sma",
				System.getProperty("user.dir"),	System.getProperty("file.separator")));
		startJallaby();
		
		Thread.sleep(5000);
		
		CoffeeMachineInterface coffeeMachine = mock(CoffeeMachineInterface.class);
		when(coffeeMachine.hasPower()).thenReturn(true);
		
		CoffeeMachine.setInstance(coffeeMachine);

		// send events to jallaby container
		EventResult result;
		JallabyApi api = JallabyApiProvider.provideApi();
		
		result = sendEvent(api, "switchOn");
		
		assertEquals(result.getCurrentStateName(), "Idle");
		verify(coffeeMachine).switchOn();
		verify(coffeeMachine).sleep();
	}
}
