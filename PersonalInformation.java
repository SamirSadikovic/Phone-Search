import java.util.ArrayList;

public class PersonalInformation {
    private ArrayList<Address> addresses;
    private ArrayList<String> numbers;

    public PersonalInformation() {
        this.addresses = new ArrayList<Address>();
        this.numbers = new ArrayList<String>();
    }

    public void addAddress(String city, String street) {
        this.addresses.add(new Address(city, street));
    }

    public void addPhoneNumber(String number) {
        this.numbers.add(number);
    }

    public ArrayList<String> getPhoneNumbers() {
        return this.numbers;
    }

    public ArrayList<Address> getAddresses() {
        return this.addresses;
    }

    public void printInfo() {
        this.printPhoneNumbers();
        this.printAddresses();
    }

    public void printAddresses() {
        if(this.addresses.isEmpty())
            System.out.println("address unknown");
        else{
            System.out.println("addresses:");
            for(Address address : addresses)
                System.out.println(address);
        }
    }

    public void printPhoneNumbers() {
        if(this.numbers.isEmpty())
            System.out.println("phone number not found");
        else{
            System.out.println("phone numbers:");
            for(String number : this.numbers)
                System.out.println(number);
        }
    }
}
