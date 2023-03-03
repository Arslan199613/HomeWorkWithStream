import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        findMinMax(students);

    }
        // Задача 1. Найти минимальное и максимальное значение.
        // Создал список студентов,вывел самого молодого и самого взрослого.
        // Положил в BiConsumer.
    public static void findMinMax(List<Student>students) {
        String min = students.stream()
                .min(Comparator.comparing(Student::getAge))
                .map(e -> e.getName()).get();
        System.out.println(min);//самый молодой студент

        String max = students.stream()
                .max(Comparator.comparing(Student::getAge))
                .map(e -> e.getName()).get();
        System.out.println(max);

        BiConsumer<String,String> minMaxConsumer = (a, b) -> System.out.println("Самый молодой студент- " + a + ", самый взрослый студент- " + b);

        if (minMaxConsumer == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(min, max);
        }

        //Задача 2. Вывел четные числа исвользуя стримы

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long count = integerList.stream()
                .filter(e -> e % 2 == 0)
                .count();
        System.out.println(count);


    }
}
