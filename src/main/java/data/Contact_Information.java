package data;

import java.time.LocalDate;

public record Contact_Information(int id, String name, String lastname, int phone_number, String email,
                                  LocalDate date_of_birth) {
    @Override
    public String toString() {
        String name1 = "", lastname1 = "",phone_number1 = "", email1 = "", date_of_birth1;
        if(name.length() > 1){
            name1 = "Ім'я: " + name;
        }
        if(lastname.length() > 1){
            lastname1 = "\nПрізвище: " + lastname ;
        }
        if(phone_number > 1){
            phone_number1 = "\nТелефон: " + phone_number;
        }
        if(email.length() > 1){
            email1 = "\nEmail: " + email;
        }
        LocalDate today = LocalDate.now();
        if(date_of_birth.getMonth() == today.getMonth() && date_of_birth.getDayOfMonth() == today.getDayOfMonth()){
            date_of_birth1 = "\nДень народження: сьогодні";
        }else {
            date_of_birth1 = "\nДень народження: "+ date_of_birth;
        }
        return name1 + lastname1 + phone_number1 + email1 + date_of_birth1;
    }
}

// перевизначити toString, створити межі номеру телефону, якщо значення не були введені не виводити їх