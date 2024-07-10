package another;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static another.Todo.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Todo> todos = readData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Welcome!!!");
            int remaining = 0;
            for (Todo todo : todos) {
                if (!todo.isDone()){
                    remaining++;
                }

            }
            if (remaining == 0) {
                System.out.println("You have no more TODOs lefr!!!");
            } else if (remaining == 1) {
                System.out.println("You have 1 TODO lefr!!!");

            }else {
                System.out.println("You have " + remaining + " TODOs lefr!!!");
            }
            for (int i = 0; i < todos.size(); i++) {
                Todo todo = todos.get(i);
                System.out.println((i+1) + ". " + todo.title + (todo.done? "(Done)": ""));

            }
            System.out.println("1. Create TODO");
            System.out.println("2. Edit TODO");
            System.out.println("3. Finish TODO");
            System.out.println("4. Delete TODO");
            System.out.println("5. Exit");
            System.out.print("Input: ");
            int choice = Integer.parseInt(reader.readLine());
            switch(choice) {
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
                    System.out.println("Invalid choice!. Try again!");

            }

        }

    }




    public static List<Todo> readData() {
        List<Todo> todos = new ArrayList<>();
        try (FileReader fileReader = new FileReader("todo.csv");
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                LocalDate until = LocalDate.parse(values[1]);
                todos.add(new Todo(
                        values[0],
                        until


                ));
            }
        } catch (IOException e) {
            System.out.println("Read data error: " + e.getMessage());

        }
        return todos;
    }

    private static void writeData(List<Todo> todos) {
        try (FileWriter fileWriter = new FileWriter("todo.csv");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            StringBuilder lineBuilder = new StringBuilder();
            for (Todo todo : todos) {
                lineBuilder.append(todo.getTitle()).append(",");
                lineBuilder.append(todo.getUntil().toString()).append(",");
                writer.write(lineBuilder.toString());
                writer.newLine();

            }
        } catch (IOException e) {
            System.out.println("Write data error: " + e.getMessage());
        }
    }
}
