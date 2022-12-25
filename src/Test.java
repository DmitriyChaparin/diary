import java.util.Scanner;
import java.time.LocalDate;


public class Test {

    public static void main(String[] args) {

        Task task3 = new Task("уборка", "уборка", TypeTask.WORKING,LocalDate.of(2000,12,12));
        Task task2 = new Task("стирка", "стирка", TypeTask.WORKING,LocalDate.of(2000,1,12));
        WeeklyTask task1 = new WeeklyTask("готовка", "готовка", TypeTask.WORKING, LocalDate.of(2022,12,4));
        TaskService.allTask.put(task1.getId(),task1);
        TaskService.allTask.put(task2.getId(),task2);
        TaskService.allTask.put(task3.getId(),task3);

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




