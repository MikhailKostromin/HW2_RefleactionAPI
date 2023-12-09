import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /*
    Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat")
с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API
выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
     */
    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Мурка", 1),
                new Cat("Барс", 4),
                new Cat("Фил", 2),
                new Cat("Фиса", 16),
                new Dog("Шарик", 16),
                new Dog("Чарли", 16)
        };

        Set<Class<?>> classSet = new HashSet<>();
        for (Animal a : animals) {
            classSet.add(a.getClass());
        }
        for (Class<?> clazz : classSet) {
            System.out.println("Класс " + clazz.getName());
            System.out.println("Поля класса");
            Arrays.stream(clazz.getDeclaredFields())
                    .forEach(field -> System.out.println("\t" + field.getName() + " в классе"));
            Arrays.stream(clazz.getSuperclass().getDeclaredFields())
                    .forEach(field -> System.out.println("\t" + field.getName() + " в Cуперклассе"));
            System.out.println("Методы класса");
            Arrays.stream(clazz.getDeclaredMethods())
                    .forEach(field -> System.out.println("\t" + field.getName() + " в классе"));
            Arrays.stream(clazz.getSuperclass().getDeclaredMethods())
                    .forEach(field -> System.out.println("\t" + field.getName() + " в Cуперклассе"));
            System.out.println("---------------------------------------------------------");

        }
        for (Animal a : animals) {
            System.out.println(a);
            try {
                Method makeSoundMethod = a.getClass().getMethod("makeSound");
                makeSoundMethod.invoke(a);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException ignored) {}

        }
    }
}