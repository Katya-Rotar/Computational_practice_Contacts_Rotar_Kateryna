package data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CRUD_operations_in_contacts implements List_of_commands {
    List<Contact_Information> contact = new ArrayList<>();
    @Override
    public void readContact() {
        if(!contact.isEmpty()){
            for (Contact_Information information : contact) {
                System.out.println(information);
            }
        }else {
            System.out.println("Контакти відсутні");
        }
    }

    @Override
    public void sortContact(String sort) {
        switch (sort) {
            case "1" -> contact.sort(Comparator.comparing(Contact_Information::name));
            case "2" -> contact.sort(Comparator.comparing(Contact_Information::lastname));
            case "3" -> contact.sort(Comparator.comparing(Contact_Information::date_of_birth));
            default -> System.out.println("Такої дії не існує");
        }
    }

    @Override
    public void addContact(Contact_Information contact_information) {
        contact.add(contact_information);
    }

    @Override
    public void updateContact(Contact_Information contact_information) {

    }

    @Override
    public void deleteContact(int delete) {
        contact.remove(delete);
    }

    @Override
    public int searchContact(String search) {
        int id_contact = -1;
        int the_number_of_searches = 0;
        for (Contact_Information search_information : contact){
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
