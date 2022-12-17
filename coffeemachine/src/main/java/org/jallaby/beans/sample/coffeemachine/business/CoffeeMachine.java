package org.jallaby.beans.sample.coffeemachine.business;

public class CoffeeMachine implements CoffeeMachineInterface {
	private static CoffeeMachineInterface instance;
	
	public static void setInstance(final CoffeeMachineInterface instance) {
		CoffeeMachine.instance = instance;
	}
	
	@Override
	public void switchOn() {
		instance.switchOn();
	}

	@Override
	public void switchOff() {
		instance.switchOff();
	}

	@Override
	public void makeCoffee(String type) {
		instance.makeCoffee(type);
	}

	@Override
	public void stopMakingCoffee() {
		instance.stopMakingCoffee();
	}

	@Override
	public void sleep() {
		instance.sleep();
	}

	@Override
	public void wakeUp() {
		instance.wakeUp();
	}

	@Override
	public void openCoffeeTray() {
		instance.openCoffeeTray();
	}

	@Override
	public void closeCoffeeTray() {
		instance.closeCoffeeTray();
	}

	@Override
	public void openMilkTray() {
		instance.openMilkTray();
	}

	@Override
	public void closeMilkTray() {
		instance.closeMilkTray();
	}

	@Override
	public void openSugarTray() {
		instance.openSugarTray();
	}

	@Override
	public void closeSugarTray() {
		instance.closeSugarTray();
	}

	@Override
	public void openWaterTray() {
		instance.openWaterTray();
	}

	@Override
	public void closeWaterTray() {
		instance.closeWaterTray();
	}

	@Override
	public boolean hasPower() {
		return instance.hasPower();
	}
}
