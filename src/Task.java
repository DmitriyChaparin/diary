import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {

    private String headline;

    private String description;

    private Repeatability repeatability;

    private TypeTask typeTask;

    private LocalDateTime taskCreationTime;

    private int id;

    private static int counter = 0;

    public Task(String headline, String description,TypeTask typeTask ,Repeatability repeatability) {
        counter++;
        this.headline = headline;
        this.description = description;
        this.typeTask=typeTask;
        this.repeatability = repeatability;
        this.taskCreationTime=LocalDateTime.now();
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

    @Override
    public String toString() {
        return "Task{" +
                "headline='" + headline + '\'' +
                ", description='" + description + '\'' +
                ", repeatability=" + repeatability +
                ", typeTask=" + typeTask +
                ", id=" + id +
                '}';
    }
}
