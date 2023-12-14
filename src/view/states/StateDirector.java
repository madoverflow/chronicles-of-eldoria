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

    public JFrame makeState1(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS1());
        return this.stateBuilder.build();
    }

    public JFrame makeState2(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS2());
        return this.stateBuilder.build();
    }

    public JFrame makeState7(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS7());
        return this.stateBuilder.build();
    }
    public JFrame makeState8(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS8());
        return this.stateBuilder.build();
    }
}
