package data;

import java.util.List;

public interface List_of_commands {
    void readContact();
    void sortContact(String sort);
    void addContact(Contact_Information contact_information);
    void updateContact(Contact_Information contact_information);
    void deleteContact(int delete);
    int searchContact(String search);
}
