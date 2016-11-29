package Command;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class GetValue extends Sensor{
private double value;
	
	public GetValue(AbstractSensor S) {
		super(S);
	}

	@Override
	public void execute() {
		try {
			this.value = S.getValue();
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}

	public double getValue() {
		return value;
	}
}
