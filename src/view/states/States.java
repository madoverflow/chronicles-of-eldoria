package view.states;

import javax.swing.*;

public class States {
    private static final StateDirector STATE_DIRECTOR = new StateDirector(new ConcreteStateBuilder());

    public static final JFrame STATE_MENU = States.STATE_DIRECTOR.makeStateMenu();
    public static final JFrame STATE_INCIPIT = States.STATE_DIRECTOR.makeStateIncipit();
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
    public static JFrame stateCrypt = States.STATE_DIRECTOR.makeStateCrypt();
    public static final JFrame S10 = States.STATE_DIRECTOR.makeState10();
    public static final JFrame S11 = States.STATE_DIRECTOR.makeState11();
    public static final JFrame S12 = States.STATE_DIRECTOR.makeState12();
    public static final JFrame S13 = States.STATE_DIRECTOR.makeState13();
    public static final JFrame STATE_TILES = States.STATE_DIRECTOR.makeStateTiles();
    public static final JFrame S14 = States.STATE_DIRECTOR.makeState14();
    public static final JFrame S15 = States.STATE_DIRECTOR.makeState15();
    public static final JFrame S16 = States.STATE_DIRECTOR.makeState16();
    public static final JFrame S17 = States.STATE_DIRECTOR.makeState17();
    public static final JFrame S18 = States.STATE_DIRECTOR.makeState18();
    public static final JFrame S19 = States.STATE_DIRECTOR.makeState19();

    public static void stateCrypt(){States.stateCrypt = States.STATE_DIRECTOR.makeStateCrypt();};
}
