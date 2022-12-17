package org.jallaby.samples.smartphone.transitions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.ActionGroup;
import org.jallaby.beans.annotations.Concurrency;
import org.jallaby.beans.annotations.Transition;
import org.jallaby.beans.annotations.TransitionAction;
import org.jallaby.beans.annotations.TransitionGuard;
import org.jallaby.samples.smartphone.business.LifecycleReporter;
import org.jallaby.samples.smartphone.business.SmartPhone;

import com.google.inject.Inject;

@Transition(fromState = "SwitchedOff", toState="Idle",
actionGroups = @ActionGroup(name = "first", concurrency = Concurrency.SEQUENTIAL))
public class SwitchedOffToIdle {

	@Inject
	private SmartPhone smartPhone;
	
	@Inject
	private LifecycleReporter reporter;
	
	@PostConstruct
	public void postConstruct() {
		reporter.reportPostConstruct(getClass());
	}

	@TransitionGuard
	public boolean enoughPower() {
		return smartPhone.hasPower();
	}
	
	@TransitionAction(group = "first")
	public void firstAction() {
		smartPhone.activate();
	}
	
	@PreDestroy
	public void preDestroy() {
		reporter.reportPreDestroy(getClass());
	}
}
