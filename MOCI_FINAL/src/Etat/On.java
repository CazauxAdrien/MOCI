package Etat;

import java.util.Random;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public class On extends StateSens{

	public On(StateTempSensor sensor) {
		super(sensor);
	}

	@Override
	public void on() {
	}

	@Override
	public void off() {
		sensor.setState(new Off(sensor));
	}

	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		sensor.setValeur((new Random()).nextDouble() * 100);
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		return sensor.getValeur();
	}

}
