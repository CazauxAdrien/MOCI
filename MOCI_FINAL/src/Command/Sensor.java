package Command;

import eu.telecomnancy.sensor.AbstractSensor;

public abstract class Sensor implements Command{
	
	protected AbstractSensor S;
	
	public Sensor() {
		super();
	}

	public Sensor(AbstractSensor S) {
		super();
		this.S = S;
	}

	public abstract void execute();

	public AbstractSensor getSensor() {
		return S;
	}

	public void setSensor(AbstractSensor S) {
		this.S = S;
	}	
}
