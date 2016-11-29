package eu.telecomnancy.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import Command.Sensor;
import eu.telecomnancy.sensor.Factory;
import eu.telecomnancy.helpers.ReadPropertyFile;
import eu.telecomnancy.sensor.AbstractSensor;

public class MainWindow extends JFrame {

	
	private AbstractSensor sensor;
    private SensorView sensorView;
    private JMenuBar menuBar;
    private JMenu menuCmd;
    private JMenu menuSensor;

    public MainWindow(AbstractSensor sensor) {
        this.sensor = sensor;
        this.sensorView = new SensorView(this.sensor);
        
       
        this.menuBar = new JMenuBar();
        this.menuSensor = new JMenu("Capteurs");
        createMenu();
        this.menuCmd = new JMenu("Commandes");
        createCommandMenu();

        this.setLayout(new BorderLayout());
        this.setJMenuBar(this.menuBar);
        this.add(this.sensorView, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
  
    private void createMenu() {
    	List<JMenuItem> items = new ArrayList<JMenuItem>();
    	items.add(new JMenuItem(Factory.CELSIUS));
    	items.add(new JMenuItem(Factory.ADAPT));
    	items.add(new JMenuItem(Factory.KELVIN));
    	items.add(new JMenuItem(Factory.ARRONDI));
    	items.add(new JMenuItem(Factory.ETAT));
    	items.add(new JMenuItem(Factory.PROXY));
    	items.add(new JMenuItem(Factory.NORMAL));
    	items.add(new JMenuItem(Factory.FAHRENHEIT));
    	
		
    	for (JMenuItem i : items) {
        	i.addActionListener(new SensorListener(i.getText()));
        	this.menuSensor.add(i);
    	}

    	this.menuBar.add(this.menuSensor);
	}
    
    
    private class SensorListener implements ActionListener {
    	
    	private String name;
    	
    	public SensorListener(String name) {
    		this.name = name;
    	}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			sensor = Factory.getInstance().makeSensor(this.name);
			sensor.addObserver(sensorView);
			sensorView.setSensor(sensor);
		}
    	
    }

    
	private void createCommandMenu() {
		try {
	        ReadPropertyFile rp=new ReadPropertyFile();
	        Properties p;
			p = rp.readFile("Commande.properties");
	        for (String i: p.stringPropertyNames()) {
	        	final String prop = p.getProperty(i);
	        	JMenuItem item = new JMenuItem(i);
	        	
	        	item.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	    	        	Sensor cmd = ((Sensor) createCommand(prop));
	    	        	cmd.execute();
	                }
	            });
	        	
	        	this.menuCmd.add(item);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "/Commande.properties not found.", "File Error !", JOptionPane.ERROR_MESSAGE);
		}
        this.menuBar.add(this.menuCmd);
	}

	
	private Object createCommand(String className) {
		Object instanceOfMyClass = null;
		Class<?> myClass = null;
		Constructor<?> constructor = null;
		
		try {
			myClass = Class.forName(className);
			constructor = myClass.getConstructor(Sensor.class);
			instanceOfMyClass = constructor.newInstance(sensor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return instanceOfMyClass;
	}
	
}
