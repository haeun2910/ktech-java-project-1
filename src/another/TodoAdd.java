package another;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoAdd {
    public static List<Todo> readData() {
        List<Todo> todos = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/another/todo.csv");
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

    static void writeData(List<Todo> todos) {
        try (FileWriter fileWriter = new FileWriter("src/another/todo.csv");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            StringBuilder lineBuilder = new StringBuilder();
            for (Todo todo : todos) {
                lineBuilder.append(todo.getTitle()).append(",");
                lineBuilder.append(todo.getUntil().toString());
                writer.write(lineBuilder.toString());
                writer.newLine();
                lineBuilder.setLength(0);

            }
        } catch (IOException e) {
            System.out.println("Write data error: " + e.getMessage());
        }
    }
}
