package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        random = new Random();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);
        System.out.println("Блюдо успешно добавлено");
        System.out.println();
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        List<String> types = new ArrayList<>();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            types.add(nextItem);
            nextItem = scanner.nextLine();
        }
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + (i + 1) + ":");
            for (String type : types) {
                List<String> dishesOfType = dc.getDishesByType(type);
                if (dishesOfType.isEmpty()) {
                    System.out.println("Блюда типа " + type + " отсутствуют.");
                } else {
                    int randomIndex = random.nextInt(dishesOfType.size());
                    String randomDish = dishesOfType.get(randomIndex);
                    System.out.println("- " + randomDish);
                }
            }
            System.out.println();
        }
    }
}