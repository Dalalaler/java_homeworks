package data;

import data_managment.write;
import data_pattern.task;
import enums.*;


import java.io.IOException;
import java.util.GregorianCalendar;

public class dataToGenerate {


    public static task task1 = new task.Builder()
            .withId((Math.random() * 10000000))
            .withTaskName("Homework 5")
            .withTaskDescription(new String[]{" Изменить поля \"категория\" и \"приоритет\" на перечисляемый тип.",
                    " Сделать задачу не abstract. Добавить builder для задачи.",
                    " Добавить поле \"id\" и использовать возможность параметризации для этого поля." +
                            " Должен быть также параметризован конструктор, геттер и сеттер." +
                            " Создать 2 реализации, параметризованные разными типами (например, String и Integer)"})
            .withTaskCategory(category.NECESSARY)
            .withTaskPriority(priority.HIGH)
            .withDateToComplete(new GregorianCalendar(2020, 10, 16))
            .withHoursToComplete(4.5)
            .build();

    public static task<String> task2 = new task.Builder()
            .withId((String.valueOf(Math.random() * 10000000)))
            .withTaskName("Homework 6")
            .withTaskDescription(new String[]{"1. Добавить список задач. " +
                    "Пользовать может добавить задачу в список, просмотреть весь список.",
                    "2. Задача должна переопределять методы hashCode и equals, " +
                            "имплементить интерфейс Comparable (переопределить метод compareTo).",
                    "3. Пользователь может отсортировать задачи."})
            .withTaskCategory(category.OPTIONAL)
            .withTaskPriority(priority.MIDDLE)
            .withDateToComplete(new GregorianCalendar(2020, 10, 19))
            .withHoursToComplete(6)
            .build();

    public static task<Integer> task3 = new task.Builder()
            .withId((int) (Math.random() * 10000000))
            .withTaskName("Homework 4")
            .withTaskDescription(new String[]{"Предметная область: планировщик задач." +
                    "Требования:", "1. Наличие иерархии, отражающей модель \"Задача\" " +
                    "(интерфейс, абстрактный класс, несколько классов-наследников, имеющих разные особенности). " +
                    "Например: одноразовая задача, повторяемая задача.",
                    "2. Минимальные характеристики задачи: название, категория, приоритет, дата выполнения (строки).",
                    "3. Корректно использовать инкапсуляцию",
                    "4. Клиентский код, в котором создаются задачи разных типов."})
            .withTaskCategory(category.DESIRABLE)
            .withTaskPriority(priority.LOW)
            .withDateToComplete(new GregorianCalendar(2020, 10, 6))
            .withHoursToComplete(2)
            .build();

    public static task<Integer> task4 = new task.Builder()
            .withId((int) (Math.random() * 10000000))
            .withTaskName("Homework 3")
            .withTaskDescription(new String[]{"1. Сформировать строку, которая содержит 100 случайных значений " +
                    "от 0 до 1000, разделённых пробелами (2 способа - String и StringBuilder).",
                    "2. В сформированной в 1-ой задаче строке заменить все двузначные числа на -1." +
                            " - RegEx - регулярные выражения",
                    "3. Пользователь вводит имя и возраст. Вывести сообщение, приветствующее пользователя." +
                            " - форматирование (String.format) через спецификаторы",
                    "4. Разбить строку на отдельные слова и посчитать количество вхождений для каждого слова." +
                            " - через split - будет считать разделителем пробел"})
            .withTaskCategory(category.DESIRABLE)
            .withTaskPriority(priority.LOW)
            .withDateToComplete(new GregorianCalendar(2020, 10, 17))
            .withHoursToComplete(2)
            .build();

    public static task<Integer> task5 = new task.Builder()
            .withId((int) (Math.random() * 10000000))
            .withTaskName("Homework 2")
            .withTaskDescription(new String[]{"1*. Вывести пирамиду из цифр. Размер вводится пользователем." +
                    " Пирамида - фигура такого вида:\n" +
                    "1 1 1 1 1\n" +
                    "1 2 2 2 1\n" +
                    "1 2 3 2 1\n" +
                    "1 2 2 2 1\n" +
                    "1 1 1 1 1",
                    "2 (2 балла). Пользователь вводит месяц и день (числа). Вывести, есть ли день в этом месяце.",
                    "3 (3 балла). Задать пользователю любой вопрос и дать ограниченное количество попыток для верного" +
                            " ответа. Предусмотреть возможность сдаться.",
                    "4 (3 балла). Пользователь вводит число в небольшом диапазоне (от 0 до 100). " +
                            "Программа должна угадать, что это за число и продемонстрировать количество попыток, " +
                            "которое потребовалось для угадывания."})
            .withTaskCategory(category.DESIRABLE)
            .withTaskPriority(priority.LOW)
            .withDateToComplete(new GregorianCalendar(2020, 10, 18))
            .withHoursToComplete(2)
            .build();

    public static task<Integer> task6 = new task.Builder()
            .withId((int) (Math.random() * 10000000))
            .withTaskName("Homework 1")
            .withTaskDescription(new String[]{"1. Задано целое число. Определить, какой день недели соответствует " +
                    "заданному числу и вывести в консоль. Если ни одному - вывести соответствующее сообщение.",
                    "2. Даны два целых числа, задающие три диапазона чисел. Определить, какому диапазону принадлежит " +
                            "введенное пользователем число.",
                    "3. Заданы три числа. Найти среди них минимальное, максимальное и среднее арифметическое и вывести." +
                            " Без использования дополнительных библиотек, только операторы сравнения и логические.",
                    "4. Задано число. Определить, близко ли к нему другое введенное число (в пределах 10%)."})
            .withTaskCategory(category.NECESSARY)
            .withTaskPriority(priority.HIGH)
            .withDateToComplete(new GregorianCalendar(2020, 9, 26))
            .withHoursToComplete(2)
            .build();

    public static void writeReadyData() throws IOException {
        String fileName = ".\\src\\main\\resources\\data.json";
        write.writeInFile(fileName, dataToGenerate.task6);
        write.writeInFile(fileName, dataToGenerate.task1);
        write.writeInFile(fileName, dataToGenerate.task3);
        write.writeInFile(fileName, dataToGenerate.task2);
        write.writeInFile(fileName, dataToGenerate.task5);
        write.writeInFile(fileName, dataToGenerate.task4);
    }


}
