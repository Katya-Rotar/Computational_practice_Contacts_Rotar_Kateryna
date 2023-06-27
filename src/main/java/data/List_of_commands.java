package data;

import java.time.LocalDate;

public interface List_of_commands {
    void readContact();
    void sortContact(String sort);
    void addContact(Contact_Information contact_information);
    void updateContact(String new_name, String new_lastname, int new_phone_number, String new_email,
                       LocalDate new_date_of_birth, int id);
    void deleteContact(int delete);
    int searchContact(String search);
}
