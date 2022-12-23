import java.util.Scanner;
import java.time.LocalDate;


public class Test {

    public static void main(String[] args) {

        Task task3 = new Task("уборка", "уборка", TypeTask.WORKING, Repeatability.WEEKLY,LocalDate.of(2000,12,12));
        Task task2 = new Task("стирка", "стирка", TypeTask.WORKING, Repeatability.WEEKLY,LocalDate.of(2000,1,12));
        Task task1 = new Task("готовка", "готовка", TypeTask.WORKING, Repeatability.WEEKLY,LocalDate.of(2000,1,12));
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
                            TaskService.inputTask(scanner);
                            break;
                        case 2:
                            TaskService.removeTask(scanner);
                            break;
                        case 3:
                            TaskService.getTasksForDay(scanner);
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




