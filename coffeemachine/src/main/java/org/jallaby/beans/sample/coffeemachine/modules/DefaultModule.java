package org.jallaby.beans.sample.coffeemachine.modules;

import org.jallaby.beans.sample.coffeemachine.business.CoffeeMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;

public class DefaultModule implements Module {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultModule.class);
	
	@Override
	public void configure(Binder binder) {
		Class<CoffeeMachine> c = CoffeeMachine.class;
		
		LOGGER.info(String.format("Class [CoffeeMachine] has been loaded by [%s]",
				c.getClassLoader().toString()));
		
		binder.bind(c).asEagerSingleton();
	}
}
