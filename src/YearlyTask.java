import java.time.LocalDate;

public class YearlyTask extends Task implements Repeatable{
    public YearlyTask(String headline, String description, TypeTask typeTask, LocalDate taskCreationData) {
        super(headline, description, typeTask, taskCreationData);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        if (taskCreationData.isAfter(date)) {
            return false;
        }
        return date.getDayOfWeek()==taskCreationData.getDayOfWeek()
                && date.getDayOfMonth()==taskCreationData.getDayOfMonth();
    }
}
