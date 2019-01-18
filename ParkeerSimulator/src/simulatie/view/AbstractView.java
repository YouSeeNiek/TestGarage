package simulatie.view;

import javax.swing.JPanel;

import simulatie.model.Model;

/**
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 */

public abstract class AbstractView extends JPanel{
    protected Model model;

    public AbstractView(Model model) {
        this.model = model;
        model.addView(this);
    }

    public Model getModel(){
        return model;
    }

    public void updateView(){
        repaint();
    }
}