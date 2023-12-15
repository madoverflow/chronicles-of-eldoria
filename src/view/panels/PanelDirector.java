package view.panels;

import model.crypt.ConcreteHistory;
import model.crypt.ConcretePalindromic;
import model.crypt.ConcretePrimes;
import model.crypt.Crypt;
import model.items.ConcreteItemBuilder;
import model.items.ItemDirector;
import model.npc.*;
import model.player.Eren;
import model.player.Player;
import view.buttons.ButtonBuilder;
import view.buttons.ConcreteButtonBuilder;
import view.scroll.ConcreteScrollBuilder;
import view.scroll.ScrollBuilder;
import view.states.States;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystems;

public class PanelDirector {
    private PanelBuilder panelBuilder;
    private final ScrollBuilder scrollBuilder = new ConcreteScrollBuilder();
    private final ButtonBuilder buttonBuilder = new ConcreteButtonBuilder();
    private final Player eren = Eren.getInstance(); //Riferimento al protagonista da usare per gli oggetti
    private final ItemDirector itemDirector = new ItemDirector(new ConcreteItemBuilder());
    private static final Crypt CRYPT = Crypt.getInstance();

    public PanelDirector(PanelBuilder panelBuilder) {
        this.panelBuilder = panelBuilder;
    }

    public void changeBuilder(PanelBuilder panelBuilder) {
        this.panelBuilder = panelBuilder;
    }

