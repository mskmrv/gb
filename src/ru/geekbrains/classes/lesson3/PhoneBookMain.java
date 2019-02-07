package ru.geekbrains.classes.lesson3;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иван", "+77899874774");
        phoneBook.add("Елена", "89878744878");
        phoneBook.add("Елена", "89888888888");
        phoneBook.add("Петр", "89777777777");
        phoneBook.add("Петр", "89666666666");
        phoneBook.add("Петр", "89555555555");

        System.out.println(phoneBook.get("Иван"));
        System.out.println(phoneBook.get("Елена"));
        System.out.println(phoneBook.get("Петр"));
    }
}
