package output;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("""
                    -----------------------
                    1. Переглянути контакти
                    2. Сортувати контакти
                    3. Додати контакт
                    4. Редагувати контакт
                    5. Видалити контакт
                    6. Пошук
                    7. Допомога
                    Exit - 0
                    -----------------------""");
            String action_1 = scanner.nextLine();
            switch (action_1){
                case "0" -> System.exit(0);
                default -> System.out.println("Такої дії не існує. Виберіть іншу\n");
            }
        }

    }
}