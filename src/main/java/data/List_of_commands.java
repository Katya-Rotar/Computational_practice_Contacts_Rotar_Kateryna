package data;

import java.util.List;

public interface List_of_commands {
    void readContact(List<Contact_Information> informationList);
    void sortContact(List<Contact_Information> informationList, String sort);
    void addContact(Contact_Information contact_information, List<Contact_Information> informationList);
    void updateContact(Contact_Information contact_information);
    void deleteContact(List<Contact_Information> informationList, int delete);
    int searchContact(List<Contact_Information> informationList, String search);
}
