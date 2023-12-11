package view.states;

import javax.swing.*;

public class States {
    private static final CreatorState CREATOR_FINAL_STATE = new ConcreteCreatorFinalState();
    private static final CreatorState CREATOR_NO_FINAL_STATE = new ConcreteCreatorNoFinalState();
    //stessa cosa per il director e concretebuilder

    //public static final JFrame S0 = States.CREATOR_NO_FINAL_STATE.createState(makePanelS0 del panel director);
}
