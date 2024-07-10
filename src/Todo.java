public class Todo {
    String title;
    String until;
    boolean done;

    public Todo(String title, String until) {
        this.title = title;
        this.until = until;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = false;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", until=" + until +
                ", done=" + done +
                '}';
    }


}
