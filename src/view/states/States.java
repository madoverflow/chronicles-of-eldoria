package view.states;

import javax.swing.*;

public class States {
    private static final StateDirector STATE_DIRECTOR = new StateDirector(new ConcreteStateBuilder());
    public static final JFrame sIncipit = States.STATE_DIRECTOR.makeStateIncipit();
    public static final JFrame S0 = States.STATE_DIRECTOR.makeState0();
    public static final JFrame S1 = States.STATE_DIRECTOR.makeState1();
    public static final JFrame S2 = States.STATE_DIRECTOR.makeState2();
    public static final JFrame S3 = States.STATE_DIRECTOR.makeState3();
    public static final JFrame S4 = States.STATE_DIRECTOR.makeState4();
    public static final JFrame S5 = States.STATE_DIRECTOR.makeState5();
    public static final JFrame S6 = States.STATE_DIRECTOR.makeState6();
    public static final JFrame S7 = States.STATE_DIRECTOR.makeState7();
    public static final JFrame S8 = States.STATE_DIRECTOR.makeState8();
    public static final JFrame S9 = States.STATE_DIRECTOR.makeState9();
    public static JFrame sCrypt = States.STATE_DIRECTOR.makeStateCrypt();
    public static final JFrame S10 = States.STATE_DIRECTOR.makeState10();
    public static final JFrame S11 = States.STATE_DIRECTOR.makeState11();
    public static final JFrame S12 = States.STATE_DIRECTOR.makeState12();
    public static final JFrame S13 = States.STATE_DIRECTOR.makeState13();

    public static void stateCrypt(){States.sCrypt = States.STATE_DIRECTOR.makeStateCrypt();};
}
