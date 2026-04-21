import java.util.Scanner;
class InsufficientBalanceException extends Exception
 {
    public InsufficientBalanceException(String message)
	{
        super(message);
    }
}
class ATMSystem
 {
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        double balance = 10000; 

        while(true) 
		{
            System.out.println("--- ATM MENU ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice)
			{
                case 1:
                    try 
					{
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        if (amount > balance)
							{
                            throw new InsufficientBalanceException("Insufficient balance!");
                        }

                        balance -= amount;
                        System.out.println("Withdrawal successful!");
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 3:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}