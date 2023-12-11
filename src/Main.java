import model.inventory.Inventory;
import model.items.*;
import view.FrameDiProva;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //creating the inventory with singleton pattern
        Inventory i =  Inventory.getInventory();

        //creating items with builder design pattern
        ItemDirector director = new ItemDirector();
        ItemBuilder builder = new ItemBuilder();
        director.constructBoard(builder);
        Item board = builder.getResults();
        director.constructStone(builder);
        Item stone = builder.getResults();
        director.constructLight(builder);
        Item light = builder.getResults();

        //putting items
        i.putItem(stone);
        i.putItem(board);
        i.putItem(light);

        List<Item> items = i.getItems();
        System.out.println(items);
        //System.out.println(i.useItem(stone));
        System.out.println(items);
        //InventoryFrame.getInventoryFrame();

        Thread operationsThread2 = new Thread(() -> {
            // Operazioni che vuoi eseguire durante il sonno
            System.out.println("Operations during sleep");
            try {
                // Metti in pausa questo thread per 5 secondi (5000 millisecondi)
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // Gestisci l'eccezione, se necessario
                e.printStackTrace();
            }

            // Altre operazioni dopo il risveglio
            System.out.println("Operations after sleep");
            i.useItem(stone);
        });

        Thread operationsThread1 = new Thread(() -> {
            // Operazioni che vuoi eseguire durante il sonno
            System.out.println("Operations during sleep");
            FrameDiProva.initGUI();
            try {
                // Metti in pausa questo thread per 5 secondi (5000 millisecondi)
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // Gestisci l'eccezione, se necessario
                e.printStackTrace();
            }

            // Altre operazioni dopo il risveglio
            System.out.println("Operations after sleep");
            i.useItem(light);
            operationsThread2.start();
        });

        // Avvia il thread delle operazioni
        operationsThread1.start();

    }
}