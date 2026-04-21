import java.util.Scanner;
class AccountLockedException extends Exception
 {
    public AccountLockedException(String message) 
	{
        super(message);
    }
}

class LoginSystem 
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "1234";
        int attempts = 3;
        while(true)
		{
            System.out.println("--- LOGIN MENU ---");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
			{
                case 1:
                    while (attempts > 0)
						{
                        try
						{
                            System.out.print("Username: ");
                            String username = sc.nextLine();

                            System.out.print("Password: ");
                            String password = sc.nextLine();

                            if (username.equals(correctUsername) && password.equals(correctPassword))
								{
                                System.out.println("Login successful!");
                                break;
                            } 
							else 
							{
                                attempts--;
                                if (attempts == 0)
									{
                                    throw new AccountLockedException("Account locked due to too many failed attempts!");
                                }
                                System.out.println("Invalid credentials! Attempts left: " + attempts);
                            }
                        } catch (AccountLockedException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}