    public JPanel makePanelS0() {
        this.panelBuilder.reset();
        //scroll
        this.scrollBuilder.reset();
        this.scrollBuilder.buildDimension(25, 25, 275, 275);
        this.scrollBuilder.buildText("Eren, sei un contadino della periferia di Eldoria. Come tutti i giorni, stai lavorando sui tuoi terreni quando ad un tratto qualcosa di metallico si scontra con la tua pala\n\n\n"
                + "CLANG!\n\n\n"
                + "E’ una pietra dalle sembianze simili alla Pietra dell’Aurora di cui narra la leggenda.\n\n\n"
                + "LA VUOI RACCOGLIERE?"
        );
        //labelimage
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath("src/model/assets/contadino.png")
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        labelBackgroundImage.setBounds(350, 25, 175, 275);
        //bottone SI
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(325, 335, 125, 30);
        this.buttonBuilder.buildText("SI");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S0.setVisible(false);
            States.S1.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        //bottone NO
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(100, 335, 125, 30);
        this.buttonBuilder.buildText("NO");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        JButton button2 = this.buttonBuilder.build();
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), labelBackgroundImage, button1, button2);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS1() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 275);
        this.scrollBuilder.buildText("Afferrando la pietra hai avuto una visione su ciò che era Eldoria prima che " +
                "l’Ordine delle Ombre ne prendesse il controllo. Tu sei il prescelto. Il tuo compito è di portare la " +
                "Pietra dell’Aurora al centro di Eldoria e di posizionarla in cima alla statua per riportare la luce " +
                "e ristabilire la pace sull’intero regno. Il tuo cammino è appena iniziato giovane contadino. Come ti " +
                "ha detto Gideon, l’anziano sacerdote, nella visione, recati da Cedric, il druido del Bosco degli " +
                "Spiriti Avvolti.");
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Vai da Cedric");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S1.setVisible(false);
            States.S2.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS2() {
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath(Cedric.getInstance().getImagePath())
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 25, 305, 275);
        this.scrollBuilder.buildText("Cedric: salve giovane avventuriero…non riesco a credere ai miei occhi, stai " +
                "brandendo la Pietra dell’Aurora quindi sei tu il prescelto della profezia, colui che riporterà la " +
                "luce ad Eldoria e restaurerà la pace. Eldoria sta vivendo dei tempi bui e la città pullula di soldati " +
                "dell’Ordine delle Ombre. Ci sarebbe una strada alternativa che porta direttamente alle cripte della " +
                "città, situate al centro di Eldoria, sotto la statua. Tuttavia, questo cammino può essere percorso " +
                "solo addentrandoti dentro il Bosco degli Spiriti Avvolti. La strada è tortuosa e piena di insidie. " +
                "Gideon, fu l’unico essere ad averlo percorso e ad essere sopravvissuto. Sbrigati, giovane avventuriero" +
                ", Sauron può avvertire l’essenza della Pietra dell’Aurora e non tarderà a cercarla. Il destino di " +
                "Eldoria è nelle tue mani. ");
        labelBackgroundImage.setBounds(320, 25, 235, 275);
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Avventurati");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S2.setVisible(false);
            States.S3.setVisible(true);
        });

        this.panelBuilder.buildComponents(this.scrollBuilder.build(), labelBackgroundImage, this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS3() {
        this.panelBuilder.reset();
        //scroll
        this.scrollBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 275);
        this.scrollBuilder.buildText("Se avanti vuoi andare, il bivio devi oltrepassare.\n\n\n" +
                "Due sentieri s'aprono al tuo cammino,\n" +
                "Uno più difficile, un destino divino.\n" +
                "La luce risplende in uno, ma attento...\n" +
                "Nel buio nasce spesso l'avvento.\n\n\n" +
                "Quale sentiero scegli?");
        //bottone SI
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(325, 335, 125, 30);
        this.buttonBuilder.buildText("DESTRA");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S3.setVisible(false);
            States.S5.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        //bottone NO
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(100, 335, 125, 30);
        this.buttonBuilder.buildText("SINISTRA");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S3.setVisible(false);
            States.S4.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, button2);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS4() { //Inserire ascoltatore sui bottoni per andare ad S5
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath("src/model/assets/wood state.png")
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 25, 305, 275);
        this.scrollBuilder.buildText("Ti incammini lungo il sentiero e osservi una tavola di legno.\n" +
                "\n" + "Vuoi raccoglierla?");
        labelBackgroundImage.setBounds(320, 25, 235, 275);
        this.buttonBuilder.buildDimension(120, 335, 125, 30);
        this.buttonBuilder.buildText("Si");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            eren.getItem(itemDirector.constructBoard());
            States.S4.setVisible(false);
            States.S6.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(290, 335, 125, 30);
        this.buttonBuilder.buildText("No");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S4.setVisible(false);
            States.S6.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), labelBackgroundImage, button1, button2);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS5() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        JTextField inputTextField = new JTextField();
        this.scrollBuilder.buildDimension(80, 0, 380, 275);
        this.scrollBuilder.buildText("Ti trovi davanti ad un fiume e devi attraversarlo per proseguire la tua avventura.\n" +
                "Un cartello posto in prossimità recita:\n\n" +
                "\"Se il fiume vorrai attraversare, l’indovinello dovrai indovinare\".\n\n***\nIndovina indovinello:\n" +
                "io guido un bel battello,\nse voglio cambio direzione,\navrai capito sono il…\n***");
        inputTextField.setBounds(215,290,125,30);
        inputTextField.setToolTipText("Inserisci qui la risposta");
        inputTextField.setHorizontalAlignment(JTextField.CENTER);
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Conferma");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            if (inputTextField.getText().equalsIgnoreCase("timone")) {
                JOptionPane.showMessageDialog(null,"Delle pietre emergono dal fiume e compongono " +
                        "un passaggio.\nAdesso puoi attraversarlo!");
                States.S5.setVisible(false);
                States.S7.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Hai sbagliato! Riprova.");
            }
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),inputTextField,this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS6() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 200);
        this.scrollBuilder.buildText("Ti trovi davanti ad un fiume e devi attraversarlo per proseguire la tua " +
                "avventura.");
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(325, 335, 125, 30);
        this.buttonBuilder.buildText("AVVENTURATI");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            if(eren.useItem(itemDirector.constructBoard())){
                JOptionPane.showMessageDialog(null,"Posizionando la tavola di legno in verticale " +
                        "sopra il fiume, è di una dimensione sufficiente per creare un piccolo ponte. " +
                        "\nComplimenti! Puoi attraversare il fiume");
                States.S6.setVisible(false);
                States.S7.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"Quanto sarebbe bello se avessi una tavola " +
                        "di legno...");
            }
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(100, 335, 125, 30);
        this.buttonBuilder.buildText("INDIETRO");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S6.setVisible(false);
            States.S4.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, button2);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS7(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87,25,375,275);
        this.scrollBuilder.buildText("Durante il tuo cammino, senti degli strani versi e delle urla provenire da un " +
                "sentiero non molto lontano da te. Il coraggio scorre nelle tue vene e decidi di prendere una piccola " +
                "deviazione per scoprire cosa stia succedendo. Giunto a destinazione, osservi che un terribile Orco sta " +
                "attaccando un essere femminile dalle sembianze elfiche. Cosa decidi di fare?");
        this.buttonBuilder.buildDimension(90,335,125,30);
        this.buttonBuilder.buildText("Aiuto l'elfo");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S7.setVisible(false);
            States.S8.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(260,335,200,30);
        this.buttonBuilder.buildText("Continuo per la mia strada");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        JButton button2 = this.buttonBuilder.build();
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),button1,button2);
        return this.panelBuilder.build();
    }
    public JPanel makePanelS8(){
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath(Lythien.getInstance().getImagePath())
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0,25,305,275);
        this.scrollBuilder.buildText("L’orco, creatura maestosa e tenebrosa, si scaglia su di te con tutte le sue forze. " +
                "La sua forza è di gran lunga superiore alla tua e ormai tutto sembra essere perduto quando ad un tratto, " +
                "una voce familiare a quella di Gideon, ti suggerisce di afferrare la Pietra dell’Aurora. " +
                "Brandendo la pietra dell’Aurora e il cuore che pompa all’impazzata, un raggio luminoso si scaglia contro " +
                "l’orco accecandolo. Sfruttando la preziosa occasione, afferri l’elfo e scappate velocemente seminando l’Orco.\n" +
                "\n" +
                "…\n" +
                "\n" +
                "Lythien: ti ringrazio giovane avventuriero. Il mio nome è Lythien ed appartengo alla razza degli elfi. " +
                "Un tempo governavo sul regno di Elverion, fino a quando Sauron, il Signore delle Ombre, seminò il terrore. " +
                "Dall’ora mi rifugio in questo bosco, unico posto in cui le forze armate di Sauron non sono così pazze da " +
                "entrare. Creature tenebrose e maestose si aggirano per questo bosco. Noi elfi siamo molto riconoscenti. " +
                "Ti devo un favore. Adesso ti lascio giovane avventuriero, torno tra i miei compagni che mi hanno seguito " +
                "in questo folle viaggio in attesa che qualcuno ponga fine all’Ordine delle ombre.");
        labelBackgroundImage.setBounds(320,25,235,275);
        this.buttonBuilder.buildDimension(215,335,125,30);
        this.buttonBuilder.buildText("Prosegui");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),labelBackgroundImage,this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS9(){
        JButton palindromicButton, historyButton, primesButton;
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(25,0,505,295);
        this.scrollBuilder.buildText("Giungi davanti alla porta delle cripte. Su di essa è scolpito\n\n" +
                "Scegli tra gli enigmi uno dei tre,\n" +
                "Il superamento, la chiave sarà per me.\n" +
                "Accedere al mio interno, l'arte svelerà,\n" +
                "Con risposte sagge, la porta si spalancherà.");
        this.buttonBuilder.buildDimension(45,335,185,30);
        this.buttonBuilder.buildText("Numero parole palindrome");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event ->{
            PanelDirector.CRYPT.setMessage(ConcretePalindromic.getInstance().getEnigma());
            PanelDirector.CRYPT.setStrategy(ConcretePalindromic.getInstance());
            States.stateCrypt();
            States.S9.setVisible(false);
            States.sCrypt.setVisible(true);
        });
        this.buttonBuilder.buildTip("Contare le parole palindrome escluse sotto parole");
        palindromicButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(240,335,125,30);
        this.buttonBuilder.buildText("Storia di Eldoria");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event ->{
            PanelDirector.CRYPT.setMessage(ConcreteHistory.getInstance().getEnigma());
            PanelDirector.CRYPT.setStrategy(ConcreteHistory.getInstance());
            States.stateCrypt();
            States.S9.setVisible(false);
            States.sCrypt.setVisible(true);
        });
        historyButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(375,335,125,30);
        this.buttonBuilder.buildText("Numeri primi");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event ->{
            PanelDirector.CRYPT.setMessage(ConcretePrimes.getInstance().getEnigma());
            PanelDirector.CRYPT.setStrategy(ConcretePrimes.getInstance());
            States.stateCrypt();
            States.S9.setVisible(false);
            States.sCrypt.setVisible(true);
        });
        this.buttonBuilder.buildTip("Scrivere i numeri separati da uno spazio bianco");
        primesButton = this.buttonBuilder.build();
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),palindromicButton,historyButton,primesButton);
        return this.panelBuilder.build();
    }

    public JPanel makePanelCrypt() {
        JTextField textField = new JTextField();
        JButton openButton, backButton;
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(25, 100, 505, 105);
        this.scrollBuilder.buildText(PanelDirector.CRYPT.getMessage());
        this.buttonBuilder.buildDimension(183, 300, 185, 30);
        this.buttonBuilder.buildText("Apri");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            if (PanelDirector.CRYPT.open(textField.getText())) {
                States.sCrypt.setVisible(false);
                States.S1.setVisible(true);
            } else
                JOptionPane.showMessageDialog(null, "Hai sbagliato la risposta.\nRitenta o cambia" +
                        " enigma\nLa cripta è rimasta chiusa.");
        });
        openButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(183, 350, 185, 30);
        this.buttonBuilder.buildText("Indietro");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.sCrypt.setVisible(false);
            States.S9.setVisible(true);
        });
        backButton = this.buttonBuilder.build();
        textField.setBounds(183, 235, 185, 30);
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), textField, openButton, backButton);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS10() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 275);
        this.scrollBuilder.buildText("L’interno delle cripte risulta poco luminoso. \nAvventurarti con questa scarsa luminosità risulta impossibile."+
                "Caso vuole che attorno a te ci sono delle fiaccole."+
                "\n Vedendole, capisce che sarà necessario prenderne una per continuare il viaggio.");
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Afferra fiaccola");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f, 0.29f, 0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            eren.getItem(itemDirector.constructLight());
            States.S10.setVisible(false);
            States.S11.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS11(){
        return null;
    }
}
