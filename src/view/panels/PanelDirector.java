package view.panels;

import model.npc.Cedric;
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

    public PanelDirector(PanelBuilder panelBuilder){
        this.panelBuilder = panelBuilder;
    }

    public void changeBuilder(PanelBuilder panelBuilder){
        this.panelBuilder = panelBuilder;
    }

    public JPanel makePanelS1(){
        this.panelBuilder.reset();
        this.scrollBuilder.reset();
        this.buttonBuilder.reset();
        this.scrollBuilder.buildDimension(87,25,375,275);
        this.scrollBuilder.buildText("Afferrando la pietra hai avuto una visione su ciò che era Eldoria prima che " +
                "l’Ordine delle Ombre ne prendesse il controllo. Tu sei il prescelto. Il tuo compito è di portare la " +
                "Pietra dell’Aurora al centro di Eldoria e di posizionarla in cima alla statua per riportare la luce " +
                "e ristabilire la pace sull’intero regno. Il tuo cammino è appena iniziato giovane contadino. Come ti " +
                "ha detto Gideon, l’anziano sacerdote, nella visione, recati da Cedric, il druido del Bosco degli " +
                "Spiriti Avvolti.");
        this.buttonBuilder.buildDimension(215,335,125,30);
        this.buttonBuilder.buildText("Vai da Cedric");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.buttonBuilder.buildListener(event -> {
            States.S1.setVisible(false);
            States.S2.setVisible(true);
        });
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),this.buttonBuilder.build());
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
        this.buttonBuilder.reset();
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
        this.buttonBuilder.buildDimension(215,335,125,30);
        this.buttonBuilder.buildText("Avventurati");
        this.buttonBuilder.buildBackgroundColor(new Color(0.58f,0.29f,0f));
        this.buttonBuilder.buildForegroundColor(Color.WHITE);
        this.panelBuilder.buildComponents(this.scrollBuilder.build(),labelBackgroundImage,this.buttonBuilder.build());
        return this.panelBuilder.build();
    }
}
