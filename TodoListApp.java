/*This code is for a To DO List and with this the userrs can store their works and can even mark them done.*/
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}

class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask.getDescription());
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("Task marked as done: " + tasks.get(index).getDescription());
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

public class TodoListApp {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("\n==== Todo List Menu ====");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = ob.nextInt();
            ob.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = ob.nextLine();
                    todoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task index to mark as done: ");
                    int index = ob.nextInt();
                    todoList.markTaskAsDone(index - 1);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting Todo List. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
