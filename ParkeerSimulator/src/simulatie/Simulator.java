package simulatie;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import simulatie.controller.SimulatorController;
import simulatie.model.Model;
import simulatie.view.AbstractView;
import simulatie.view.SimulatorView;

/**
 * 
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 *
 */

public class Simulator {
    private JFrame screen;
    private Model model;
    private AbstractView carparkview;

    private SimulatorController controller;

    public Simulator() {
        model = new Model();
        controller = new SimulatorController(model);
        carparkview = new SimulatorView(model);
        screen = new JFrame("Parkeer Simulator");
        screen.setSize(900, 500);
        screen.setResizable(false);

        screen.getContentPane().add(carparkview, BorderLayout.CENTER);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.start();
    }
}