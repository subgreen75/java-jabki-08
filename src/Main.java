import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /**
         * 1) Вывести список
         * Создайте список из 5 целых чисел. Выведите его элементы через пробел
         */
        System.out.println("Задание 1");
        List<Integer> listOfInteger = new ArrayList<Integer>();
        // заполнение списка
        for (int i = 0; i < 5; i++) {
            listOfInteger.add((int) (Math.random() * 100) + 1);
        }
        System.out.printf("Список: %s\n", listOfInteger);
        System.out.println("Выведем через пробел");
        for (int number : listOfInteger) {
            System.out.printf("%s ", number);
        }
        System.out.println("");

        /**
         * 2) Доступ по индексу
         * Выведите третий элемент списка
         */
        System.out.println("Задание 2");
        System.out.printf("Исходный список %s\n", listOfInteger);
        // будем считать что нумерация элементов списка начинается с 0-го
        System.out.printf("Третий элемент списка: %s\n", listOfInteger.get(3));

        /**
         * 3) Удаление элемента
         * Удалите второй элемент списка и выведите оставшиеся
         */
        System.out.println("Задание 3");
        System.out.printf("Исходный список %s\n", listOfInteger);
        listOfInteger.remove(2);
        System.out.printf("Список после удаления второго эелемента: %s\n", listOfInteger);

        /**
         * 4) Сумма элементов
         * Найдите сумму всех чисел в списке
         */
        System.out.println("Задание 4");
        int sum = 0;
        for (int number : listOfInteger) {
            sum += number;
        }
        System.out.printf("Сумма всех чисел в списке: %s\n", sum);
        // или так
        sum = listOfInteger.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.printf("Сумма всех чисел в списке: %s\n", sum);


        /**
         * 5) Подсчёт количества
         * Подсчитайте, сколько раз в списке встречается число 7
         */
        System.out.println("Задание 5");
        calculateCountOfNumber(listOfInteger, 7);
        //добавим для проверки число 7
        listOfInteger.add(7);
        calculateCountOfNumber(listOfInteger, 7);

        /**
         * 6) Поиск элемента
         * Проверьте, содержится ли число 42 в списке
         */
        System.out.println("Задание 6");
        checkNumInList(listOfInteger, 42);
        //добавим для проверки число 42
        listOfInteger.add(42);
        checkNumInList(listOfInteger, 42);

        /**
         * 7) Минимум и максимум
         * Найдите и выведите минимальное и максимальное число в списке
         */
        System.out.println("Задание 7");
        System.out.printf("В списке %s минимальное число %s\n", listOfInteger, getMinOfList(listOfInteger));
        System.out.printf("В списке %s максимальное число %s\n", listOfInteger, getMaxOfList(listOfInteger));

        /**
         * 8) Удалить все чётные числа
         * Удалите из списка все числа, делящиеся на 2.
         */
        System.out.println("Задание 8");
        System.out.printf("Исходный список %s\n", listOfInteger);
        listOfInteger.removeIf(number -> number % 2 == 0);
        System.out.printf("Результат после удаления четных чисел: %s\n", listOfInteger);

        /**
         * 9) Создание списка из массива
         * Создайте список из массива int[] arr = {1, 2, 3, 4}.
         */
        System.out.println("Задание 9");
        int[] arr = {1, 2, 3, 4};
        List<Integer> listFromArr = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            listFromArr.add(arr[i]);
        }
        System.out.printf("Список из массива: %s\n", listFromArr);
        // ну или одной строкой (подсмотрено в гугл)
        List<Integer> listFromArrExt = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
        System.out.printf("Список из массива: %s\n", listFromArrExt);

        /**
         * 10) Количество элементов > N
         * Найдите количество элементов, больше чем число N
         */
        System.out.println("Задание 10");
        System.out.printf("Исходный список %s\n", listOfInteger);
        System.out.printf("Количество элементов больше %s = %s\n", 1, getCountOfListGreateN(listOfInteger, 1));
        System.out.printf("Количество элементов больше %s = %s\n", 50, getCountOfListGreateN(listOfInteger, 50));

        /**
         * 11) Создание списка строк и фильтрация
         * Создайте список строк. Выведите строки, длина которых больше 5
         */
        System.out.println("Задание 11");
        // Создание списка строк
        List<String> listOfString = new ArrayList<>();
        listOfString.add("январь");
        listOfString.add("февраль");
        listOfString.add("март");
        listOfString.add("апрель");
        listOfString.add("май");
        listOfString.add("июнь");
        System.out.printf("Исходный список %s\n", listOfString);

        // Фильтрация списка, оставляя только строки, длина которых больше 5
        List<String> filteredListOfString = listOfString.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        System.out.printf("Отфильтрованный список (длина строки больше 5) %s\n", filteredListOfString);

        /**
         * 12) Инвертировать список
         * Напишите метод, который возвращает список в обратном порядке
         */
        System.out.println("Задание 12");
        System.out.printf("Исходный список строк %s\n", listOfString);
        System.out.printf("Инвертированный список строк %s\n", getInvertListOfString(listOfString));
        System.out.printf("Исходный список чисел %s\n", listOfInteger);
        System.out.printf("Инвертированный список чисел %s\n", getInvertListOfNum(listOfInteger));

        /**
         * 13) Объединение двух списков без дубликатов
         * Даны два списка. Объедините их в один, не добавляя повторы
         */
        System.out.println("Задание 13");
        //первый список. создание и заполнение
        List<Integer> listOfIntFirst = new ArrayList<Integer>();
        listOfIntFirst.add(1);
        listOfIntFirst.add(2);
        listOfIntFirst.add(3);
        //второй список. создание и заполнение
        List<Integer> listOfIntSecond = new ArrayList<Integer>();
        listOfIntSecond.add(1);
        listOfIntSecond.add(2);
        listOfIntSecond.add(5);
        listOfIntSecond.add(6);
        //итоговый
        Set<Integer> listOfIntSummary = new HashSet<>();
        listOfIntSummary.addAll(listOfIntFirst);
        listOfIntSummary.addAll(listOfIntSecond);
        System.out.printf("Первый список %s\n", listOfIntFirst);
        System.out.printf("Второй список %s\n", listOfIntSecond);
        System.out.printf("Итоговый список %s\n", listOfIntSummary);

        /**
         * 14) Сумма только нечётных чисел
         * Считайте List<Integer> и посчитайте сумму только нечётных чисел
         */
        System.out.println("Задание 14");
        List<Integer> listNumbers = new ArrayList<Integer>();
        // заполнение списка
        for (int i = 0; i < 10; i++) {
            listNumbers.add((int) (Math.random() * 100) + 1);
        }
        System.out.printf("Исходный список %s\n", listNumbers);
        System.out.printf("Сумма нечетных чисел %s\n", getSumOddNumbers(listNumbers));

        /**
         * 15) Фильтр по первой букве
         * Дан список строк. Верните новый список, содержащий только строки, начинающиеся с буквы "А
         */
        System.out.println("Задание 15");
        // Создание списка строк
        List<String> listOfMonth = new ArrayList<>();
        listOfMonth.add("Январь");
        listOfMonth.add("Февраль");
        listOfMonth.add("Март");
        listOfMonth.add("Апрель");
        listOfMonth.add("Май");
        listOfMonth.add("Июнь");
        listOfMonth.add("Июль");
        listOfMonth.add("Август");
        listOfMonth.add("Сентябрь");
        listOfMonth.add("Октябрь");
        listOfMonth.add("Ноябрь");
        listOfMonth.add("Декабрь");
        System.out.printf("Исходный список %s\n", listOfMonth);
        System.out.printf("Список строк, начинающийся на А %s\n", getListByAlpha(listOfMonth, "А"));
    }

    //проверяет и выводит на экран - сколько раз число findNumber присутствует в списке numbers
    private static void calculateCountOfNumber(List<Integer> numbers, int findNumber) {
        int countOfNumber = 0;
        for (int number : numbers) {
            if (number == findNumber) {
                countOfNumber++;
            }
        }
        System.out.printf("Число %s в списке %s встречается %s раз\n", findNumber, numbers, countOfNumber);
    }

    // выводит на экран, содержится ли число number в списке numbers
    private static void checkNumInList(List<Integer> numbers, int number) {
        System.out.printf("Число %s в списке %s %s\n", number, numbers, numbers.contains(number) ? "содержится" : "не содержится");
    }

    //ищем минимальное значение в списке
    public static int getMinOfList(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    //ищем максимальное значение в списке
    public static int getMaxOfList(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    //ищем количество эелементов в списке numbers, значения которых больше findNumber
    public static long getCountOfListGreateN(List<Integer> numbers, int findNumber) {
        long count = numbers.stream()
                .filter(n -> n > findNumber)
                .count();
        return count;
    }

    //возвращает список чисел в обратном порядке
    public static List<Integer> getInvertListOfNum(List<Integer> list) {
        Collections.reverse(list);
        return list;
    }

    //возвращает список строк в обратном порядке
    public static List<String> getInvertListOfString(List<String> list) {
        Collections.reverse(list);
        return list;
    }

    //ищем сумму нечетных чисел в списке numbers
    public static long getSumOddNumbers(List<Integer> numbers) {
        long sumOdd = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sumOdd;
    }

    //возвращает список из listString , начинающийся на alpha
    public static List<String> getListByAlpha(List<String> list, String alpha) {
        List<String> listByAlpha = list.stream()
                .filter(s -> s.startsWith(alpha))
                .collect(Collectors.toList());
        return listByAlpha;
    }
}