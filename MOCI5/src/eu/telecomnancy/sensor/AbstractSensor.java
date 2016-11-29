package eu.telecomnancy.sensor;

import java.util.Observable;

public abstract class AbstractSensor extends Observable implements ISensor{

	public abstract void on();

	public abstract void off();

	public abstract boolean getStatus();

	public abstract void update() throws SensorNotActivatedException;

	public abstract double getValue() throws SensorNotActivatedException;

}
