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

    public JFrame makeStateIncipit(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelIncipit());
        return this.stateBuilder.build();
    }
    public JFrame makeState0(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS0());
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

    public JFrame makeState3(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS3());
        return this.stateBuilder.build();
    }

    public JFrame makeState4(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS4());
        return this.stateBuilder.build();
    }

    public JFrame makeState5(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS5());
        return this.stateBuilder.build();
    }
    public JFrame makeState6() {
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS6());
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

    public JFrame makeState9(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS9());
        return this.stateBuilder.build();
    }
    public JFrame makeStateCrypt(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelCrypt());
        return this.stateBuilder.build();
    }

    public JFrame makeState10(){
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS10());
        return this.stateBuilder.build();
    }

    public JFrame makeState11() {
        this.stateBuilder.reset();
        this.stateBuilder.buildBackground("src/model/assets/sfondo.png");
        this.stateBuilder.buildPanel(this.panelDirector.makePanelS11());
        return this.stateBuilder.build();
    }
}
