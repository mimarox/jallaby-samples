package org.jallaby.samples.smartphone.states;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.EntryAction;
import org.jallaby.beans.annotations.ExitAction;
import org.jallaby.beans.annotations.State;
import org.jallaby.samples.smartphone.business.LifecycleReporter;
import org.jallaby.samples.smartphone.business.SmartPhone;

import com.google.inject.Inject;

@State(name = "SwitchedOn")
public class SwitchedOn {

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
		smartPhone.switchOn();
	}
	
	@ExitAction
	public void exitAction(final Map<String, Map<String, Object>> eventData) {
		smartPhone.predeactivate();
	}
	
	@PreDestroy
	public void preDestroy() {
		reporter.reportPreDestroy(getClass());
	}
}
