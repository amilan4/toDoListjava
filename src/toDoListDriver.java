import java.util.Scanner;

/**
 * toDoListDriver
 * --------------
 * Description:
 * This class is the main drive for to-do list. It interacts with the
 * user through the console, allowing them to add, remove, mark as
 * complete, edit, view tasks, and exit the application.
 *
 * PRE: None.
 * POST: Provides a way for users to use a to-do lists.
 *
 * @version July 2024
 */
public class toDoListDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        System.out.println("Welcome to your to-do list! What's your name?: ");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you " + name + ", what would you like to do today?");
        actions toDoList = new actions();

        while (keepGoing) {
            System.out.print("(Type the corresponding letter to what you'd "
                    + "like to do!) \n\tA - Add a new item.\n\tB - Remove an item.\n\tC - Mark an item as complete."
                    + "\n\tD - Edit a task \n\tE - View your current tasks.\n\tF - Exit.\n");

            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("A")) {
                System.out.println("Enter the item to add: ");
                String item = scanner.nextLine();
                toDoList.addItem(item);
            } else if (userInput.equalsIgnoreCase("B")) {
                System.out.println("Enter the number of the item to remove: ");
                toDoList.displayItems();
                int removeIndex = getValidIntInput(scanner);
                toDoList.removeItem(removeIndex);
            } else if (userInput.equalsIgnoreCase("C")) {
                System.out.println("Enter the number of the item to mark as complete: ");
                toDoList.displayItems();
                int completeIndex = getValidIntInput(scanner);
                toDoList.markAsComplete(completeIndex);
            } else if (userInput.equalsIgnoreCase("D")) {
                System.out.println("Enter the number of the task to edit: ");
                toDoList.displayItems();
                int editIndex = getValidIntInput(scanner);
                scanner.nextLine(); // consume the newline
                System.out.println("Enter the new item: ");
                String newItem = scanner.nextLine();
                toDoList.editTask(editIndex, newItem);
            } else if (userInput.equalsIgnoreCase("E")) {
                toDoList.displayItems();
            } else if (userInput.equalsIgnoreCase("F")) {
                System.out.println("Exiting...");
                keepGoing = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * getValidIntInput
     * ----------------
     * This method makes sure that the user inputs a valid integer.
     * If the input is not an integer, it will prompt the user to enter
     * another number.
     *
     * PRE: None.
     * POST: Returns a valid integer input from the user.
     */
    public static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                int userInput = Integer.parseInt(scanner.nextLine());
                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number: ");
            }
        }
    }
}