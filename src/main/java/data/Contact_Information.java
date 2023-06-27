package data;

import java.time.LocalDate;

public record Contact_Information(String name, String lastname, int phone_number, String email,
                                  LocalDate date_of_birth, Contact_Groups contact_groups) {
    @Override
    public String toString() {
        StringBuilder output_contact = new StringBuilder();
        if(name.length() > 1){
            output_contact.append("\nІм'я: ").append(name);
        }
        if(lastname.length() > 1){
            output_contact.append("\nПрізвище: ").append(lastname);
        }
        if(phone_number > 1){
            output_contact.append("\nТелефон: ").append(phone_number);
        }
        if(email.length() > 1){
            output_contact.append("\nEmail: ").append(email);
        }
        LocalDate today = LocalDate.now();
        if(date_of_birth.getMonth() == today.getMonth() && date_of_birth.getDayOfMonth() == today.getDayOfMonth()){
            output_contact.append("\nДень народження: сьогодні");
        }else {
            output_contact.append("\nДень народження: ").append(date_of_birth);
        }
        output_contact.append("\nГрупа: ").append(contact_groups);
        return output_contact.toString();
    }
}