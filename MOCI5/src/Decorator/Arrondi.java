package Decorator;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class Arrondi extends DecoSens{

	public Arrondi(AbstractSensor sensor) {
		super(sensor);
		// TODO Auto-generated constructor stub
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
		V=Math.round(V);
		return V;
	}

}
