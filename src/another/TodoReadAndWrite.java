package another;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoReadAndWrite {
    private final List<Todo> todos;
    private final String filename;

    public TodoReadAndWrite(){
        this("todo.csv");
    }
    public TodoReadAndWrite(String filename){
        this.filename = filename;
        this.todos = new ArrayList<>();
        try {
            this.readFromFile();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            throw new RuntimeException(e);
        }

    }

    private void readFromFile() throws IOException {
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                todos.add(new Todo(
                        values[0],
                        LocalDate.parse(values[1]),
                        Boolean.parseBoolean(values[2])
                ));
            }
        }
    }
    public void writeToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Todo todo : todos) {
                bufferedWriter.write(todo.toCSV());
                bufferedWriter.newLine();
            }
        }
    }
    public List<Todo> getTodos() {
        return todos;
    }
    }
