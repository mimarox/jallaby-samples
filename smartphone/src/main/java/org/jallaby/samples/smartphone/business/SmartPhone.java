package org.jallaby.samples.smartphone.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartPhone {
	private static final Logger LOGGER = LoggerFactory.getLogger(SmartPhone.class);

	private String runningApp;
	
	public void switchOff() {
		LOGGER.info("Switching off SmartPhone...");
	}

	public void preactivate() {
		LOGGER.info("Preactivating SmartPhone...");
	}

	public void switchOn() {
		LOGGER.info("Switching on SmartPhone...");
	}

	public void predeactivate() {
		LOGGER.info("Predeactivating SmartPhone...");
	}

	public void sleep() {
		LOGGER.info("Putting SmartPhone to sleep...");
	}

	public void wakeUp() {
		LOGGER.info("Waking SmartPhone up...");
	}

	public void startApp(final String app) {
		LOGGER.info(String.format("Starting app [%s]...", app));
		runningApp = app;
	}

	public void stopApp(final String app) {
		LOGGER.info(String.format("Stopping app [%s]...", app));
		runningApp = null;
	}

	public boolean hasPower() {
		LOGGER.info("Checking SmartPhone power...");
		return true;
	}

	public void activate() {
		LOGGER.info("Activating SmartPhone...");
	}

	public boolean maySwitchOff() {
		LOGGER.info("Checking whether SmartPhone may be switched off...");
		return true;
	}

	public boolean hasApp(final String app) {
		if (app != null && (app.equals("Email") || app.equals("Calendar"))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAppRunning(final String app) {
		return runningApp != null && runningApp.equals(app);
	}
}
