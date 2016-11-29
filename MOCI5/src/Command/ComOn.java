package Command;

import eu.telecomnancy.sensor.AbstractSensor;

public class ComOn extends Sensor{

	public ComOn(AbstractSensor S) {
		super(S);
	}

	@Override
	public void execute() {
		this.S.on();
	}
}
