import java.time.LocalDate;

public class WeeklyTask extends Task implements Repeatable{
    public WeeklyTask(String headline, String description, TypeTask typeTask, LocalDate taskCreationData) {
        super(headline, description, typeTask, taskCreationData);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfWeek()==taskCreationData.getDayOfWeek();
    }
}
