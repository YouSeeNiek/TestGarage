package simulatie.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import simulatie.model.Model;


/**
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 */

public class SimulatorController extends JPanel implements ActionListener {

	private Model model;
	
    public SimulatorController(Model model){
        this.model = model;
        this.setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {

    }

}