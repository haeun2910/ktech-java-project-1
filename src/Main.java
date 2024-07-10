import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        app.run();
    }

    static class Todo {
        String title;
        String until;
        boolean done;

        Todo(String title, String until) {
            this.title = title;
            this.until = until;
            this.done = false;
        }
    }

    public static class TodoApp {
        List<Todo> todos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        public void run() {
            while (true) {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline left-over

                switch (choice) {
                    case 1:
                        createTodo();
                        break;
                    case 2:
                        editTodo();
                        break;
                    case 3:
                        finishTodo();
                        break;
                    case 4:
                        deleteTodo();
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again!");
                }
            }
        }

        private void printMenu() {
            System.out.println("Welcome!");
            int remaining = 0;
            for (Todo todo : todos) {
                if (!todo.done) {
                    remaining++;
                }
            }
            if (remaining == 0) {
                System.out.println("You have no more TODOs left!!!");
            } else if (remaining == 1) {
                System.out.println("You have 1 TODO left.");
            } else {
                System.out.println("You have " + remaining + " TODOs left.");
            }

            for (int i = 0; i < todos.size(); i++) {
                Todo todo = todos.get(i);
                System.out.println((i + 1) + ". " + todo.title + (todo.done ? " (Done)" : ""));
            }

            System.out.println("1. Create TODO");
            System.out.println("2. Edit TODO");
            System.out.println("3. Finish TODO");
            System.out.println("4. Delete TODO");
            System.out.println("5. Exit");
            System.out.print("Input: ");
        }

        private void createTodo() {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Until: ");
            String until = scanner.nextLine();
            Todo todo = new Todo(title, until);
            todos.add(todo);
            System.out.println("Saved!!!");
        }

        private void editTodo() {
            System.out.print("Edit TODO number: ");
            int num = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            if (num < 1 || num > todos.size()) {
                System.out.println("Invalid TODO number. Try again!");
                return;
            }
            Todo todo = todos.get(num - 1);
            System.out.print("Title: ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) {
                todo.title = title;
            }
            System.out.print("Until: ");
            String until = scanner.nextLine();
            if (!until.isEmpty()) {
                todo.until = until;
            }
            System.out.println("Saved!!!");
        }

        private void finishTodo() {
            System.out.print("Finish TODO number: ");
            int num = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            if (num < 1 || num > todos.size()) {
                System.out.println("Invalid TODO number. Try again!");
                return;
            }
            Todo todo = todos.get(num - 1);
            todo.done = true;
            System.out.println("Done!!!");
        }

        private void deleteTodo() {
            System.out.print("Delete TODO number: ");
            int num = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            if (num < 1 || num > todos.size()) {
                System.out.println("Invalid TODO number. Try again!");
                return;
            }
            todos.remove(num - 1);
            System.out.println("Deleted!!!");
        }


    }
}

