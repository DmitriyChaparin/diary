import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
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
    private static Map<Integer,Task> allTask = new LinkedHashMap<>();

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        System.out.print("1. Рабочая" + '\n' +
                "2. Личная"+'\n'+ "Выберите тип задачи: ");
        String type = "";
        if (scanner.hasNextInt()) {
            int menu = scanner.nextInt();
            if (menu == 1) {
                type ="WORKING";
            } else if (menu == 2) {
                 type = "PERSONAL";
            }

        } else {
            scanner.next();
            System.out.println("Выберите пункт  1 или 2!");
        }
        Task task = new Task(taskName,description,TypeTask.valueOf(type),Repeatability.WEEKLY);
        System.out.println(task);
        allTask.put(task.getId(),task);
        System.out.println(allTask);
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу" + '\n' +
                        "2. Удалить задачу" + '\n' +
                        "3. Получить задачу на указанный день" + '\n' +
                        "0. Выход");

    }
}

