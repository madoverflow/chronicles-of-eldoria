package view.states;

import view.panels.ConcreteStatePanelBuilder;
import view.panels.PanelDirector;

import javax.swing.*;

public class StateDirector {
    private StateBuilder stateBuilder;
    private final PanelDirector panelDirector = new PanelDirector(new ConcreteStatePanelBuilder());

    public StateDirector(StateBuilder stateBuilder){
        this.stateBuilder = stateBuilder;
    }

    public void changeBuilder(StateBuilder stateBuilder){
        this.stateBuilder = stateBuilder;
    }

    public JFrame makeState0(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("img");
        //this.stateBuilder.buildPanel(this.panelDirector.makePanelS0); va tolto il commento alla riga quando si crea il makePanelS0 in PanelDirector
        return this.stateBuilder.build();
    }
}
