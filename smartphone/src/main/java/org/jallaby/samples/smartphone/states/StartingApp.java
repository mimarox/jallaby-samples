package org.jallaby.samples.smartphone.states;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.EntryAction;
import org.jallaby.beans.annotations.State;
import org.jallaby.execution.FinishState;
import org.jallaby.samples.smartphone.business.LifecycleReporter;
import org.jallaby.samples.smartphone.business.SmartPhone;

import com.google.inject.Inject;

@State(name = "StartingApp")
public class StartingApp {

	@Inject
	private SmartPhone smartPhone;
	
	@Inject
	private LifecycleReporter reporter;
	
	@PostConstruct
	public void postConstruct() {
		reporter.reportPostConstruct(getClass());
	}
	
	@EntryAction
	public FinishState entryAction(final Map<String, Map<String, Object>> eventData) {
		Map<String, Object> startAppData = eventData.get("startApp");
		smartPhone.startApp((String) startAppData.get("app"));
		return FinishState.FINISHED;
	}
	
	@PreDestroy
	public void preDestroy() {
		reporter.reportPreDestroy(getClass());
	}
}
