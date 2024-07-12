package another;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class TodoAdd {
    private final BufferedReader bufferedReader;
    private final List<Todo> todos;

    public TodoAdd(BufferedReader bufferedReader, List<Todo> todos) {
        this.bufferedReader = bufferedReader;
        this.todos = todos;
        this.sortTodos();

    }


    private void sortTodos() {
        this.todos.sort(Comparator.comparing(Todo::getDueDate));
    }

    public void createTodo() throws IOException {
        System.out.println("Title: ");
        String title = bufferedReader.readLine();
    }

    public void editTodo() {
    }

    public void finishTodo() {
    }

    public void deleteTodo() {
    }
}
