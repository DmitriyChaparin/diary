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
        } else {
            type = "WORKING";
        }

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
        System.out.println("Задача '" + task.getHeadline() + "' добавлена");


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

            List<Task> result = new ArrayList<>();
            for (Map.Entry<Integer, Task> entry : allTask.entrySet()) {
                Task task = entry.getValue();
                if (task instanceof Repeatable
                        && ((Repeatable) task).checkIfSuitable(date)
                        || !(task instanceof Repeatable)
                        && task.getTaskCreationData().equals(date)) {
                    result.add(task);
                }
            }
            System.out.println("Задачи на " + date + ": \n" + result);
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
            allTask.remove(removeId);
            System.out.println("Задача  удалена.");
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



