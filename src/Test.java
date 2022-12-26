import java.util.Scanner;
import java.time.LocalDate;


public class Test {

    public static void main(String[] args) {

        DailyTask task5 = new DailyTask("уборка", "уборка", TypeTask.WORKING, LocalDate.of(2000, 12, 12));
        WeeklyTask task2 = new WeeklyTask("стирка", "стирка", TypeTask.WORKING, LocalDate.of(2022, 12, 12));
        MonthlyTask task1 = new MonthlyTask("готовка", "готовка", TypeTask.WORKING, LocalDate.of(2022, 12, 12));
        YearlyTask task3 = new YearlyTask("готовка", "готовка", TypeTask.WORKING, LocalDate.of(2022, 1, 4));
        TaskService.allTask.put(task1.getId(), task1);
        TaskService.allTask.put(task5.getId(), task5);
        TaskService.allTask.put(task2.getId(), task2);
        TaskService.allTask.put(task3.getId(), task3);
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                TaskService.printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            TaskService.inputTask();
                            break;
                        case 2:
                            TaskService.removeTask();
                            break;
                        case 3:
                            TaskService.getTasksForDay();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }

            }
        }

    }
}




