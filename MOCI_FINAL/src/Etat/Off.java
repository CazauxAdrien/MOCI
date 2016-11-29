package Etat;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public class Off extends StateSens{

	public Off(StateTempSensor sensor) {
		super(sensor);
	}

	@Override
	public void on() {
		sensor.setState(new On(sensor));
	}

	@Override
	public void off() {
	}

	@Override
	public boolean getStatus() {
		return false;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}


}
