package simulatie;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import simulatie.SimulatorController;
import simulatie.model.Simulator;
import simulatie.AbstractView;
import simulatie.SimulatorView;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 *
 */

public class Testor {
    private JFrame screen;
    private Simulator model;
    private AbstractView carparkview;

    private SimulatorController controller;
    private final Action action = new SwingAction();
    private JButton button_1;
    private JButton button_2;
    private JSlider slider;
    private JTextArea txtrSpeed;
    private JProgressBar progressBar;

    public Testor() {
        model = new Simulator();
        controller = new SimulatorController(model);
        carparkview = new SimulatorView(model);
        screen = new JFrame("Parkeer Simulator");
        screen.setSize(1000, 600);
        screen.setResizable(false);
        
        
        final JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		model.start();
        		button.setVisible(false);
        		button_2.setVisible(true);
        	}
        });
        
        button_2 = new JButton("Pause");
        button_2.setVisible(false);
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Method to pause
        		model.stop();
        		button_2.setVisible(false);
        		button.setVisible(true);
        	}
        });
        
        button_1 = new JButton("Step +1");
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		model.tick();
        	}
        });
        
        carparkview.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        txtrSpeed = new JTextArea();
        txtrSpeed.setBackground(UIManager.getColor("CheckBox.background"));
        txtrSpeed.setText("Speed");
        carparkview.add(txtrSpeed);
        
        slider = new JSlider(JSlider.HORIZONTAL,0,1000,500);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        slider.setInverted(true);
        
        Event e = new Event();
        slider.addChangeListener(e);
        
        carparkview.add(slider);
        
        Container contentPane = screen.getContentPane();
        
        JPanel panel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(screen.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(371)
        					.addComponent(button)
        					.addGap(5)
        					.addComponent(button_2)
        					.addGap(5)
        					.addComponent(button_1))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(100)
        					.addComponent(carparkview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(99)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(87, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(5)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(button)
        				.addComponent(button_2)
        				.addComponent(button_1))
        			.addGap(5)
        			.addComponent(carparkview, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(25))
        );
        
        progressBar = new JProgressBar();
        panel.add(progressBar);
        progressBar.setMaximum(480);
        progressBar.setValue(model.getAmountOfPresentCars());
        
        progressBar.setIndeterminate(true);
        screen.getContentPane().setLayout(groupLayout);
        
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //model.start();
        
        //Makes sure the parking spots are visible when starting up
        model.tick();
    }
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class Event implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int value = slider.getValue();
			Simulator.setTickPause(value);
		}
		
	}
}