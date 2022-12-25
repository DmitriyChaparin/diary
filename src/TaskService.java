import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static Map<Integer, Task> allTask = new HashMap<>();


    public static void inputTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.print("Тип задачи" + '\n' + "1. Рабочая \n" +
                "2. Личная" + '\n' + "Выберите тип задачи: ");
        String type = scanner.nextLine();
        if (type.equals("1")) {
            type = "WORKING";
        } else if (type.equals("2")) {
            type = "PERSONAL";
        }
        // доработать

        LocalDate date = null;

        System.out.println("Введите дату задачи в фомате (01.01.2022): ");
        boolean again = true;
        while (again) {
            try {
                date = LocalDate.parse(scanner.nextLine(), DATE_TIME_FORMATTER);
                again = false;
            } catch (DateTimeParseException e) {
                System.out.println("Не верный формат ввода, введите еще раз:");
            }
        }

        Task task;
        System.out.println(
                "Выберите повторяемость задания: \n" +
                        "1. ежедневно" + '\n' +
                        "2. еженедельно" + '\n' +
                        "3. ежемесячно" + '\n' +
                        "4. ежегодно" + '\n' +
                        "0. не повторяется");
        switch (scanner.next()) {
            case "1":
                task = new DailyTask(taskName, description, TypeTask.valueOf(type), date);
                break;
            case "2":
                task = new WeeklyTask(taskName, description, TypeTask.valueOf(type), date);
                break;
            case "3":
                task = new MonthlyTask(taskName, description, TypeTask.valueOf(type), date);
                break;
            case "4":
                task = new YearlyTask(taskName, description, TypeTask.valueOf(type), date);
                break;
            default:
                task = new Task(taskName, description, TypeTask.valueOf(type), date);
        }
        allTask.put(task.getId(), task);
        System.out.println("Задача добавлена");
        System.out.println(allTask);

    }


    public static void getTasksForDay() {
        Scanner scanner = new Scanner(System.in);
        try {

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
                if (equal) {
                    System.out.println(task.getValue().getHeadline());
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Вы ввели не корректые данные\n");
            getTasksForDay();
        }


    }


    public static void removeTask() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите номер задачи которую нужно удалить: ");
            int removeId = scanner.nextInt();
            if (allTask.containsKey(removeId)) {
                for (Map.Entry<Integer, Task> task : allTask.entrySet()) {
                    boolean equal = task.getKey().equals(removeId);
                    if (equal) {
                        allTask.remove(task.getKey());
                        System.out.println("Задача " + task.getValue().getHeadline() + " удалена.");
                    }
                }

            } else {
                System.out.println("Такой задачи нет в списке!");
            }
        } catch (InputMismatchException e) {
            System.out.print("Вы ввели не корректые данные\n");
            removeTask();
        }
    }

    public static void printMenu() {
        System.out.println(
                "1. Добавить задачу" + '\n' +
                        "2. Удалить задачу" + '\n' +
                        "3. Получить задачу на указанный день" + '\n' +
                        "0. Выход");

    }
}



