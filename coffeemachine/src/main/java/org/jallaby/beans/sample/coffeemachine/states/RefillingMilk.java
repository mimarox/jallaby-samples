package org.jallaby.beans.sample.coffeemachine.states;

import java.util.Map;

import org.jallaby.beans.annotations.EntryAction;
import org.jallaby.beans.annotations.ExitAction;
import org.jallaby.beans.annotations.State;
import org.jallaby.beans.sample.coffeemachine.business.CoffeeMachine;

import com.google.inject.Inject;

@State(name = "RefillingMilk")
public class RefillingMilk {

	@Inject
	private CoffeeMachine coffeeMachine;
	
	@EntryAction
	public void entryAction(final Map<String, Map<String, Object>> eventData) {
		coffeeMachine.openMilkTray();
	}
	
	@ExitAction
	public void exitAction(final Map<String, Map<String, Object>> eventData) {
		coffeeMachine.closeMilkTray();
	}
}
