package output;

import data.CRUD_operations_in_contacts;
import data.Contact_Information;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRUD_operations_in_contacts crud = new CRUD_operations_in_contacts();
        List<Contact_Information> contact = new ArrayList<>();
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
                case "1" -> crud.readContact(contact);
                case "0" -> System.exit(0);
                default -> System.out.println("Такої дії не існує. Виберіть іншу\n");
            }
        }

    }
}