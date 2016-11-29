package Command;

import eu.telecomnancy.sensor.AbstractSensor;

public class ComOff extends Sensor{
	
	public ComOff(AbstractSensor S) {
		super(S);
	}

	@Override
	public void execute() {
		this.S.off();
	}
}
