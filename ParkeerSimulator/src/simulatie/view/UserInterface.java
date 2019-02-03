package simulatie.view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import simulatie.controller.SimulatorController;
import simulatie.model.Car;
import simulatie.model.Simulator;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

//import org.swtchart.Chart;

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
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 *
 */

public class UserInterface {
    private static JFrame screen;
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
    private JPanel panel_5;
    private JTextField txtParkingPassCar;
    private JTextField txtParkingPassCar_1;
    private JTextField txtReserveringen;
    private JTextField txtAbonnementsPlekken;
    private JTextField txtLeeg;
    private static JLabel dagLabel;
    private static int dag;
    private static int uur;
    private static int minuut;
    private JPanel panel_8;
    private static JLabel lblTijd;
    private JLabel lblLeeg;
    private JPanel panel_9;
    private JLabel lblLegePlekken;
    private JLabel label_2;
    private static JLabel openSpotsLabel;
    private JPanel panel_10;
    private JLabel lblBezettePlekken;
    private static JLabel occupiedSpotsLabel;
    private JLabel label_4;
    private JPanel panel_4;
    private JLabel show_image;
    private JPanel panel_11;
    private static JLabel lblProfit;
	private static AbstractButton label_3;
    private JPanel panel_13;
    private JLabel lblProfit_1;
    private JLabel label_5;
    private static JLabel lblNormalCar;
    private JPanel panel;
    private JPanel panel_3;
    private JLabel lblAantalNormaleAutos;
    private static JLabel label_6;
    private JLabel label_7;
    private JPanel panel_12;
    private JLabel lblReserveringen;
    private static JLabel label_9;
    private JLabel label_10;
    private JPanel panel_14;
    private JLabel lblAbbonnement;
    private static JLabel label_8;
    private JLabel label_11;
	private static ChartPanel chartpanel;
	private static Component frame1;
    //private PieChartCars piechart;
    

