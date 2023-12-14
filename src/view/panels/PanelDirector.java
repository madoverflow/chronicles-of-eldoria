package view.panels;

import model.npc.*;
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
    private final ButtonBuilder buttonBuilder1 = new ConcreteButtonBuilder();
    private final ButtonBuilder buttonBuilder2 = new ConcreteButtonBuilder();
    private final ButtonBuilder buttonBuilder3 = new ConcreteButtonBuilder();

    public PanelDirector(PanelBuilder panelBuilder){
        this.panelBuilder = panelBuilder;
    }

    public void changeBuilder(PanelBuilder panelBuilder){
        this.panelBuilder = panelBuilder;
    }

    public JPanel makePanelS1(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder1.reset();
        this.scrollBuilder.buildDimension(87,25,375,275);
        this.scrollBuilder.buildText("Afferrando la pietra hai avuto una visione su ciò che era Eldoria prima che " +
                "l’Ordine delle Ombre ne prendesse il controllo. Tu sei il prescelto. Il tuo compito è di portare la " +
                "Pietra dell’Aurora al centro di Eldoria e di posizionarla in cima alla statua per riportare la luce " +
                "e ristabilire la pace sull’intero regno. Il tuo cammino è appena iniziato giovane contadino. Come ti " +
                "ha detto Gideon, l’anziano sacerdote, nella visione, recati da Cedric, il druido del Bosco degli " +
                "Spiriti Avvolti.");
        this.buttonBuilder1.buildDimension(215,335,125,30);
        this.buttonBuilder1.buildText("Vai da Cedric");
        this.buttonBuilder1.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder1.buildForegroundColor(Color.WHITE);
        this.buttonBuilder1.buildListener(event -> {
            States.S1.setVisible(false);
            States.S2.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),this.buttonBuilder1.build());
        return this.panelBuilder.build();
    }
    public JPanel makePanelS2(){
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath(Cedric.getInstance().getImagePath())
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder1.reset();
        this.scrollBuilder.buildDimension(0,25,305,275);
        this.scrollBuilder.buildText("Cedric: salve giovane avventuriero…non riesco a credere ai miei occhi, stai " +
                "brandendo la Pietra dell’Aurora quindi sei tu il prescelto della profezia, colui che riporterà la " +
                "luce ad Eldoria e restaurerà la pace. Eldoria sta vivendo dei tempi bui e la città pullula di soldati " +
                "dell’Ordine delle Ombre. Ci sarebbe una strada alternativa che porta direttamente alle cripte della " +
                "città, situate al centro di Eldoria, sotto la statua. Tuttavia, questo cammino può essere percorso " +
                "solo addentrandoti dentro il Bosco degli Spiriti Avvolti. La strada è tortuosa e piena di insidie. " +
                "Gideon, fu l’unico essere ad averlo percorso e ad essere sopravvissuto. Sbrigati, giovane avventuriero" +
                ", Sauron può avvertire l’essenza della Pietra dell’Aurora e non tarderà a cercarla. Il destino di " +
                "Eldoria è nelle tue mani. ");
        labelBackgroundImage.setBounds(320,25,235,275);
        this.buttonBuilder1.buildDimension(215,335,125,30);
        this.buttonBuilder1.buildText("Avventurati");
        this.buttonBuilder1.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder1.buildForegroundColor(Color.WHITE);
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),labelBackgroundImage,this.buttonBuilder1.build());
        return this.panelBuilder.build();
    }

    public JPanel makePanelS7(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder1.reset();
        this.buttonBuilder2.reset();
        this.scrollBuilder.buildDimension(87,25,375,275);
        this.scrollBuilder.buildText("Durante il tuo cammino, senti degli strani versi e delle urla provenire da un " +
                "sentiero non molto lontano da te. Il coraggio scorre nelle tue vene e decidi di prendere una piccola " +
                "deviazione per scoprire cosa stia succedendo. Giunto a destinazione, osservi che un terribile Orco sta " +
                "attaccando un essere femminile dalle sembianze elfiche. Cosa decidi di fare?");
        this.buttonBuilder1.buildDimension(90,335,125,30);
        this.buttonBuilder1.buildText("Aiuto l'elfo");
        this.buttonBuilder1.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder1.buildForegroundColor(Color.WHITE);
        this.buttonBuilder2.buildDimension(260,335,200,30);
        this.buttonBuilder2.buildText("Continuo per la mia strada");
        this.buttonBuilder2.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder2.buildForegroundColor(Color.WHITE);
        this.buttonBuilder1.buildListener(event -> {
            States.S7.setVisible(false);
            States.S8.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),this.buttonBuilder1.build(),this.buttonBuilder2.build());
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
        this.buttonBuilder1.reset();
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
        this.buttonBuilder1.buildDimension(215,335,125,30);
        this.buttonBuilder1.buildText("Prosegui");
        this.buttonBuilder1.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder1.buildForegroundColor(Color.WHITE);
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),labelBackgroundImage,this.buttonBuilder1.build());
        return this.panelBuilder.build();
    }
}
