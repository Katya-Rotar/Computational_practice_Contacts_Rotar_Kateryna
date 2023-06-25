package data;

import java.util.Comparator;
import java.util.List;

public class CRUD_operations_in_contacts implements List_of_commands {

    @Override
    public void readContact(List<Contact_Information> informationList) {
        for (Contact_Information information : informationList) {
            System.out.println(information);
        }
    }

    @Override
    public void sortContact(List<Contact_Information> informationList, String sort) {
        switch (sort) {
            case "1" -> informationList.sort(Comparator.comparing(Contact_Information::name));
            case "2" -> informationList.sort(Comparator.comparing(Contact_Information::lastname));
            case "3" -> informationList.sort(Comparator.comparing(Contact_Information::date_of_birth));
        }
    }

    @Override
    public void addContact(Contact_Information contact_information, List<Contact_Information> informationList) {
        informationList.add(contact_information);
    }

    @Override
    public void updateContact(Contact_Information contact_information) {

    }

    @Override
    public void deleteContact(List<Contact_Information> informationList, int delete) {
        informationList.remove(delete);
    }

    @Override
    public int searchContact(List<Contact_Information> informationList, String search) {
        int id_contact = -1;
        int the_number_of_searches = 0;
        for (Contact_Information search_information : informationList){
            String phone = String.valueOf(search_information.phone_number());
            if(search_information.name().contains(search) || search_information.lastname().contains(search) ||
                    phone.contains(search) || search_information.email().contains(search)){
                System.out.println(search_information);
                id_contact = search_information.id();
                the_number_of_searches++;
            }
        }
        if(the_number_of_searches > 1){
            return -1;
        }else {
            return id_contact;
        }
    }
}
