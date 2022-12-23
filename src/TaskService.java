import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {
    public static Map<Integer, Task> allTask = new LinkedHashMap<>();


    public static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        System.out.print("1. Рабочая" + '\n' +
                "2. Личная" + '\n' + "Выберите тип задачи: ");
        String type = "";
        if (scanner.hasNextInt()) {
            int menu = scanner.nextInt();
            if (menu == 1) {
                type = "WORKING";
            } else if (menu == 2) {
                type = "PERSONAL";
            }

        } else {
            scanner.next();
            System.out.println("Выберите пункт  1 или 2!");
        }
        System.out.print("Введите год: ");
        int years = scanner.nextInt();
        System.out.print("Введите месяц: ");
        int month = scanner.nextInt();
        System.out.print("Введите день: ");
        int day = scanner.nextInt();

        Task task = new Task(taskName, description, TypeTask.valueOf(type), Repeatability.WEEKLY, LocalDate.of(years, month, day));
        allTask.put(task.getId(), task);
        System.out.println(allTask);
    }

    public static void getTasksForDay(Scanner scanner) {

        System.out.print("Введите год: ");
        int years = scanner.nextInt();
        System.out.print("Введите месяц: ");
        int month = scanner.nextInt();
        System.out.print("Введите день: ");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(years, month, day);
        System.out.println("Задачи на " + date + ": ");

        for (Map.Entry<Integer, Task> task : allTask.entrySet()) {
            boolean equal = task.getValue().getTaskCreationData().isEqual(date);
            if (equal == true) {
                System.out.println(task.getValue().getHeadline());
            }
        }
    }


    public static void removeTask(Scanner scanner) {
        System.out.print("Введите номер задачи которую нужно удалить: ");
        int removeId = scanner.nextInt();
        if (allTask.containsKey(removeId)) {
            for (Map.Entry<Integer, Task> task : allTask.entrySet()) {
                boolean equal = task.getKey().equals(removeId);
                if (equal == true) {
                    allTask.remove(task.getKey());
                    System.out.println("Задача " + task.getValue().getHeadline() + " удалена.");
                }
            }

        } else {
            System.out.println("Такой задачи нет в списке!");
        }System.out.println(allTask);
    }


    public static void printMenu() {
        System.out.println(
                "1. Добавить задачу" + '\n' +
                        "2. Удалить задачу" + '\n' +
                        "3. Получить задачу на указанный день" + '\n' +
                        "0. Выход");

    }
}