    public UserInterface() {
        model = new Simulator();
        controller = new SimulatorController(model);
        carparkview = new SimulatorView(model);
        carparkview.setBounds(169, 118, 804, 360);
        screen = new JFrame("Parkeer Simulator");
        screen.setSize(1200, 800);
        screen.setResizable(false);
        
        carparkview.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        Event e = new Event();
        
        Container contentPane = screen.getContentPane();
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(460, 6, 279, 34);
        
        panel_2 = new JPanel();
        panel_2.setBounds(491, 52, 218, 60);
        
        panel_5 = new JPanel();
        panel_5.setBounds(34, 177, 134, 115);
        
        JLabel lblCapacity = new JLabel("Capaciteit");
        lblCapacity.setBounds(568, 484, 63, 21);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(34, 304, 134, 101);
        
        panel_4 = new JPanel();
        panel_4.setBounds(34, 411, 134, 67);
        
        show_image = new JLabel("");
        show_image.setBounds(12, 14, 156, 42);
        show_image.setIcon(new ImageIcon(UserInterface.class.getResource("/img/logo1-01.png")));
        
        panel_11 = new JPanel();
        panel_11.setBounds(1223, 6, 0, 682);
        
        lblProfit = new JLabel("");
        lblProfit.setHorizontalAlignment(SwingConstants.LEFT);
        
        panel_13 = new JPanel();
        panel_13.setBounds(747, 6, 78, 75);
        
        lblProfit_1 = new JLabel("Profit:");
        lblProfit_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_13.add(lblProfit_1);
        panel_13.add(lblProfit);
        
        label_5 = new JLabel("");
        panel_13.add(label_5);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBounds(831, 6, 68, 75);
        
        JLabel lblDay = new JLabel("Dag:");
        panel_7.add(lblDay);
        
        
        
        dagLabel = new JLabel("");
        panel_7.add(dagLabel);
        
        panel_8 = new JPanel();
        panel_8.setBounds(905, 6, 68, 75);
        
        lblTijd = new JLabel("Tijd:");
        panel_8.add(lblTijd);
        
        lblTijd = new JLabel("");
        panel_8.add(lblTijd);
        
       
         
         progressBar = new JProgressBar();
         progressBar.setBounds(527, 511, 146, 20);
         progressBar.setStringPainted(true);
         progressBar.setToolTipText("");
         progressBar.setMaximum(540);
         progressBar.setMinimum(0);
        panel_11.setLayout(new GridLayout(0, 1, 0, 0));
        
        panel_9 = new JPanel();
        panel_4.add(panel_9);
        
        lblLegePlekken = new JLabel("Lege plekken:");
        lblLegePlekken.setHorizontalAlignment(SwingConstants.LEFT);
        panel_9.add(lblLegePlekken);
        
        openSpotsLabel = new JLabel("");
        panel_9.add(openSpotsLabel);
        
        label_2 = new JLabel("");
        panel_9.add(label_2);
        
        panel_10 = new JPanel();
        panel_4.add(panel_10);
        
        lblBezettePlekken = new JLabel("Bezette plekken:");
        lblBezettePlekken.setHorizontalAlignment(SwingConstants.LEFT);
        panel_10.add(lblBezettePlekken);
        
        occupiedSpotsLabel = new JLabel("");
        panel_10.add(occupiedSpotsLabel);
        
        label_4 = new JLabel("");
        panel_10.add(label_4);
    	
    	
        
        
        
        
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
        
        JLabel lblSnelheid = new JLabel("Snelheid");
        panel_2.add(lblSnelheid);
        
        slider = new JSlider(JSlider.HORIZONTAL,1,400,400);
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
        screen.getContentPane().setLayout(null);
        screen.getContentPane().add(panel_5);
        screen.getContentPane().add(panel_6);
        screen.getContentPane().add(panel_4);
        screen.getContentPane().add(show_image);
        screen.getContentPane().add(panel_1);
        screen.getContentPane().add(panel_2);
        screen.getContentPane().add(panel_13);
        screen.getContentPane().add(panel_7);
        screen.getContentPane().add(panel_8);
        screen.getContentPane().add(carparkview);
        screen.getContentPane().add(lblCapacity);
        screen.getContentPane().add(progressBar);
        screen.getContentPane().add(panel_11);
        
        
        
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Normaal", new Integer (0));        
        pieDataset.setValue("Reserveringen", new Long (0)); 
        pieDataset.setValue("Abonnement", new Long (0)); 
        
        JFreeChart chart = ChartFactory.createPieChart("Cirkel Diagram", pieDataset, true, true, true);
        
        chartpanel = new ChartPanel(chart);
        chartpanel.setLocation(831, 511);
        chartpanel.setVisible(true);
        chartpanel.setSize(363, 261);
        
        screen.getContentPane().add(chartpanel);
        
        
        
        //
        
        panel = new JPanel();
        panel.setBounds(505, 566, 190, 131);
        screen.getContentPane().add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        panel_3 = new JPanel();
        panel.add(panel_3);
        
        lblAantalNormaleAutos = new JLabel("Normaal:");
        lblAantalNormaleAutos.setHorizontalAlignment(SwingConstants.LEFT);
        panel_3.add(lblAantalNormaleAutos);
        
        label_6 = new JLabel("");
        panel_3.add(label_6);
        
        label_7 = new JLabel("");
        panel_3.add(label_7);
        
        panel_12 = new JPanel();
        panel.add(panel_12);
        
        lblReserveringen = new JLabel("Reserveringen:");
        lblReserveringen.setHorizontalAlignment(SwingConstants.LEFT);
        panel_12.add(lblReserveringen);
        
        label_9 = new JLabel("");
        panel_12.add(label_9);
        
        label_10 = new JLabel("");
        panel_12.add(label_10);
        
        panel_14 = new JPanel();
        panel.add(panel_14);
        
        lblAbbonnement = new JLabel("Abbonnement: ");
        lblAbbonnement.setHorizontalAlignment(SwingConstants.LEFT);
        panel_14.add(lblAbbonnement);
        
        label_8 = new JLabel("");
        panel_14.add(label_8);
        
        label_11 = new JLabel("");
        panel_14.add(label_11);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //BarChart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(10, "", "Normaal");
		dataset.setValue(100, "", "Reserveringen");
		dataset.setValue(40, "", "Abonnement");
		
		JFreeChart chart1 = ChartFactory.createBarChart("Staaf diagram van aantal auto's", "", "Aantal auto's", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot p = chart1.getCategoryPlot();
		p.setRangeGridlinePaint(Color.GREEN);
		
		
		frame1 = new ChartPanel(chart1);
		frame1.setLocation(0, 511);
		
        screen.getContentPane().add(frame1);
        
        frame1.setVisible(true);
        frame1.setSize(363, 261);
		
		
		
		
		
		
		
        
        //Makes sure the parking spots are visible when starting up
        model.tick();
    }
    
    
    
	//Method to update the progressBar
    public static void setProgressValue(int numberOfCars, int numberOfNormalCars, long numberOfReservedCars, long numberOfParkingPassCars) {
    	progressBar.setValue(numberOfCars);
    	
    	String str = Integer.toString(numberOfNormalCars);
    	label_6.setText(str + " auto's");
    	
    	String str1 = Long.toString(numberOfReservedCars);
    	label_9.setText(str1 + " auto's");
    	
    	String str2 = Long.toString(numberOfParkingPassCars);
    	label_8.setText(str2 + " auto's");
    	
    }
    
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	//Slider
	private class Event implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int value = slider.getValue();
			Simulator.setTickPause(value);
		}
		
	}

	//Method to update the day and time..
	public static void setAll(int day, int hour, int minute) {
		dag = day;
		uur = hour;
		minuut = minute;
	
		switch (dag) {
			case 0:
				dagLabel.setText("Maandag");
				break;	
			case 1:
				dagLabel.setText("Dinsdag");
				break;	
			case 2:
				dagLabel.setText("Woensdag");
				break;	
			case 3:
				dagLabel.setText("Donderdag");
				break;
			case 4:
				dagLabel.setText("Vrijdag");
				break;
			case 5:
				dagLabel.setText("Zaterdag");
				break;
			case 6:
				dagLabel.setText("Zondag");
				break;
			}
		String str1 = Integer.toString(uur);
		String str2 = Integer.toString(minuut);
		
		if (uur < 10) {
			str1 = "0" + Integer.toString(uur);
		} 
		
		if (minuut < 10) {
			str2 = "0" + Integer.toString(minuut);
		} 
		
		String concat = str1+":"+str2;
		lblTijd.setText(concat);
		
	}

	//Set number of open spots
	public static void setNumberOfOpenTotalSpots(int numberOfOpenTotalSpots) {
		// TODO Auto-generated method stub
				String str3 = Integer.toString(numberOfOpenTotalSpots);
				openSpotsLabel.setText(str3);
	}
	
	//Set number of occupied spots
	public static void setNumberOfOccupiedSpots(int numberOfOccupiedSpots) {
		// TODO Auto-generated method stub
				String str4 = Integer.toString(numberOfOccupiedSpots);
				occupiedSpotsLabel.setText(str4);
	}

	//Set cumulative profit
	public static void setCumulativeProfit(double turnoverTotal) {
		double roundOff = Math.round(turnoverTotal * 100.0) / 100.0;
		String str5 = "€ " + Double.toString(roundOff);
		lblProfit.setText(str5); 
		
	}
	
	
	
	
	
	
	public static void updatePieChart(int red, long blue, long green) {
		
		screen.getContentPane().remove(chartpanel);
		
		DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Normaal", new Integer (red));        
        pieDataset.setValue("Reserveringen", new Long (blue)); 
        pieDataset.setValue("Abonnement", new Long (green)); 
        
        
        JFreeChart chart = ChartFactory.createPieChart("Cirkel Diagram", pieDataset, true, true, true);
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        plot.setSectionPaint("Normaal", new Color(255, 0, 0));
        plot.setSectionPaint("Reserveringen", new Color(0,0,255));
        plot.setSectionPaint("Abonnement", new Color(139,0,139));
        
        chartpanel = new ChartPanel(chart);
        chartpanel.setLocation(831, 511);
        chartpanel.setVisible(true);
        chartpanel.setSize(363, 261);
        
        
        screen.getContentPane().add(chartpanel);   
        screen.getContentPane().repaint();
        
	}



	public static void updateBarChart(int aantalAdHoc, long aantalReserved, long aantalPass) {
		
		double one = (int) aantalAdHoc;
		double two = (long) aantalReserved;
		double three = (long) aantalPass;
		
		screen.getContentPane().remove(frame1);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(one, "", "Normaal");
		dataset.setValue(two, "", "Reserveringen");
		dataset.setValue(three, "", "Abonnement");
		
		JFreeChart chart1 = ChartFactory.createBarChart("Staaf diagram van aantal auto's", "", "Aantal auto's", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot p = chart1.getCategoryPlot();
		p.setRangeGridlinePaint(Color.GREEN);
		
		
		frame1 = new ChartPanel(chart1);
		frame1.setLocation(0, 511);
		
        screen.getContentPane().add(frame1);
        
        frame1.setVisible(true);
        frame1.setSize(363, 261);
		
        screen.getContentPane().add(frame1);
        screen.getContentPane().repaint();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}