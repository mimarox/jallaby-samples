package org.jallaby.beans.samples.test.common;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.jallaby.launcher.Launcher;

import retrofit2.Response;

public abstract class TestBase {
	private static final String UUID = "fee5a05c-5f52-45dd-926a-9f2bc7f097ee";

	protected void startJallaby() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Launcher.main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "Jallaby Container").start();
	}

	protected void buildSample(final String pomPath, final String mavenPath) throws MavenInvocationException {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File(pomPath));
		request.setGoals(Arrays.asList("clean", "install"));

		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File(mavenPath));
		invoker.execute(request);
	}
	
	protected EventResult sendEvent(final JallabyApi api, final String event) throws Exception {
		return sendEvent(api, event, new HashMap<>());
	}
	
	protected EventResult sendEvent(final JallabyApi api, final String event,
			final Map<String, Object> body) throws Exception {
		Response<EventResult> response = api.sendEvent("CoffeeMachine", UUID,
				event, body).execute();
		
		if (response.isSuccessful()) {
			return response.body();
		} else if (response.code() == 503){
			throw new InternalServerErrorException(response.errorBody().string());
		} else {
			throw new UnexpectedServerResponseException(response.errorBody().string());
		}
	}

	protected void deleteStateMachineArchive(final String archivePath) {
		Path archive = Paths.get(archivePath);
		archive.toFile().delete();
	}
}
