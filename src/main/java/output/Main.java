package output;

import data.CRUD_operations_in_contacts;
import data.Contact_Information;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRUD_operations_in_contacts crud = new CRUD_operations_in_contacts();
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
                case "1" -> crud.readContact();
                case "2" ->{
                    System.out.println("""
                            Сортувати за:
                            1. Ім'ям
                            2. Прізвищем
                            3. Днем народження""");
                    String sort_action = scanner.nextLine();
                    crud.sortContact(sort_action);
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
                    LocalDate date_of_birth = date_of_birth();
                    Contact_Information contact_information = new Contact_Information(id, name, lastname, phone_number,
                            email, date_of_birth);
                    crud.addContact(contact_information);
                }
                case "4" ->{
                    Scanner new_scanner = new Scanner(System.in);
                    System.out.println("""
                            Редагування контакта
                            ------------
                            Введіть номер контакту який потрібно змінити""");
                    String search_update = new_scanner.nextLine();
                    int id_update = crud.searchContact(search_update);
                    boolean exit = false;

                    // передбачити декілька пошуку або контакт не знайдено
                    String new_name = " ", new_lastname = " ", new_email = " ";
                    int new_phone_number = 0;
                    LocalDate new_date_of_birth = LocalDate.of(0,1,1);

                    while (!exit){
                        System.out.println("""
                                Виберіть дані які хочите змінити
                                1. Ім'я
                                2. Прізвище
                                3. Номер телефону
                                4. Email
                                5. День народження
                                Зберегти зміни - 0""");
                        String action_update = new_scanner.nextLine();
                        switch (action_update){
                            case "1" ->{
                                System.out.println("Введіть нове ім'я:");
                                new_name = new_scanner.nextLine();
                            }
                            case "2" -> {
                                System.out.println("Введіть нове прізвище:");
                                new_lastname = new_scanner.nextLine();
                            }
                            case "3" ->{
                                System.out.println("Введіть новий номер телефону:");
                                new_phone_number = Integer.parseInt(new_scanner.nextLine());
                            }
                            case "4" -> {
                                System.out.println("Введіть новий email:");
                                new_email = new_scanner.nextLine();
                            }
                            case "5"-> new_date_of_birth = date_of_birth();
                            case "0" ->{
                                crud.updateContact(new_name, new_lastname, new_phone_number, new_email, new_date_of_birth,
                                        id_update);
                                exit = true;
                            }
                        }
                    }
                }
                case "5" ->{
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("Введіть контакт який потрібно видалити");
                        String delete_contact = scanner.nextLine();
                        int id_delete = crud.searchContact(delete_contact);
                        switch (id_delete){
                            case -1 -> {
                                System.out.println("Контакт не знайдено");
                                exit = true;
                            }
                            case -2 -> System.out.println("""

                                    Знайдено декілька контактів уточніть інформацію про контакт який потрібно видалити
                                    """);
                            default -> {
                                System.out.println("Контакт видалено");
                                crud.deleteContact(id_delete);
                                exit = true;
                            }
                        }
                        // якщо нічого не знайдено не видаляємо
                        // передбачити випадок коли під час пошуку знайдено кілька значень
                    }
                }
                case "6" -> {
                    System.out.println("Введіть контакт який потрібно найти");
                    String search_contact = scanner.nextLine();
                    int id_search = crud.searchContact(search_contact);
                    if(id_search == -1){
                        System.out.println("Контакт не знайдено");
                    }
                }
                case "7" -> System.out.println("""
                    Ця програма використовується для збереження інформації про абонента та його номер\s
                    В ній ви зможите переглядати контакти (1), сортувати контакти (2), додати контакт (3),
                    редагувати контакт (4), видалити контакт (5), знайти контакт (6). Контакт можна знайти
                    за ім'ям, прізвищем, телефоном і email.
                    """);
                case "0" -> System.exit(0);
                default -> System.out.println("Такої дії не існує. Виберіть іншу\n");
            }
    }
}
    public static LocalDate date_of_birth(){
        Scanner new_scanner = new Scanner(System.in);
        System.out.println("День народження: (якщо не відомо то 0)");
        System.out.println("Рік:");
        int year = new_scanner.nextInt();
        if (year < 0 || year > LocalDate.now().getYear()){
            year = 0;
        }
        System.out.println("Місяць");
        int month = new_scanner.nextInt();
        if(month < 1 || month > 12){
            month = 1;
        }
        System.out.println("День");
        int day = new_scanner.nextInt();
        if(day < 1 || day > 31){
           day = 1;
        }
        // передбачити уведення не int

        return LocalDate.of(year,month,day);
}
}
