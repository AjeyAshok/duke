public class Task {
    private String A;
    private boolean isDone;

    public Task(String A){
        this.A = A;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public void MarkAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return this.A;
    }
}
