package data;

import java.util.List;

public interface List_of_commands {
    void readContact(List<Contact_Information> contact_information);
    void sortContact(Contact_Information contact_information, String sort);
    void addContact(Contact_Information contact_information);
    void updateContact(Contact_Information contact_information);
    void deleteContact(Contact_Information contact_information, int delete);
    void searchContact(Contact_Information contact_information);
}
