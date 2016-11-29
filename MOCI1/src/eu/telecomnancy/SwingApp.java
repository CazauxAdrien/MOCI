package eu.telecomnancy;

import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
        AbstractSensor sensor = new TemperatureSensor();
        new MainWindow(sensor);
    }

}
