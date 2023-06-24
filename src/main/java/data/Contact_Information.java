package data;

import java.time.LocalDate;

public record Contact_Information(int id, String name, String lastname, int phone_number, String email,
                                  LocalDate date_of_birth, Contact_Groups contact_groups) {
}
// перевизначити toString, створити межі номеру телефону, якщо значення не були введені не виводити їх