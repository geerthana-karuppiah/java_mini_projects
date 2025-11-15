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

	// buy() method with  exceptions
	public int buy(int qty) throws Exception 
	{
		if (qty <= 0) 
		{
			throw new Exception("Quantity must be greater than 0.");
		}
		if (qty > stock) 
		{
			throw new Exception(name + " stock is only " + stock + " items left.");
		}

		stock -= qty;
		return qty * price;
	}
}

// Child classes
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

	@Override
	public int buy(int qty) throws Exception 
	{
		int cost = super.buy(qty);
		if (qty >= 2) 
		{
			System.out.println("Notebook Offer: Rs.5 off!");
			cost -= 5;
		}
		return cost;
	}
}

public class exception
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

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

			try 
			{
				if (choice != 1 && choice != 2) 
				{
					throw new Exception("Invalid item number! Choose 1 or 2.");
				}

				System.out.print("Enter quantity: ");
				int qty = sc.nextInt();

				int cost = 0;

				if (choice == 1) 
				{
					cost = pen.buy(qty);
					bill += "Pen x " + qty + " = Rs." + cost + "\n";
				} 
				else 
				{
					cost = notebook.buy(qty);
					bill += "Notebook x " + qty + " = Rs." + cost + "\n";
				}

				totalBill += cost;

			} 
			catch (Exception e) 
			{
				System.out.println("Error: " + e.getMessage());
			}
		}

		System.out.println("\n***** FINAL BILL *****");
		System.out.print(bill);
		System.out.println("Total Amount : Rs." + totalBill);
		System.out.println("Thank you for shopping at KEERTHI'S WORLD!");
	}
}
