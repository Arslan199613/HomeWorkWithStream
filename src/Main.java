import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Иван", 18, 1);
        Student student2 = new Student("Сергей", 19, 2);
        Student student3 = new Student("Федор", 18, 1);
        Student student4 = new Student("Мирон", 20, 3);
        Student student5 = new Student("Петр1", 22, 4);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        // Задача 1. Найти минимальное и максимальное значение.
        // Создал список студентов,вывел самого молодого и самого взрослого.
        // Положил в BiConsumer.

        Optional<String> min = students.stream()
                .min(Comparator.comparing(Student::getAge))
                .map(e -> e.getName());
        min.ifPresent(System.out::println);//самый молодой студент

        Optional<String> max = students.stream()
                .max(Comparator.comparing(Student::getAge))
                .map(e -> e.getName());
        max.ifPresent(System.out::println);//самый взрослый студент

        BiConsumer<Optional<String>, Optional<String>> minMaxConsumer = (a, b) -> System.out.println("Самый молодой студент- " + a + ", самый взрослый студент- " + b);

        if (minMaxConsumer == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(min, max);
        }

        //Задача 2. Вывел четные числа исвользуя стримы

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integerList.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

    }
}
