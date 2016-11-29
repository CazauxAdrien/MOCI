package Command;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class Update extends Sensor{
	
	public Update(AbstractSensor S) {
		super(S);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			this.S.update();
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}
}
