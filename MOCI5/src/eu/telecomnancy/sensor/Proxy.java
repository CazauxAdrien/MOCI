package eu.telecomnancy.sensor;

import java.util.Date;

public class Proxy extends AbstractSensor{
	
	private TemperatureSensor T;
	public Proxy(){
		this.T=new TemperatureSensor();
		System.out.println("Le capteur a été créé par" +this.getClass());
	}
	@Override
	public void on() {
		this.T.on();
		System.out.println((new Date()+" Le capteur a été mis en route."));
	}

	@Override
	public void off() {
		this.T.off();
		System.out.println((new Date()+" Le capteur a été arrété."));
	}

	@Override
	public boolean getStatus() {
		System.out.println((new Date())+":"+this.T.getStatus()+"Récupération du statut du capteur");
		return this.T.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		System.out.println((new Date())+" La valeur du capteur est mise à jour");
		this.T.update();
		setChanged();
		notifyObservers();		
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		System.out.println((new Date())+" La valeur du capteur est"+this.T.getValue());
		return this.T.getValue();
	}

}
