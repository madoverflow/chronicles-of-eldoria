package view.states;

import javax.swing.*;

public class States {
    private static final StateDirector NON_FINAL_STATE_DIRECTOR = new StateDirector(new ConcreteNonFinalStateBuilder());
    private static final StateDirector FINAL_STATE_DIRECTOR = new StateDirector(new ConcreteFinalStateBuilder());
    public static final JFrame S0 = States.NON_FINAL_STATE_DIRECTOR.makeState0();
    public static final JFrame S1 = States.NON_FINAL_STATE_DIRECTOR.makeState1();
    public static final JFrame S2 = States.NON_FINAL_STATE_DIRECTOR.makeState2();
    public static final JFrame S3 = States.NON_FINAL_STATE_DIRECTOR.makeState3();
    public static final JFrame S4 = States.NON_FINAL_STATE_DIRECTOR.makeState4();
    public static final JFrame S5 = States.NON_FINAL_STATE_DIRECTOR.makeState5();

    public static final JFrame S7 = States.NON_FINAL_STATE_DIRECTOR.makeState7();
    public static final JFrame S8 = States.NON_FINAL_STATE_DIRECTOR.makeState8();
}
