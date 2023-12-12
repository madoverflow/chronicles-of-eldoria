package view.states;

import javax.swing.*;

public class States {
    private static final StateDirector NON_FINAL_STATE_DIRECTOR = new StateDirector(new ConcreteNonFinalStateBuilder());
    private static final StateDirector FINAL_STATE_DIRECTOR = new StateDirector(new ConcreteFinalStateBuilder());
    public static final JFrame S0 = States.NON_FINAL_STATE_DIRECTOR.makeState0();
}
