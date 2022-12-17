package org.jallaby.samples.smartphone.modules;

import org.jallaby.samples.smartphone.business.LifecycleReporter;
import org.jallaby.samples.smartphone.business.SmartPhone;

import com.google.inject.Binder;
import com.google.inject.Module;

public class DefaultModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(SmartPhone.class).asEagerSingleton();
		binder.bind(LifecycleReporter.class).asEagerSingleton();
	}
}
