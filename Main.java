import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main 
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        System.out.println("Welcome to our toy store");

        List<String> toysStr = new ArrayList<String>();
        boolean exit = false;
        while(!exit)
        {
            System.out.println("Input 0 to break, 1 to add toy:");
            int option = scanner.nextInt();
            scanner.nextLine();
            exit = option == 0;
            if(option == 1)
            {
                System.out.println("Input toy in format: id name quantity");
                String idNameQuantity = scanner.nextLine();
                String[] idNameQuantitySep = idNameQuantity.split(" ");
                if(idNameQuantitySep.length == 3)
                {
                    toysStr.add(idNameQuantity);
                    System.out.println("Toy to add:" + idNameQuantity);
                }
                else
                    System.out.println("Wrong format!");
            }   
        }
        scanner.close();

        ToyStore store = new ToyStore(toysStr);
        store.WriteRandomToySequenceToFile();
    }
}
