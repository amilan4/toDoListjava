import java.util.ArrayList;
import java.util.Objects;

/**
 * actions
 * -------
 * Description:
 * This class manages a list of tasks. It creates methods to add, remove,
 * mark as complete, edit, view tasks, and display tasks. Each task can
 * be marked as complete or incomplete.
 *
 * PRE: None.
 * POST: Manages a to-do list with functionality for various task operations.
 *
 * @version July 2024
 */
public class actions {
    private ArrayList<String> list;
    private ArrayList<Boolean> completionStatus;

    /**
     * actions
     * -------
     * Makes an empty actions object with lists for tasks and
     * their completion statuses.
     */
    public actions() {
        list = new ArrayList<>();
        completionStatus = new ArrayList<>();
    }

    /**
     * addItem
     * -------
     * Adds a new task to the to-do list and marks it as incomplete.
     *
     * PRE: item is a non-null String.
     * POST: Adds the item to the list and marks it as incomplete.
     */
    public void addItem(String item) {
        list.add(item);
        completionStatus.add(false); // The item isn't marked as complete at first
    }

    /**
     * removeItem
     * ----------
     * Removes a task from the to-do list based on the action number
     * they want to remove.
     *
     * PRE: number is a valid number of item.
     * POST: Removes the task at the specified number.
     */
    public void removeItem(int index) {
        if (index >= 1 && index < list.size() + 1) {
            list.remove(index - 1);
            completionStatus.remove(index - 1);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    /**
     * markAsComplete
     * --------------
     * Marks a task as complete based on the wanted number.
     *
     * PRE: number is a valid number of item bounds.
     * POST: Marks the task at the specified number as complete.
     */
    public void markAsComplete(int index) {
        if (index >= 1 && index < list.size() + 1) {
            completionStatus.set(index - 1, true);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    /**
     * editTask
     * --------
     * Edits the task at the wanted number with a new task.
     *
     * PRE: number is a valid number of item bounds,
     * newItem is a non-null String.
     * POST: Replaces the task at the specified index with the
     * new task description.
     */
    public void editTask(int index, String newItem) {
        if (index >= 1 && index < list.size() + 1) {
            list.set(index - 1, newItem);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    /**
     * toString
     * --------
     * Returns a string representation of the tasks and
     * their completion statuses.
     *
     * PRE: None.
     * POST: Returns a string listing all tasks with their indices
     * and completion status.
     *
     * @return A string representation of the to-do list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1).append(": ").append(list.get(i));
            if (completionStatus.get(i)) {
                sb.append(" (Completed)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * getItems
     * --------
     * Returns the list of tasks.
     *
     * PRE: None.
     * POST: Returns the list of tasks.
     */
    public ArrayList<String> getItems() {
        return list;
    }

    /**
     * displayItems
     * ------------
     * Displays the current tasks and their completion statuses to the console.
     *
     * PRE: None.
     * POST: Prints the tasks and their completion statuses to the console.
     */
    public void displayItems() {
        System.out.println(this.toString());
    }

    /**
     * equals
     * ------
     * Compares this actions object with another object for equality.
     *
     * PRE: None.
     * POST: Returns true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        actions actions = (actions) o;
        return Objects.equals(list, actions.list) && Objects.equals(completionStatus, actions.completionStatus);
    }

    /**
     * hashCode
     * --------
     * Returns a hash code value for this actions object.
     *
     * PRE: None.
     * POST: Returns a hash code value for this actions object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(list, completionStatus);
    }
}