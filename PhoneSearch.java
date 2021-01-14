import java.util.Map;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneSearch {
    private Map<String, PersonalInformation> persons;
    Scanner reader;

    public PhoneSearch(){
        this.persons = new HashMap<String, PersonalInformation>();
        this.reader = new Scanner(System.in);
    }

    public void start() throws IllegalAccessException, InvocationTargetException {
        this.displayMenu();
        Character input;
        do{
            System.out.print("command: ");
            input = reader.nextLine().charAt(0);
            this.handleInput(input);
            System.out.println();
        }while(input != 'x');
    }

    public void displayMenu() {
        System.out.println("phone search");
        System.out.println("available operations: ");
        for(Character key : Operations.CODES.keySet())
            System.out.println(key + ". " + Operations.CODES.get(key).getName());
        System.out.println();
    }

    private void handleInput(Character input) throws IllegalAccessException, InvocationTargetException{
        for(Character key : Operations.CODES.keySet())
            if(input == key)
                Operations.CODES.get(key).getMethod().invoke(this);
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
    
        System.out.print("number: ");
        String number = reader.nextLine();

        if(this.persons.containsKey(name))
            this.persons.get(name).addPhoneNumber(number);
        else{
            this.addPerson(name);
            this.persons.get(name).addPhoneNumber(number);
        }
    }

    public void searchNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();

        if(this.persons.containsKey(name))
            this.persons.get(name).printPhoneNumbers();
        else
            System.out.println("not found");
    }

    public void searchPersonByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();

        for(String person : this.persons.keySet())
            if(this.persons.get(person).getPhoneNumbers().contains(number)){
                System.out.println(person);
                return;
            }
        System.out.println("not found");
    }

    public void addAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();

        System.out.print("street: ");
        String street = reader.nextLine();

        System.out.print("city: ");
        String city = reader.nextLine();

        if(this.persons.containsKey(name))
            this.persons.get(name).addAddress(street, city);
        else{
            this.addPerson(name);
            this.persons.get(name).addAddress(street, city);
        }
    }

    public void searchPersonal() {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        if(this.persons.containsKey(name))
            this.persons.get(name).printInfo();
        else
            System.out.println("not found");
    }

    public void deletePersonal() {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        if(this.persons.containsKey(name))
            this.persons.remove(name);
        else
            System.out.println("not found, nothing was deleted");
    }

    public void searchPersonalFilter() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();

        for(String person : this.persons.keySet()){
            System.out.println();
            if(person.contains(keyword)){
                System.out.println(person);
                this.persons.get(person).printInfo();
                continue;
            }
            for(Address address : this.persons.get(person).getAddresses())
                if(address.getAddress().contains(keyword)){
                    System.out.println(person);
                    this.persons.get(person).printInfo();
                    break;
                }
        }
    }

    public void quit() {}

    private void addPerson(String name) {
        this.persons.put(name, new PersonalInformation());
    }
}
