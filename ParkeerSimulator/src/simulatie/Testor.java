package simulatie;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
import java.awt.Label;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JLabel;

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
    private static JProgressBar progressBar;
    private Label label;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_5;
    private JTextField txtParkingPassCar;
    private JTextField txtParkingPassCar_1;
    private JTextField txtReserveringen;
    private JTextField txtAbonnementsPlekken;
    private JTextField txtLeeg;

    public Testor() {
        model = new Simulator();
        controller = new SimulatorController(model);
        carparkview = new SimulatorView(model);
        screen = new JFrame("Parkeer Simulator");
        screen.setSize(1200, 700);
        screen.setResizable(false);
        
        carparkview.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        Event e = new Event();
        
        Container contentPane = screen.getContentPane();
        
        JPanel panel = new JPanel();
        
        JPanel panel_1 = new JPanel();
        
        panel_2 = new JPanel();
        
        JPanel panel_4 = new JPanel();
        
        panel_3 = new JPanel();
        
        panel_5 = new JPanel();
        
        JLabel lblCapacity = new JLabel("Capaciteit");
        
        JLabel lblSnelheid = new JLabel("Snelheid");
        
        JPanel panel_6 = new JPanel();
        GroupLayout groupLayout = new GroupLayout(screen.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(193)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(96)
        					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(panel_6, 0, 0, Short.MAX_VALUE)
        						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(6)
        							.addComponent(carparkview, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(406)
        							.addComponent(lblSnelheid, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(232)
        							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(298)
        							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(569)
        					.addComponent(lblCapacity)))
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblSnelheid)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        					.addGap(27)
        					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(carparkview, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        			.addGap(18)
        			.addComponent(lblCapacity)
        			.addGap(2)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        JLabel lblPlaatsen = new JLabel("Plaatsen");
        panel_6.add(lblPlaatsen);
        
        txtLeeg = new JTextField();
        panel_6.add(txtLeeg);
        txtLeeg.setText("Leeg");
        txtLeeg.setHorizontalAlignment(SwingConstants.CENTER);
        txtLeeg.setForeground(Color.BLACK);
        txtLeeg.setEditable(false);
        txtLeeg.setColumns(10);
        txtLeeg.setBackground(new Color(255, 255, 255));
        
        txtAbonnementsPlekken = new JTextField();
        panel_6.add(txtAbonnementsPlekken);
        txtAbonnementsPlekken.setText("Abonnees leeg");
        txtAbonnementsPlekken.setHorizontalAlignment(SwingConstants.CENTER);
        txtAbonnementsPlekken.setForeground(Color.BLACK);
        txtAbonnementsPlekken.setEditable(false);
        txtAbonnementsPlekken.setColumns(10);
        txtAbonnementsPlekken.setBackground(new Color(255,198,255));
        
        JLabel lblCars = new JLabel("Auto's");
        panel_5.add(lblCars);
        
        txtParkingPassCar = new JTextField();
        txtParkingPassCar.setHorizontalAlignment(SwingConstants.CENTER);
        txtParkingPassCar.setText("Normaal");
        txtParkingPassCar.setEditable(false);
        txtParkingPassCar.setForeground(Color.WHITE);
        txtParkingPassCar.setColumns(10);
        txtParkingPassCar.setBackground(Color.RED);
        panel_5.add(txtParkingPassCar);
        
        txtReserveringen = new JTextField();
        txtReserveringen.setText("Reserveringen");
        txtReserveringen.setHorizontalAlignment(SwingConstants.CENTER);
        txtReserveringen.setForeground(Color.WHITE);
        txtReserveringen.setEditable(false);
        txtReserveringen.setColumns(10);
        txtReserveringen.setBackground(Color.BLUE);
        panel_5.add(txtReserveringen);
        
        txtParkingPassCar_1 = new JTextField();
        txtParkingPassCar_1.setText("Abonnement");
        txtParkingPassCar_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtParkingPassCar_1.setForeground(new Color(255, 255, 255));
        txtParkingPassCar_1.setEditable(false);
        txtParkingPassCar_1.setColumns(10);
        txtParkingPassCar_1.setBackground(new Color(139,0,139));
        panel_5.add(txtParkingPassCar_1);
        
        JSeparator separator = new JSeparator();
        panel_5.add(separator);
        
        slider = new JSlider(JSlider.HORIZONTAL,10,1000,500);
        panel_2.add(slider);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        slider.setInverted(true);
        slider.addChangeListener(e);
        
        
        final JButton button = new JButton("Start");
        panel_1.add(button);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		model.start();
        		button.setVisible(false);
        		button_2.setVisible(true);
        		
        	}
        });
        
        button_2 = new JButton("Pause");
        panel_1.add(button_2);
        button_2.setVisible(false);
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Method to pause
        		model.pause();
        		button_2.setVisible(false);
        		button.setVisible(true);
        	}
        });
        
        button_1 = new JButton("Step +1");
        panel_1.add(button_1);
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		model.tick();
        	}
        });
       
       
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setToolTipText("");
        panel.add(progressBar);
        progressBar.setMaximum(540);
        progressBar.setMinimum(0);
       
        
        
        screen.getContentPane().setLayout(groupLayout);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //model.start();
        
        //Makes sure the parking spots are visible when starting up
        model.tick();
    }
    
    //Method to update the progressBar
    public static void setProgressValue(int numberOfCars) {
    	progressBar.setValue(numberOfCars);
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