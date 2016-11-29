package Etat;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public abstract class StateSens extends AbstractSensor{

protected StateTempSensor sensor;
	
	protected StateSens(StateTempSensor sensor) {
		super();
		this.sensor = sensor;
	}

	@Override
	public abstract void on();

	@Override
	public abstract void off();

	@Override
	public abstract boolean getStatus();

	@Override
	public abstract void update() throws SensorNotActivatedException;

	@Override
	public abstract double getValue() throws SensorNotActivatedException;
	

}
