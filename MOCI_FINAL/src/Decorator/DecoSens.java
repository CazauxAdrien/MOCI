package Decorator;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class DecoSens extends AbstractSensor{

	protected AbstractSensor A;
	
	public DecoSens(AbstractSensor sensor) {
		super();
		this.A = sensor;
	}
	@Override
	public void on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return 0;
	}

}
