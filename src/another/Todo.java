package another;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Todo {
    String title;
    LocalDate until;
    boolean done;
    static Scanner scanner = new Scanner(System.in);
    static List<Todo> todos = new ArrayList<>();

    public Todo(String title, LocalDate until) {
        this.title = title;
        this.until = until;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", until=" + until +
                ", done=" + done +
                '}';
    }
    public static void createTodo() {
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Until: ");
        String until = scanner.nextLine();
        LocalDate untilDate = LocalDate.parse(until);
        Todo todo = new Todo(title, untilDate);
        todos.add(todo);
        System.out.println("Saved!!!");
    }

    public static void editTodo() {
        System.out.println("Edit TODO number: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > todos.size()) {
            System.out.println("Invalid TODO number!");
            return;
        }
        Todo todo = todos.get(num - 1);
        System.out.println("Title: ");
        String title = scanner.nextLine();
        if(!title.isEmpty()){
            todo.title = title;
        }
        System.out.println("Until: ");
        String until = scanner.nextLine();
        if(!until.isEmpty()){
            todo.until = LocalDate.parse(until);
        }
        System.out.println("Saved!!!");

    }

    public static void finishTodo() {
        System.out.println("Finish TODO number: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > todos.size()) {
            System.out.println("Invalid TODO number!");
            return;
        }
        Todo todo = todos.get(num - 1);
        todo.done = true;
        System.out.println("Done!!!");
    }

    public static void deleteTodo() {
        System.out.println("Delete TODO number: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > todos.size()) {
            System.out.println("Invalid TODO number!");
            return;
        }
        todos.remove(num - 1);
        System.out.println("Deleted!!!");
    }
}
