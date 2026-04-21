import java.util.Scanner;
public class StudentMarksSystem 
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int marks = -1;
        while(true) 
		{
            System.out.println("--- STUDENT MARKS MENU ---");
            System.out.println("1. Enter Marks");
            System.out.println("2. Display Marks");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) 
			{
                case 1:
                    try
					{
                        System.out.print("Enter marks (0-100): ");
                        int input = sc.nextInt();

                        if (input < 0 || input > 100) 
						{
                            throw new IllegalArgumentException("Marks must be between 0 and 100!");
                        }

                        marks = input;
                        System.out.println("Marks saved successfully!");
                    } catch (IllegalArgumentException e)
					{
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (marks == -1)
						{
                        System.out.println("No marks entered yet.");
                    }
					else
						{
                        System.out.println("Student Marks: " + marks);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}