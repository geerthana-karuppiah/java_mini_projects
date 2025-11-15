import java.util.Scanner;

// Parent class
class Item 
{
    String name;
    int price;
    int stock;

    Item(String name, int price, int stock) 
    {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Method to buy item ( polymorphism)
    public int buy(int qty) 
    {
        if (qty <= stock) 
        {
            stock -= qty;
            return qty * price;
        }
        else 
        {
            System.out.println(name + " is OUT OF STOCK!");
            return 0;
        }
    }
}

// Child classes (Inheritance)
class Pen extends Item 
{
    Pen(int stock)
    {
        super("Pen", 10, stock);
    }
}

class Notebook extends Item 
{
    Notebook(int stock) 
    {
        super("Notebook", 40, stock);
    }

    // Polymorphism: Notebook gives a discount if qty >= 2
    @Override
    public int buy(int qty) 
    {
        int cost = super.buy(qty); // call parent buy
        if (qty >= 2 && cost > 0) 
        {
            System.out.println("Notebook Offer: Rs.5 off!");
            cost -= 5;
        }
        return cost;
    }
}

public class oops 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Create items
        Item pen = new Pen(5);
        Item notebook = new Notebook(3);

        int totalBill = 0;
        String bill = "";

        System.out.println("***** WELCOME TO KEERTHI'S WORLD *****");

        System.out.print("\nHow many different items do you want to buy? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) 
        {
            System.out.println("\nAvailable Items:");
            System.out.println("1. Pen - Rs.10 (Stock: " + pen.stock + ")");
            System.out.println("2. Notebook - Rs.40 (Stock: " + notebook.stock + ")");

            System.out.print("Enter item number (1-2): ");
            int choice = sc.nextInt();

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            int cost = 0;
            if (choice == 1) 
            {
                cost = pen.buy(qty); // Pen's buy
                if (cost > 0) bill += "Pen x " + qty + " = Rs." + cost + "\n";
            }
             else if (choice == 2) 
            {
                cost = notebook.buy(qty); // Notebook's buy (polymorphism)
                if (cost > 0) bill += "Notebook x " + qty + " = Rs." + cost + "\n";
            }
             else 
            {
                System.out.println("Invalid Choice!");
            }

            totalBill += cost;
        }

        // Final Bill
        System.out.println("\n***** FINAL BILL *****");
        System.out.print(bill);
        System.out.println("Total Amount : Rs." + totalBill);
        System.out.println("Thank you for shopping at KEERTHI'S WORLD!");
    }
}

