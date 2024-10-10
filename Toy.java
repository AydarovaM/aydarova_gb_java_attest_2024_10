public class Toy 
{
    public String Id;
    public String Name;
    public int Quantity; 

    public Toy(String id, String name, String quantity)
    {
        Id = id;
        Name = name;
        Quantity = Integer.parseInt(quantity);
    }

    public Toy(String id, String name, int quantity)
    {
        Id = id;
        Name = name;
        Quantity = quantity;
    }

    public String ToString()
    {
        return Id + " " + Quantity + " " + Name;
    }
}
