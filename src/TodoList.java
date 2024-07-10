import java.util.ArrayList;
import java.util.List;

public class TodoList {
    List<Todo> todos;

    public TodoList() {
        this.todos = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public Todo getTodo(int index) {
        return todos.get(index);
    }

    public void removeTodo(int index) {
        todos.remove(index);
    }

    public int size() {
        return todos.size();
    }

    public void printList() {
        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            System.out.println((i + 1) + ". " + todo.title + (todo.done ? " (Done)" : ""));
        }
    }
}
