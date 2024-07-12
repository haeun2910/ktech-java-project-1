package another;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static List<Todo> todos;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TodoReadAndWrite readAndWrite = new TodoReadAndWrite();
        todos = readAndWrite.getTodos();
        TodoAdd add = new TodoAdd(bufferedReader, readAndWrite.getTodos());
        while (true){
            printFirstScreen();
            System.out.println("Input: ");
            int choice;
            try{
                choice = Integer.parseInt(bufferedReader.readLine());
            }catch (NumberFormatException e){
                System.out.println("Please enter a valid number.");
                continue;
            }
            if(choice == 5){
                break;
            }
            switch (choice) {
                case 1:
                    add.createTodo();
                case 2:
                    add.editTodo();
                case 3:
                    add.finishTodo();
                case 4:
                    add.deleteTodo();
                default:
                    System.out.println("Please enter 1-5");
            }
        }
        try{
            readAndWrite.writeToFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        }
        private static void printFirstScreen(){
            System.out.println("Welcome!!!\n");
            int todosLeft = todos.stream()
                    .filter(todo -> !todo.isDone())
                    .mapToInt(todo -> 1)
                    .sum();

        }
    }

