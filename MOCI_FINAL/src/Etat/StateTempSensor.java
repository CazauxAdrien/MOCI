package Etat;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class StateTempSensor extends AbstractSensor{

	private StateSens state;
	private double valeur = 0;	

	public StateTempSensor() {
		super();
		this.state = new Off(this);
		System.out.println("Sensor created with "+this.getClass());
	}
	
	public StateTempSensor(StateSens state) {
		super();
		this.state = state;
	}

	@Override
	public void on() {
		this.state.on();
	}

	@Override
	public void off() {
		this.state.off();
	}

	@Override
	public boolean getStatus() {
		return this.state.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		this.state.update();
		setChanged();
		notifyObservers();
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		return this.state.getValue();
	}

	public double getValeur() {
		return this.valeur;
	}
	
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	public StateSens getState() {
		return state;
	}

	public void setState(StateSens state) {
		this.state = state;
	}

}
