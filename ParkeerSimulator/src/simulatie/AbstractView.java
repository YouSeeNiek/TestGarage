package simulatie;

import javax.swing.JPanel;

import simulatie.model.Simulator;

/**
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 */

public abstract class AbstractView extends JPanel{
    protected Simulator model;

    public AbstractView(Simulator model) {
        this.model = model;
        model.addView(this);
    }

    public Simulator getModel(){
        return model;
    }

    public void updateView(){
        repaint();
    }
}