package eu.telecomnancy.sensor;


import Adapter.Adapter;
import Decorator.Fahrenheit;
import Decorator.Kelvin;
import Decorator.Arrondi;
import eu.telecomnancy.sensor.Proxy;
import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import Etat.StateTempSensor;

public class Factory {
	
	public final static String NORMAL = "Normal";
	public final static String ADAPT = "Adapter";
	public final static String ARRONDI = "Arrondi";
	public final static String CELSIUS = "Celsius";
	public final static String FAHRENHEIT = "Fahrenheit";
	public final static String KELVIN = "Kelvin";
	public final static String ETAT = "Etat";
	public final static String PROXY = "Proxy";
	
	private static Factory instance = null;
	
	private Factory() {
		super();
	}
	
	public static Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public AbstractSensor makeSensor(String sensorType) {
		
		AbstractSensor sensor = null;
		
		if (sensorType.equals(NORMAL)) {
			sensor = new TemperatureSensor();
		}
		else if (sensorType.equals(ADAPT)) {
			sensor = new Adapter();
		}
		else if (sensorType.equals(CELSIUS)) {
			sensor = new TemperatureSensor();
		}
		else if (sensorType.equals(FAHRENHEIT)) {
			sensor = new Fahrenheit(new TemperatureSensor());
		}
		else if (sensorType.equals(ETAT)) {
			sensor = new StateTempSensor();
		}
		else if (sensorType.equals(PROXY)) {
			sensor = new Proxy();
		} 
		
		else if (sensorType.equals(ARRONDI)) {
			sensor = new Arrondi(new TemperatureSensor());
		}
		
		else if (sensorType.equals(KELVIN)) {
			sensor = new Kelvin(new TemperatureSensor());
		}
		else {
			return null;
		}

		return sensor;
		
	}

}
