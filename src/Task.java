import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {

    private String headline;

    private String description;

    private Repeatability repeatability;

    private TypeTask typeTask;


    private LocalDate taskCreationData;

    private int id;

    private static int counter = 0;

    public Task(String headline, String description,TypeTask typeTask ,Repeatability repeatability, LocalDate taskCreationData) {
        counter++;
        this.headline = headline;
        this.description = description;
        this.typeTask=typeTask;
        this.repeatability = repeatability;
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
                ", repeatability=" + repeatability +
                ", typeTask=" + typeTask +
                ", taskCreationData=" + taskCreationData +
                ", id=" + id +"\n";
    }
}
