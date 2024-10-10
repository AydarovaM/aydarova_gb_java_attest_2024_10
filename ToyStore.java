import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;

public class ToyStore {

        //region attributes
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    //endregion

    private static PriorityQueue<Toy> priorityQueue;

    //region main
    public static void main(String[] args) 
    {
        System.out.println("Welcome to our phonebook");

        // priorityQueue = new PriorityQueue<Toy>();

        // List<Toy> toys = new ArrayList<Toy>();
        // boolean exit = false;
        // while(!exit)
        // {
        //     System.out.println("Start");
        //     System.out.println("Input 0 to break, 1 to add toy:");
        //     int option = scanner.nextInt();
        //     scanner.nextLine();
        //     exit = option == 0;
        //     if(option == 1)
        //     {
        //         System.out.println("Input toy id:");
        //         String id = scanner.nextLine();
        //         System.out.println("Input toy name:");
        //         String name = scanner.nextLine();
        //         System.out.println("Input toy quantity:");
        //         String quantity = scanner.nextLine();
        //         toys.add(new Toy(id, name, quantity));
        //         System.out.println("Toy added:" + toys.getLast().ToString());
        //     }   
        //     scanner.close();
        // }

        // // Toy[] toys = new Toy[]
        // // {
        // //     new Toy("1", "Constructor", "3"),
        // //     new Toy("2", "Robot", "4"),
        // //     new Toy("3", "Boll", "6"),

        // // };
        // QueueItem[] items = GetQueueItems(toys);

        // for (QueueItem queueItem : items) 
        // {
        //     System.out.println("Item: " + queueItem.Id);    
        // }

        // PriorityQueue<QueueItem> pq = new PriorityQueue<QueueItem>();
        // for (QueueItem queueItem : items) 
        // {
        //     pq.add(queueItem);    
        // }
        
        // while(!pq.isEmpty())
        // {
        //     System.out.println("ItemPQ:" + pq.poll().Id);
        // }


        try
        {      
            File myObj = new File("result.txt");
            if (myObj.createNewFile())
            {
                FileWriter myWriter = new FileWriter("result.txt");
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static QueueItem[] GetQueueItems(List<Toy> toys)
    {
        int toysCount = 0;
        List<Toy> quantities = new ArrayList<Toy>();
        for (Toy toy : toys) 
        {
            toysCount += toy.Quantity;
            quantities.add(new Toy(toy.Id, "", toy.Quantity));
        }

        QueueItem[] items = new QueueItem[toysCount];
        Random rand = new Random();

        for(int i = 0; i < items.length; i++)
        {
            int toyIndex = rand.nextInt(quantities.size());
            Toy selectedToy = quantities.get(toyIndex);
            selectedToy.Quantity--;
            if(selectedToy.Quantity == 0)
            {
                quantities.remove(selectedToy);
            }
            items[i] = new QueueItem(selectedToy.Id, i);
        }

        return items;
    }
}
