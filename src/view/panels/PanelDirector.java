package view.panels;

import controller.InventoryMouseListener;
import model.crypt.ConcreteHistory;
import model.crypt.ConcretePalindromic;
import model.crypt.ConcretePrimes;
import model.crypt.Crypt;
import model.items.ConcreteItemBuilder;
import model.items.ItemDirector;
import model.npc.Npc;
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
import java.util.List;

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

    public JPanel makePanelMenu(){
        JLabel title = new JLabel("CHRONICLES OF ELDORIA");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 48));
        title.setBounds(100, 15, 600, 100);
        this.panelBuilder.reset();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildText("START");
        this.buttonBuilder.buildDimension(315, 445, 175, 75);
        this.buttonBuilder.buildForegroundColor(Color.BLACK);
        this.buttonBuilder.builFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.buttonBuilder.buildListener(event -> {
            States.STATE_MENU.setVisible(false);
            States.STATE_INCIPIT.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.buttonBuilder.build(),title);
        return this.panelBuilder.build();
    }
    public JPanel makePanelIncipit() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 0, 550, 300); //550x400
        this.scrollBuilder.buildText("Ci troviamo nel regno magico di \"Eldoria\", il regno della luce.\n" +
                "Al centro di tale regno, è presente una statua con in cima un talismano: \"Pietra dell’Aurora\".\n" +
                "Questa pietra permette di convogliare la luce del sole e della luna in un unico punto rendendola così " +
                "una fonte che alimenta la magia di Eldoria ed un cerchio ristretto di abitanti chiamati \"I Sacerdoti " +
                "della Luce Astrale\", il cui compito è quello di sfruttare la magia della luce per avvolgere Eldoria in " +
                "uno scudo di luce che protegge il regno dalle forze oscure esterne.\nGrazie ai Sacerdoti della Luce " +
                "Astrale, il regno di Eldoria viveva nella pace e nella prosperità da secoli.\nTuttavia, ben presto Eldoria " +
                "sarebbe stata avvolta dall’oscurità a causa di un’entità malvagia: \"Sauron, il Signore delle Ombre\".\n" +
                "Era noto per il suo dominio di terrore e fama di conquista, i quali avevano ormai coinvolti tutti i regni " +
                "attorno ad Eldoria.\nEldoria sarebbe stata l’ultimo tassello del puzzle per Sauron, se non fosse per i " +
                "Sarcedoti della Luce Astrale, i quali erano riusciti a proteggerla per tutto questo tempo.\nPurtroppo " +
                "in un fatidico giorno si verificò una strana anomalia per cui lo scudo di luce, seppur in minima parte, " +
                "s’indebolì generando una piccola frattura sulla sua superficie.\nSauron non aspettava nient’altro che un " +
                "evento del genere per poter infiltrarsi ad Eldoria e fare in modo che lo scudo di luce crollasse per sempre.\n" +
                "Sfruttando questa piccola frattura, egli riuscì attraverso la sua enorme potenza nella magia oscura a far " +
                "cadere la Pietra dell’Aurora dalla statua di Eldoria facendo in modo che tutta la magia, la luce e di " +
                "conseguenza lo scudo, scomparissero da Eldoria. La scomparsa dello scudo, permise a lui ed alle sue armate, " +
                "di conquistare tutto ciò che incontrò nel suo cammino fino al centro del regno.\nL’obiettivo? Conquistare " +
                "Eldoria ed in particolare eliminare per sempre l’Ordine dei Sacerdoti della Luce Astrale, così da estirpare " +
                "per sempre la magia della luce da Eldoria e completare il dominio su tutti i regni.\nTuttavia nel caos " +
                "della battaglia, \"Gideon\", l’anziano sacerdote, riesce ad afferrare la pietra e a sfuggire, il tempo necessario, " +
                "alle forze delle ombre, per lanciare un incantesimo che avrebbe trasferito un pezzo della sua anima all’interno " +
                "della pietra per poi nasconderla da Sauron fino a quando un giovane erede dei Sacerdoti della Luce Astrale, " +
                "l’avrebbe ritrovata entrando così in contatto con quest’ultima e conoscendo la verità su ciò che è stato " +
                "e riportare Eldoria agli antichi splendori dopo la conquista del Signore delle Ombre.\nDa quel giorno, " +
                "calarono le tenebre su Eldoria e il Regno delle Ombre ebbe inizio.\nDella pietra non si seppe più nulla " +
                "e la verità, col tempo, divenne leggenda…");
        this.buttonBuilder.buildDimension(203, 335, 150, 30);
        this.buttonBuilder.buildText("Inizia l'avventura");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.STATE_INCIPIT.setVisible(false);
            States.S0.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, inventory);
        return this.panelBuilder.build();
    }
    public JPanel makePanelS0() {
        this.panelBuilder.reset();
        //scroll
        this.scrollBuilder.reset();
        this.scrollBuilder.buildDimension(25, 25, 275, 275);
        this.scrollBuilder.buildText("Eren, sei un contadino della periferia di Eldoria. Come tutti i giorni, stai lavorando sui tuoi terreni quando ad un tratto qualcosa di metallico si scontra con la tua pala\n\n"
                + "CLANG!\n\n"
                + "E’ una pietra dalle sembianze simili alla Pietra dell’Aurora di cui narra la leggenda.\n\n"
                + "La vuoi raccogliere?"
        );
        //labelimage
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath("src/model/assets/eren.png")
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        labelBackgroundImage.setBounds(325, 25, 235, 275);
        //bottone SI
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(325, 335, 125, 30);
        this.buttonBuilder.buildText("Si");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            eren.getItem(itemDirector.constructStone());
            States.S0.setVisible(false);
            States.S1.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        //bottone NO
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(100, 335, 125, 30);
        this.buttonBuilder.buildText("No");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            JOptionPane.showMessageDialog(null,"Consiglio: raccogli la pietra!");
        });
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), labelBackgroundImage, button1, button2,inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS1() {
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath("src/model/assets/stone state.png")
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 25, 305, 275);
        this.scrollBuilder.buildText("Afferrando la pietra hai avuto una visione su ciò che era Eldoria prima che " +
                "l’Ordine delle Ombre ne prendesse il controllo. Tu sei il prescelto. Il tuo compito è di portare la " +
                "Pietra dell’Aurora al centro di Eldoria e di posizionarla in cima alla statua per riportare la luce " +
                "e ristabilire la pace sull’intero regno. Il tuo cammino è appena iniziato giovane contadino. Come ti " +
                "ha detto Gideon, l’anziano sacerdote, nella visione, recati da Cedric, il druido del Bosco degli " +
                "Spiriti Avvolti.");
        labelBackgroundImage.setBounds(320, 25, 235, 275);
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Vai da Cedric");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S1.setVisible(false);
            States.S2.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, labelBackgroundImage, inventory);
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S2.setVisible(false);
            States.S3.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), labelBackgroundImage, button1, inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS3() {
        this.panelBuilder.reset();
        //scroll
        this.scrollBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 275);
        this.scrollBuilder.buildText("Se avanti vuoi andare, il bivio devi oltrepassare.\n\n" +
                "Due sentieri s'aprono al tuo cammino,\n" +
                "Uno più difficile, un destino divino.\n" +
                "La luce risplende in uno, ma attento...\n" +
                "Nel buio nasce spesso l'avvento.\n\n" +
                "Quale sentiero scegli?");

        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(325, 335, 125, 30);
        this.buttonBuilder.buildText("Destra");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S3.setVisible(false);
            States.S5.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();

        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(100, 335, 125, 30);
        this.buttonBuilder.buildText("Sinistra");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S3.setVisible(false);
            States.S4.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, button2,inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS4() {
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            eren.getItem(itemDirector.constructBoard());
            States.S4.setVisible(false);
            States.S6.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(290, 335, 125, 30);
        this.buttonBuilder.buildText("No");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S4.setVisible(false);
            States.S6.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), labelBackgroundImage, button1, button2, inventory);
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            if (inputTextField.getText().equalsIgnoreCase("timone")) {
                JOptionPane.showMessageDialog(null,"Delle pietre emergono dal fiume e compongono " +
                        "un passaggio.\nAdesso puoi attraversarlo!");
                States.S5.setVisible(false);
                States.S7.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Hai sbagliato! Riprova.\n\nConsiglio: è il " +
                        "\"volante\" di una nave...");
            }
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),inputTextField,button1,inventory);
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
        this.buttonBuilder.buildText("Avventurati");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
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
        this.buttonBuilder.buildText("Indietro");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S6.setVisible(false);
            States.S4.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, button2,inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS7(){ //Stato in cui Eren si fa seguire da Lythien
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            eren.npcFollow(Lythien.getInstance());
            States.S7.setVisible(false);
            States.S8.setVisible(true);
            //System.out.println(eren.getNpcList().contains(Lythien.getInstance()));
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(260,335,200,30);
        this.buttonBuilder.buildText("Continuo per la mia strada");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S7.setVisible(false);
            States.S9.setVisible(true);
            //System.out.println(eren.getNpcList().contains(Lythien.getInstance()));
        });
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),button1,button2,inventory);
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S8.setVisible(false);
            States.S9.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),labelBackgroundImage,button1,inventory);
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event ->{
            PanelDirector.CRYPT.setMessage(ConcretePalindromic.getInstance().getEnigma());
            PanelDirector.CRYPT.setStrategy(ConcretePalindromic.getInstance());
            States.stateCrypt();
            States.S9.setVisible(false);
            States.stateCrypt.setVisible(true);
        });
        this.buttonBuilder.buildTip("Contare le parole palindrome escluse sotto parole");
        palindromicButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(240,335,125,30);
        this.buttonBuilder.buildText("Storia di Eldoria");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event ->{
            PanelDirector.CRYPT.setMessage(ConcreteHistory.getInstance().getEnigma());
            PanelDirector.CRYPT.setStrategy(ConcreteHistory.getInstance());
            States.stateCrypt();
            States.S9.setVisible(false);
            States.stateCrypt.setVisible(true);
        });
        historyButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(375,335,125,30);
        this.buttonBuilder.buildText("Numeri primi");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event ->{
            PanelDirector.CRYPT.setMessage(ConcretePrimes.getInstance().getEnigma());
            PanelDirector.CRYPT.setStrategy(ConcretePrimes.getInstance());
            States.stateCrypt();
            States.S9.setVisible(false);
            States.stateCrypt.setVisible(true);
        });
        this.buttonBuilder.buildTip("Scrivere i numeri separati da uno spazio bianco");
        primesButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),palindromicButton,historyButton,primesButton,inventory);
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
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            if (PanelDirector.CRYPT.open(textField.getText())) {
                States.stateCrypt.setVisible(false);
                States.S10.setVisible(true);
            } else
                JOptionPane.showMessageDialog(null, "Hai sbagliato la risposta.\nRitenta o cambia" +
                        " enigma\nLa cripta è rimasta chiusa.");
        });
        openButton = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(183, 350, 185, 30);
        this.buttonBuilder.buildText("Indietro");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.stateCrypt.setVisible(false);
            States.S9.setVisible(true);
        });
        backButton = this.buttonBuilder.build();
        textField.setBounds(183, 235, 185, 30);
        textField.setHorizontalAlignment(JTextField.CENTER);
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), textField, openButton, backButton, inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS10() {
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath("src/model/assets/torch state.png")
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 25, 300, 275);
        this.scrollBuilder.buildText("L’interno delle cripte risulta poco luminoso.\nAvventurarti con questa scarsa luminosità risulta impossibile."+
                "\nCaso vuole che attorno a te ci sono delle fiaccole."+
                "\nVedendole, capisci che sarà necessario prenderne una per continuare il viaggio.");
        labelBackgroundImage.setBounds(315, 25, 235, 275);
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Afferra fiaccola");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            eren.getItem(itemDirector.constructTorch());
            States.S10.setVisible(false);
            States.S11.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, inventory,labelBackgroundImage);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS11() {
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath(Malgrim.getInstance().getImagePath())
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0,15,320,280);
        this.scrollBuilder.buildText("Grazie alla fiaccola raccolta, il percorso è abbastanza luminoso e riesci ad avventurarti. " +
                "Da lontano, lungo il tuo cammino, intravedi un cancello con affianco una figura avvolta in un mantello nero come la notte. " +
                "Il suo volto è un mistero, nascosto dietro una maschera di freddo disinteresse e occhi penetranti come pozzi senza fondo. " +
                "I suoi lunghi capelli corvini cadono come strisce di oscurità lungo il suo volto pallido, mentre una risata sinistra risuona nell'aria come un'eco lugubre." +
                "\n\nMalgrim Ombroso:\n" + "\"Salve, giovane avventuriero. Per proseguire il tuo cammino devi superare il cancello che si pone davanti a te.\nDue sono le possibilità:"
                + "\n\n•Inserire la sequenza corretta di numeri per sbloccare la serratura."+
                "\n\n•La inserirò io per te, ma tutto ha un costo: in cambio, dovrai dirmi dove sei diretto.\""
                + "\n\nLa figura misteriosa e cupa ti suscita qualche timore. Cosa scegli di fare?");
        labelBackgroundImage.setBounds(325,25,235,275);
        this.buttonBuilder.buildDimension(80,335,180,30);
        this.buttonBuilder.buildText("Inserisco la sequenza");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S11.setVisible(false);
            States.S12.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(290,335,170,30);
        this.buttonBuilder.buildText("Gli dico dove vado");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            JOptionPane.showMessageDialog(null,"Rivelando a Malgrim la tua destinazione, come " +
                    "promesso da lui, si apre il cancello, permettendoti di proseguire.\nAdesso Malgrim sa dove sei " +
                    "diretto... ");
            eren.npcFollow(Malgrim.getInstance());
            States.S11.setVisible(false);
            States.S13.setVisible(true);
        });
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),button1,button2,inventory,labelBackgroundImage);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS12(){
        Integer[] option = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        JComboBox list1 = new JComboBox(option);
        JComboBox list2 = new JComboBox(option);
        JComboBox list3 = new JComboBox(option);
        list1.setBounds(100,250,50,20);
        list2.setBounds(250,250,50,20);
        list3.setBounds(400,250,50,20);
        this.scrollBuilder.buildDimension(0, 0, 550, 200);
        this.scrollBuilder.buildText("Tre indovinelli, uno per ciascuna chiave. Inserisci le risposte nel pannello " +
                "corrispondente." + "\n\n" +
                "1. Quante 'a' ci sono in questa frase?" + "\n\n" +
                "2. Sono il mese dell'anno piu' corto, ma alle volte mi allungo un po'. Chi sono?" + "\n\n" +
                "3. \"Il TREno dei desideri, nei miei pensieri all'incontrario va!\" Seleziona il numero nascosto " +
                "presente all'interno di questa frase.");
        this.buttonBuilder.buildDimension(203, 335, 150, 30);
        this.buttonBuilder.buildText("Sblocca");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            if (list1.getSelectedIndex() == 4 && list2.getSelectedIndex() == 2 && list3.getSelectedIndex() == 3) {
                States.S12.setVisible(false);
                States.S13.setVisible(true);
                list1.setSelectedIndex(0);
                list2.setSelectedIndex(0);
                list3.setSelectedIndex(0);
            }
            else {
                JOptionPane.showMessageDialog(null,"Sequenza errata, riprova!");
            }
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),button1,inventory,list1,list2,list3);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS13(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 0, 550, 300);
        this.scrollBuilder.buildText("Pensavi che il peggio fosse passato, ma arrivi ad una strada interrotta. " +
                "\nE’ necessario superarla per giungere alla fine ed uscire dalla cripta. Davanti a te, sospese in aria, " +
                "ci sono due placche rocciose su cui poter mettere i piedi.\n\nUn cartello accanto ha scritto:\n\n" +
                "\"Scegli con cura la placca su cui poggiare i piedi.\nLa placca corretta farà sospendere in avanti " +
                "altre due placche fino a quando non raggiungerai l’altro bordo.\nLa placca sbagliata attiverà delle " +
                "trappole che ti faranno ricominciare da capo.\nScegli con cura le placche su cui camminare se " +
                "l’uscita vuoi trovare\".");
        this.buttonBuilder.buildDimension(203, 335, 150, 30);
        this.buttonBuilder.buildText("Vai all'enigma");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S13.setVisible(false);
            States.STATE_TILES.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),button1,inventory);
        return this.panelBuilder.build();
    }
    public JPanel makePanelTiles(){
        this.panelBuilder.reset();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(130,196,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(130,316,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button2 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(270,196,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button3 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(270,316,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button4 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(410,196,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button5 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(410,316,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button6 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(550,196,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button7 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildDimension(550,316,100,100);
        this.buttonBuilder.buildBackgroundColor(Color.DARK_GRAY);
        JButton button8 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildText("Esci dalla cripta");
        this.buttonBuilder.buildDimension(318,483,150,30);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton buttonExit = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildText("Istruzioni");
        this.buttonBuilder.buildDimension(100,483,100,30);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton buttonInfo = this.buttonBuilder.build();

        buttonExit.setEnabled(false);
        button3.setEnabled(false); button4.setEnabled(false); button5.setEnabled(false); button6.setEnabled(false); button7.setEnabled(false); button8.setEnabled(false);
        //Sequenza corretta 1 4 6 7
        //Prima Colonna
        button1.addActionListener(event -> {
            button1.setBackground(Color.GREEN);
            button1.setEnabled(false); button2.setEnabled(false);
            button3.setEnabled(true); button4.setEnabled(true);
        });
        //Seconda Colonna
        button4.addActionListener(event -> {
            button4.setBackground(Color.GREEN);
            button4.setEnabled(false); button3.setEnabled(false);
            button5.setEnabled(true); button6.setEnabled(true);
        });
        button3.addActionListener(event -> {
            button1.setBackground(Color.DARK_GRAY);
            button3.setEnabled(false); button4.setEnabled(false);
            button1.setEnabled(true); button2.setEnabled(true);
        });
        //Terza Colonna
        button6.addActionListener(event -> {
            button6.setBackground(Color.GREEN);
            button6.setEnabled(false); button5.setEnabled(false);
            button7.setEnabled(true); button8.setEnabled(true);
        });
        button5.addActionListener(event -> {
            button1.setBackground(Color.DARK_GRAY); button4.setBackground(Color.DARK_GRAY);
            button5.setEnabled(false); button6.setEnabled(false);
            button1.setEnabled(true); button2.setEnabled(true);
        });
        //Quarta Colonna
        button7.addActionListener(event -> {
            button7.setBackground(Color.GREEN);
            button7.setEnabled(false); button8.setEnabled(false);
            buttonExit.setEnabled(true);
        });
        button8.addActionListener(event -> {
            button1.setBackground(Color.DARK_GRAY); button4.setBackground(Color.DARK_GRAY); button6.setBackground(Color.DARK_GRAY);
            button8.setEnabled(false); button7.setEnabled(false);
            button1.setEnabled(true); button2.setEnabled(true);
        });

        buttonExit.addActionListener(event ->{
            JOptionPane.showMessageDialog(null,"Complimenti, hai superato la prova!" +
                    "\nAdesso puoi uscire dalla cripta!");
            States.STATE_TILES.setVisible(false);
            States.S14.setVisible(true);
        });
        buttonInfo.addActionListener(event -> {
            JOptionPane.showMessageDialog(null,"Per superare la prova devi premere le placche rocciose " +
                    "nell'ordine corretto da sinistra verso destra,\nselezionando una placca per ogni colonna.\nFai attenzione " +
                    "a non sbagliare, altrimenti dovrai ricominciare da capo!");
        });
        this.panelBuilder.buildComponents(button1,button2,button3,button4,button5,button6,button7,button8,buttonExit,buttonInfo);
        return this.panelBuilder.build();
    }
    public JPanel makePanelS14(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 275);
        this.scrollBuilder.buildText("Finalmente, dopo un’avventura insidiosa e piena di pericoli, ti trovi al centro di Eldoria.\n" +
                "Da lontano, vedi l’imponente, maestosa statua di Eldoria. Il tuo obiettivo è quasi compiuto, basta mettere la pietra in cima.\n\n" +
                "Tuttavia, forze nemiche sono schierate intorno alla statua.\n\n" +
                "Devi dirigerti verso la statua velocemente e prestando attenzione a non farti vedere.");
        this.buttonBuilder.buildDimension(200, 335, 140, 30);
        this.buttonBuilder.buildText("Vai verso la statua");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            States.S14.setVisible(false);
            States.S15.setVisible(true);
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS15(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 0, 550, 300);
        this.scrollBuilder.buildText("Sauron si materializza davanti a te impedendoti così di raggiungere la cima della statua. " +
                "\n\nLa sua apparente forza ti suscita talmente tanta paura da avere tremore in tutto il corpo. " +
                "Paura e adrenalina si fondono insieme creando un mix perfetto che ti fa pietrificare davanti al nemico. " +
                "\n\nAd un tratto, come per l’aiuto dell’elfo nel Bosco degli Spiriti Avvolti, senti una voce provenire dalla " +
                "Pietra dell’Aurora.");
        this.buttonBuilder.buildDimension(200, 335, 140, 30);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildText("Afferra la pietra");
        this.buttonBuilder.buildListener(event -> {
           eren.useItem(itemDirector.constructStone());
           List<Npc> list = eren.getNpcList();
           if(list.contains(Lythien.getInstance()) && list.contains(Malgrim.getInstance())) {
               States.S15.setVisible(false);
               States.S19.setVisible(true);
           } else if (list.contains(Lythien.getInstance()) && !(list.contains(Malgrim.getInstance()))) {
               States.S15.setVisible(false);
               States.S17.setVisible(true);
           } else if (list.contains(Malgrim.getInstance()) && !(list.contains(Lythien.getInstance()))) {
               States.S15.setVisible(false);
               States.S18.setVisible(true);
           }
           else{
               States.S15.setVisible(false);
               States.S16.setVisible(true);
           }
        });
        JButton button1 = this.buttonBuilder.build();
        this.buttonBuilder.reset();
        this.buttonBuilder.buildTip("Inventario");
        this.buttonBuilder.buildDimension(0, 365, 34, 36);
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        JButton inventory = this.buttonBuilder.build();
        inventory.setIcon(new ImageIcon("src/model/assets/chest.png"));
        inventory.addMouseListener(new InventoryMouseListener());
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), button1, inventory);
        return this.panelBuilder.build();
    }

    public JPanel makePanelS16(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 250);
        this.scrollBuilder.buildText("Hai afferrato la pietra, ma la magia non scorre dentro di te. Sauron si scaglia" +
                " contro di te e privato di magia, non hai alcuna difesa.\nDi conseguenza, sei morto.");
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Finisci il gioco");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            JOptionPane.showMessageDialog(null,"Tips:  la pietra dell’aurora può essere " +
                    "brandita solo da un animo puro.\n\n" +
                    "Consiglio per il futuro:  prova ad aiutare le persone in difficoltà.\n\n" +
                    "Clicca OK per iniziare una nuova partita!");
            States.S16.setVisible(false);
            States.STATE_MENU.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS17() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 0, 550, 300);
        this.scrollBuilder.buildText("La magia inizia a scorrere dentro di te. Senti la voce di Gideon dentro di te che " +
                "dice:\n\nPer battere Sauron devi incanalare tutta la magia della pietra dell’Aurora. Questo consumerà " +
                "il tuo corpo e la tua anima. Pertanto, richiederà il tuo sacrificio.\n\nAd un tratto, da lontano vedi " +
                "arrivare Lythien, l’elfo che hai salvato nel bosco.\n\nLythien: \"Non potevo perdermi questo storico " +
                "momento. Come ti ho detto: gli elfi sono riconoscenti e ti devo un favore. Distrarrò Sauron, vai a " +
                "posizionare la pietra in cima alla statua cosicché da porre fine a tutto.\nPER ELVERIOOOOOOOON!\"" +
                "\n\n...\n\nGrazie a Lythien, arrivi in cima e posizioni la pietra. La magia viene sprigionata dalla " +
                "statua e sia Eldoria che i regni circoscritti tornano a splendere di luce celeste abbattendo e ponendo " +
                "fine all’Ordine delle Ombre, Sauron scompare insieme ad esso.");
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Finisci il gioco");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            JOptionPane.showMessageDialog(null,"Complimenti hai finito il gioco salvando Eldoria e " +
                    "sconfiggendo Sauron!\n\nConsiglio: rigioca l'avventura prendendo scelte diverse per scoprire gli altri finali!");
            States.S17.setVisible(false);
            States.STATE_MENU.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS18(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87, 25, 375, 275);
        this.scrollBuilder.buildText("La magia inizia a scorrere dentro di te. Senti la voce di Gideon dentro di te che dice\n\n" +
                "“Per battere Sauron devi incanalare tutta la magia della pietra dell’Aurora. Questo consumerà il tuo corpo e la tua anima. Pertanto, richiederà il tuo sacrificio.”\n\n" +
                "Il coraggio non ti manca e sei disposto a sacrificarti pur di riportare la luce ad Eldoria e farla tornare al suo vecchio splendore, sconfiggendo Sauron.\n\n" +
                "Tuttavia mentre ti stai concentrando e stai sacrificando la tua anima per controllare la PIETRA DELL'AURORA spunta Malgrim Ombroso alle tue spalle e ti sottrae la pietra, interrompendo l’incanalamento della magia sul tuo corpo e consegna la pietra a Sauron, distruggendo ogni tua speranza.\n\n" +
                "Malgrim infatti era proprio un aiutante segreto di Sauron che sorvegliava le cripte della città e quando gli hai confidato le tue intezioni ti ha seguito di nascosto per evitare che il tuo piano di salvare Eldoria andasse a buon fine.\n\n" +
                "Sauron a questo punto vedendoti indifeso e privato della pietra decide di renderti suo schiavo per farti soffrire fino alla fine dei tuoi giorni…");
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Finisci il gioco");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            JOptionPane.showMessageDialog(null,"Tips:  Non dovresti fidarti di certi individui.\n\n" +
                    "Consiglio per il futuro:  Cerca di risolvere gli enigmi con le tue conoscenze senza farti aiutare " +
                    "da individui loschi... \nla via più semplice non sempre è quella giusta.\n\n" +
                    "Clicca OK per iniziare una nuova partita!");
            States.S18.setVisible(false);
            States.STATE_MENU.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), this.buttonBuilder.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS19() {
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(0, 0, 550, 300);
        this.scrollBuilder.buildText("La magia inizia a scorrere dentro di te. Senti la voce di Gideon dentro di te che dice\n" +
                "\n" +
                "\"Per battere Sauron devi incanalare tutta la magia della pietra dell’Aurora. Questo consumerà il tuo corpo e la tua anima. Pertanto, richiederà il tuo sacrificio.\"\n" +
                "\n" +
                "Il coraggio non ti manca e sei disposto a sacrificarti pur di riportare la luce ad Eldoria e farla tornare al suo vecchio splendore, sconfiggendo Sauron.\n" +
                "\n" +
                "Tuttavia mentre ti stai concentrando e stai sacrificando la tua anima per controllare la Pietra dell’Aurora spunta Malgrim Ombroso alle tue spalle intento a sottrarti la pietra per interrompere l’incanalamento della magia e distruggere ogni tua speranza.\n" +
                "\n" +
                "Tuttavia ad un tratto si sente un sibilo nell’aria, è la freccia di Lythien che ricordandosi del tuo aiuto contro l’orco che la stava aggredendo è giunta ad aiutarti coprendoti le spalle e colpendo Malgrim facendolo accasciare a terra. \n" +
                "\n" +
                "Lythien:”non potevo perdermi questo storico momento. Come ti ho detto: gli elfi sono riconoscenti e ti devo un favore. Adesso continua ad incanalare la magia necessaria per sconfiggere Sauron, io continuerò a coprirti le sp…”\n" +
                "\n" +
                "*Lythien cade a terra*\n" +
                "\n" +
                "Malgrim pur essendo stato colpito da una freccia di Lythien era ancora in fin di vita e con un ultimo sforzo scaglia un dardo magico che la colpisce dritta al cuore, uccidendola sul colpo e dopodicchè esalò l’ultimo respiro anche lui.\n" +
                "\n" +
                "Vedendo la tua amica sacrificarsi per te vieni pervaso da una forza d’animo innata che ti permette di controllare a pieno la potenza magica della pietra senza necessità di sacrificare il tuo corpo ed il tuo spirito.\n" +
                "\n" +
                "Sei diventato un tutt’uno con la magia della luce e sblocchi una nuova forma corporea, \"il Sommo Astrale\", un’entità al di sopra di tutto anche dei Sacerdoti della Luce Astrale.\n" +
                "\n" +
                "Adesso grazie alla tua nuova potenza magica innata scagli un raggio di luce contro Sauron riuscendo a ferirlo e a darti il tempo necessario per raggiungere la statua senza opposizione, e collegarti fisicamente ad essa.\n" +
                "\n" +
                "La magia viene sprigionata dalla statua e sia Eldoria che i regni circoscritti tornano a splendere di luce celeste abbattendo e ponendo fine all’Ordine delle Ombre e a Sauron che scompare insieme ad esso.");
        this.buttonBuilder.buildDimension(215, 335, 125, 30);
        this.buttonBuilder.buildText("Finisci il gioco");
        this.buttonBuilder.buildBackgroundColor(Color.WHITE);
        this.buttonBuilder.buildForegroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildListener(event -> {
            JOptionPane.showMessageDialog(null,"Complimenti hai finito il gioco salvando Eldoria e " +
                    "sconfiggendo Sauron!\n\nPurtroppo però Lythien è stata uccisa a causa di una tua scelta sbagliata." +
                    "\n\nConsiglio: rigioca l'avventura prendendo scelte diverse per scoprire gli altri finali!");
            States.S19.setVisible(false);
            States.STATE_MENU.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(), this.buttonBuilder.build());
        return this.panelBuilder.build();
    }
}
