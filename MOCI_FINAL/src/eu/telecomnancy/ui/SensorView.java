package eu.telecomnancy.ui;

import Command.GetValue;
import Command.Invoker;
import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.AbstractSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

import javax.swing.*;

import Command.GetValue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class SensorView extends JPanel implements Observer{
    private AbstractSensor sensor;

    private JLabel value = new JLabel("N/A °C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");
	private Invoker invoker;

    
    public SensorView(AbstractSensor c) {
        this.sensor = c;
        c.addObserver(this);
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensor.on();
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensor.off();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sensor.update();
                } catch (SensorNotActivatedException sensorNotActivatedException) {
                    sensorNotActivatedException.printStackTrace();
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

	@Override
	public void update(Observable o, Object arg1) {
		GetValue cmdGetValue = new GetValue(sensor);
		invoker = new Invoker(cmdGetValue);
		invoker.invoke();
		double val = cmdGetValue.getValue();
		
//		
			value.setText(""+val/*+" �C"*/);
	}
			
			
	public AbstractSensor getSensor() {
		return sensor;
	}
	public void setSensor(AbstractSensor sensor) {
		this.sensor = sensor;
	}
		
	
}
