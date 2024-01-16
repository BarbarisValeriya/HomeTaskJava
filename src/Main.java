
import java.util.*;

public class Main {
    // Реализуйте структуру телефонной книги с помощью HashMap.
    //Программа также должна учитывать, что в во входной структуре
    // будут повторяющиеся имена с разными телефонами,
    // их необходимо считать, как одного человека с разными телефонами.
    // Вывод должен быть отсортирован по убыванию числа телефонов.
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "8-906-786-56-67");
        addContact(phoneBook, "Панин", "8-926-456-34-21");
        addContact(phoneBook, "Кожухов", "8-789-345-67-89");
        addContact(phoneBook, "Иванов", "+375-678-987-23-11");
        addContact(phoneBook, "Панин", "8-678-901-23-45");
        addContact(phoneBook, "Иванов", "9-934-567-11-22");

        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
    List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
       sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        // Вывод телефонной книги
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}