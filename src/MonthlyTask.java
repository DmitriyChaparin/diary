import java.time.LocalDate;

public class MonthlyTask extends Task implements Repeatable{
    public MonthlyTask(String headline, String description, TypeTask typeTask, LocalDate taskCreationData) {
        super(headline, description, typeTask, taskCreationData);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return  date.getDayOfMonth()==taskCreationData.getDayOfMonth();
    }
}
