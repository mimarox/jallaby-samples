package org.jallaby.beans.sample.coffeemachine.transitions;

import org.jallaby.beans.annotations.Transition;
import org.jallaby.beans.annotations.TransitionGuard;
import org.jallaby.beans.sample.coffeemachine.business.CoffeeMachine;

import com.google.inject.Inject;

@Transition(fromState = "SwitchedOff", toState = "Idle")
public class SwitchedOffToIdleTransition {
	
	@Inject
	private CoffeeMachine coffeeMachine;
	
	@TransitionGuard
	public boolean enoughPower() {
		return coffeeMachine.hasPower();
	}
}
