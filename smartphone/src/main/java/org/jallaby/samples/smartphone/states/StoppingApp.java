package org.jallaby.samples.smartphone.states;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.EntryAction;
import org.jallaby.beans.annotations.State;
import org.jallaby.samples.smartphone.business.LifecycleReporter;
import org.jallaby.samples.smartphone.business.SmartPhone;

import com.google.inject.Inject;

@State(name = "StoppingApp")
public class StoppingApp {

	@Inject
	private SmartPhone smartPhone;
	
	@Inject
	private LifecycleReporter reporter;
	
	@PostConstruct
	public void postConstruct() {
		reporter.reportPostConstruct(getClass());
	}
	
	@EntryAction
	public void entryAction(final Map<String, Map<String, Object>> eventData) {
		Map<String, Object> startAppData = eventData.get("stopApp");
		smartPhone.stopApp((String) startAppData.get("app"));
	}
	
	@PreDestroy
	public void preDestroy() {
		reporter.reportPreDestroy(getClass());
	}
}
