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
                    System.out.println("День народження:");
                    System.out.println("Рік:");
                    String year = scanner.nextLine();
                    int now_year = LocalDate.now().getYear();
                    int year_of_birth = Integer.parseInt(year);
                    if(year.length() < 1 || year_of_birth > now_year){
                        year_of_birth = now_year;
                    }
                    System.out.println("Місяць");
                    String month = scanner.nextLine();
                    int month_of_birth = Integer.parseInt(month);
                    if(month.length() < 1 || month_of_birth < 1 || month_of_birth > 12){
                        month_of_birth = 0;
                    }
                    System.out.println("День");
                    String day = scanner.nextLine();
                    int day_of_birth = Integer.parseInt(day);
                    if(day.length() < 1 || day_of_birth < 1 || day_of_birth > 31){
                        day_of_birth = 0;
                    }
                    LocalDate date_of_birth = LocalDate.of(year_of_birth,month_of_birth,day_of_birth);
                    Contact_Information contact_information = new Contact_Information(id, name, lastname, phone_number,
                            email, date_of_birth);
                    crud.addContact(contact_information);
                }
                case "4" ->{

                }
                case "5" ->{
                    System.out.println("Введіть контакт який потрібно видалити");
                    String delete_contact = scanner.nextLine();
                    int id_delete = crud.searchContact(delete_contact);
                    // якщо нічого не знайдено не видаляємо
                    // передбачити випадок коли під час пошуку знайдено кілька значень
                    crud.deleteContact(id_delete);
                }
                case "6" -> {
                    System.out.println("Введіть контакт який потрібно ");
                    String search_contact = scanner.nextLine();
                    crud.searchContact(search_contact);
                }
                case "7" -> System.out.println("""
                    Ця програма використовується для збереження інформації про абонента та його номер\s
                    В ній ви зможите переглядати контакти (1), сортувати контакти (2), додати контакт (3),
                    редагувати контакт (4), видалити контакт (5).
                    """);
                case "0" -> System.exit(0);
                default -> System.out.println("Такої дії не існує. Виберіть іншу\n");
            }
        }
    }
}