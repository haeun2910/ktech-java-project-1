package another;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    private String title;
    private LocalDate dueDate;
    private boolean done;

    public Todo(String title, LocalDate dueDate) {
        this(title,dueDate,false);
    }
    public Todo(String title, LocalDate dueDate, boolean done) {
        this.title = title;
        this.dueDate = dueDate;
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public void done() {
        this.done = true;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", until=" + done +
                '}';
    }
    public String toCSV(){
        return String.format("%s, %s, %s, %s", title, dueDate, done);
    }
}
