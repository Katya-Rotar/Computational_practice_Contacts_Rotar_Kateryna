package output;

import data.CRUD_operations_in_contacts;
import data.Contact_Information;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRUD_operations_in_contacts crud = new CRUD_operations_in_contacts();
        List<Contact_Information> contact = new ArrayList<>();
        int id = 0;
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
                case "1" -> {
                    if(!contact.isEmpty()){
                        crud.readContact(contact);
                    }else {
                        System.out.println("Контакти відсутні");
                    }
                }
                case "2" ->{
                    System.out.println("""
                            Сортувати за:
                            1. Ім'ям
                            2. Прізвищем
                            3. Днем народження""");
                    String sort_action = scanner.nextLine();
                    crud.sortContact(contact, sort_action);
                }
                case "3" -> {
                    System.out.println("Додавання нового контакту\n" +
                            "-------------------------");
                    System.out.println("Ім'я:");
                    String name = scanner.nextLine();
                    System.out.println("Прізвище:");
                    String lastname = scanner.nextLine();
                    System.out.println("Телефон:");
                    int phone_number = Integer.parseInt(scanner.nextLine());
                    // обмеження в кількості чисел
                    // замінити




                    System.out.println("Email:");
                    String email = scanner.nextLine();
                    System.out.println("День народження:");
                    // зробити можливіть не уводити день народження або певний фрагмет без викиду помилок
                    System.out.println("Рік:");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("Місяць");
                    int month = Integer.parseInt(scanner.nextLine());
                    System.out.println("День");
                    int day = Integer.parseInt(scanner.nextLine());
                    LocalDate date_of_birth = LocalDate.of(year,month,day);
                    Contact_Information contact_information = new Contact_Information(id, name, lastname, phone_number,
                            email, date_of_birth);
                    crud.addContact(contact_information, contact);
                }
                case "4" ->{

                }
                case "5" ->{
                    System.out.println("Введіть контакт який потрібно видалити");
                    String delete_contact = scanner.nextLine();
                    int id_delete = crud.searchContact(contact, delete_contact);
                    // якщо нічого не знайдено не видаляємо
                    // передбачити випадок коли під час пошуку знайдено кілька значень
                    crud.deleteContact(contact, id_delete);
                }
                case "6" -> {
                    System.out.println("Введіть контакт який потрібно ");
                    String search_contact = scanner.nextLine();
                    crud.searchContact(contact,search_contact);
                }
                case "0" -> System.exit(0);
                default -> System.out.println("Такої дії не існує. Виберіть іншу\n");
            }
        }
    }
}