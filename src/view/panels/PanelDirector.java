package view.panels;

import javax.swing.*;

public class PanelDirector {
    private PanelBuilder panelBuilder;

    public PanelDirector(PanelBuilder panelBuilder){
        this.panelBuilder = panelBuilder;
    }

    public void changeBuilder(PanelBuilder panelBuilder){
        this.panelBuilder = panelBuilder;
    }

    /*make di ciascun pannello per ogni stato. Dentro, l a creazione di tutti i componenti del pannello.
    Utilizzare il concrete builder giusto.
    * */
    public JPanel makeInventoryPanel(){
        System.out.println("Implementate i pannelli con il director. Idea: passate il path dell'immagine e il nome " +
                "dell'oggetto a parametro nel metodo così ve " +
                "lo create in modo automatizzato ed eliminate " +
                "le stesse righe di codice delle label per ciascun pannello. " +
                "Aumentiamo la leggibilità del codice. Utilizzate il concrete builder");
        return null;
    }
}
