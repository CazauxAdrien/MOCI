package eu.telecomnancy;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;

public class App {

    public static void main(String[] args) {
        AbstractSensor sensor = new TemperatureSensor();
        new ConsoleUI(sensor);
    }

}