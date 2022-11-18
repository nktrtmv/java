import java.util.*;

public class Main {

    public static final String[] names = {"Никита", "Никита", "Борис", "Алексей", "Александра", "Иван", "Андрей", "Егор", "Дмитрий", "Михаил", "Анастасия", "Владимир",
    "Семен", "Максим", "Дарья", "Екатерина", "Александр", "Всеволод", "Юлия", "Елизавета", "Илья", "Антон", "Андрей", "Евгений", "Геннадий", "Владислав", "Федор",
    "Виталий", "Егор", "Данил", "Илья"};
    public static final String[] surnames = {"Амирханов", "Артемов", "Барков", "Бесшапов", "Босерт", "Гладких", "Гусев", "Елушов", "Жуковский", "Калабай", "Клычкова",
    "Корякин", "Котовский", "Кузнецов", "Лунькова", "Назарова", "Нигай", "Овчинников", "Олейник", "Осипова", "Порошин", "Порфирьев", "Русанов", "Старцев", "Талалаев",
    "Федотов", "Фирсов", "Черкасский", "Шарапов", "Швецов", "Шиндяпкин"};

    private static void Help() {
        System.out.println("""
                Для использования программы необходимо вводить один символ:
                e - для выхода
                h - для вывода этой подсказки
                s - начать новый урок
                a - спросить ученика, который еще не был опрошен за урок
                l - вывести список группы
                """);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Help();
        Group group = new Group(31);
        int currentSeminar = 1;
        HashSet<Integer> set = new HashSet<>();
        int temp, mark;
        boolean isOnLesson;
        Random random = new Random();

        System.out.println("Новый урок начался.");
        char command = '0';
        do {
            try {
                command = scan.next().charAt(0);
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Некорректный ввод, попробуйте снова.");
                continue;
            }
            switch (command) {
                case 's':
                    System.out.println("Новый урок начался.");
                    currentSeminar++;
                    set = new HashSet<>();
                    break;
                case 'a':
                    do {
                        temp = random.nextInt(0, group.getSize());
                    } while (set.contains(temp));
                    set.add(temp);
                    System.out.println(names[temp] + " " + surnames[temp] + " присутсвует на паре?");
                    isOnLesson = random.nextBoolean();
                    System.out.println(isOnLesson ? "Да, присутсвует!" : "Нет, отсутсвует.");
                    if (isOnLesson){
                        System.out.println("** Задается вопрос и вы получаете ответ **");
                        System.out.print("Введите оценку: ");
                        mark = scan.nextInt() % 11;
                        group.rateStudent(group.getStudent(names[temp], surnames[temp]), currentSeminar, mark);
                    } else {
                        mark = 0;
                        group.rateStudent(group.getStudent(names[temp], surnames[temp]), currentSeminar, mark);
                    }
                    System.out.println(names[temp] + " " + surnames[temp] + " получает оценку " + mark);
                    break;
                case 'l':
                    group.printSheet();
                    break;
                case 'h':
                    Help();
                    break;
                case 'e':
                    continue;
                default:
                    System.out.println("Неизвестная команда, для вызова подсказки напишите h");
            }
        } while (command != 'e');
    }
}