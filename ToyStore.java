import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;

public class ToyStore 
{
    PriorityQueue<QueueItem> pq;

    public ToyStore(List<String> unparsedToys)
    {
        List<Toy> toys = new ArrayList<Toy>();

        for (String toyStr : unparsedToys) 
        {
            String[] idNameQuantitySep = toyStr.split(" ");
            if(idNameQuantitySep.length == 3)
            {
                toys.add(new Toy(idNameQuantitySep[0], idNameQuantitySep[1], idNameQuantitySep[2]));
            }
            else
                System.out.println("Wrong format!");
        }

        pq = GenerateQueue(toys);
    }

    public String Get()
    {
        if(pq == null || pq.isEmpty())
            return "queue is empty";

        return pq.poll().Id;
    }

    public int Size()
    {
        if(pq == null || pq.isEmpty())
            return 0;
        return pq.size();
    }

    PriorityQueue<QueueItem> GenerateQueue(List<Toy> toys)
    {
        //Added because of literal requirement in task.
        QueueItem[] items = GetQueueItems(toys);
        PriorityQueue<QueueItem> pq = new PriorityQueue<QueueItem>();
        for (QueueItem queueItem : items) 
        {
            pq.add(queueItem);    
        }

        return pq;
    }

    public void WriteRandomToySequenceToFile()
    {
        if(pq == null)
            return;
            
        String resultText = "";

        while(!pq.isEmpty())
        {
            resultText += Get() + "\n";
        }

        try
        {      
            File myObj = new File("result.txt");
            if (myObj.createNewFile())
            {
                FileWriter myWriter = new FileWriter("result.txt");
                myWriter.write(resultText);
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
