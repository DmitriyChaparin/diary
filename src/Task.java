import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Task {

    private String headline;

    private String description;


    private TypeTask typeTask;


    public LocalDate taskCreationData;

    private int id;

    private static int counter = 0;

    public Task(String headline, String description,TypeTask typeTask , LocalDate taskCreationData) {
        counter++;
        this.headline = headline;
        this.description = description;
        this.typeTask=typeTask;
        this.taskCreationData=taskCreationData;
        id = counter;
    }



    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTaskCreationData() {
        return taskCreationData;
    }

    public void setTaskCreationData(LocalDate taskCreationData) {
        this.taskCreationData = taskCreationData;
    }

    @Override
    public String toString() {
        return "Task{" +
                "headline='" + headline + '\'' +
                ", description='" + description + '\'' +
                ", typeTask=" + typeTask +
                ", taskCreationData=" + taskCreationData +
                ", id=" + id +"\n";
    }
}

