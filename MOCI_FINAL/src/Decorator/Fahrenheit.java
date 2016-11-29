package Decorator;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class Fahrenheit extends DecoSens{

	public Fahrenheit(AbstractSensor A){
		super(A);
	}
	public void on(){
		this.A.on();
	}
	public void off(){
		this.A.off();
	}
	public boolean getStatus(){
		return this.A.getStatus();
	}
	public void update() throws SensorNotActivatedException{
		this.A.update();
		setChanged();
		notifyObservers();
	}
	public double getValue() throws SensorNotActivatedException{
		double V = this.A.getValue();
		V=V*1.8+32;
		return V;
	}
}
