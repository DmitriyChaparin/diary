import java.time.LocalDate;

public class DailyTask extends Task implements Repeatable{

    public DailyTask(String headline, String description, TypeTask typeTask, LocalDate taskCreationData) {
        super(headline, description, typeTask, taskCreationData);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        if (taskCreationData.isAfter(date)) {
            return false;
        }
        return true;
    }
}
