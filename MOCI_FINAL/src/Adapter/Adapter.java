package Adapter;

import eu.telecomnancy.sensor.*;


public class Adapter extends AbstractSensor{

	
	private LegacyTemperatureSensor Leg;

	public Adapter(){
		super();
		this.Leg = new LegacyTemperatureSensor();
		System.out.println("Sensor created with "+this.getClass());
	}
	@Override
	public void on() {
		if (!this.Leg.getStatus())
			this.Leg.onOff();
		
	}

	@Override
	public void off() {
		if (this.Leg.getStatus())
			this.Leg.onOff();
		
	}

	@Override
	public boolean getStatus() {
		return this.Leg.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		if (this.Leg.getStatus()) {
			this.Leg.onOff(); 
			this.Leg.onOff(); 
		}
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
		setChanged();
		notifyObservers();
		
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		if (this.Leg.getStatus())
			return this.Leg.getTemperature();
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");

	}

}
