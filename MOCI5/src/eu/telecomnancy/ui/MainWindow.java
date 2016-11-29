package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.AbstractSensor;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {

    private AbstractSensor sensor;
    private SensorView sensorView;

    public MainWindow(AbstractSensor sensor) {
        this.sensor = sensor;
        this.sensorView = new SensorView(this.sensor);

        this.setLayout(new BorderLayout());
        this.add(this.sensorView, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
