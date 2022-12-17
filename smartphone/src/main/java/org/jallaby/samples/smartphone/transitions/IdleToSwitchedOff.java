package org.jallaby.samples.smartphone.transitions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.Transition;
import org.jallaby.beans.annotations.TransitionGuard;
import org.jallaby.samples.smartphone.business.LifecycleReporter;
import org.jallaby.samples.smartphone.business.SmartPhone;

import com.google.inject.Inject;

@Transition(fromState = "Idle", toState = "SwitchedOff")
public class IdleToSwitchedOff {

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
		return smartPhone.maySwitchOff();
	}
	
	@PreDestroy
	public void preDestroy() {
		reporter.reportPreDestroy(getClass());
	}
}
