package org.jallaby.beans.sample.coffeemachine.states;

import java.util.Map;

import org.jallaby.beans.annotations.EntryAction;
import org.jallaby.beans.annotations.State;
import org.jallaby.beans.sample.coffeemachine.business.CoffeeMachine;

import com.google.inject.Inject;

@State(name = "SwitchedOff")
public class SwitchedOff {

	@Inject
	private CoffeeMachine coffeeMachine;
	
	@EntryAction
	public void entryAction(Map<String, Map<String, Object>> eventData) {
		coffeeMachine.switchOff();
	}
}
