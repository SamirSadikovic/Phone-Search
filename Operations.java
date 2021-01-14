import java.util.HashMap;
import java.util.Map;

public final class Operations {   
    public static final Map<Character, Operation> CODES = new HashMap<Character, Operation>() {
        {
        try {
            put('1', new Operation("add a number", PhoneSearch.class.getMethod("addNumber")));

            put('2', new Operation("search for a number", PhoneSearch.class.getMethod("searchNumber")));
    
            put('3', new Operation("search for a person by phone number", PhoneSearch.class.getMethod("searchPersonByNumber")));
    
            put('4', new Operation("add an address", PhoneSearch.class.getMethod("addAddress")));
    
            put('5', new Operation("search for personal information", PhoneSearch.class.getMethod("searchPersonal")));
    
            put('6', new Operation("delete personal information", PhoneSearch.class.getMethod("deletePersonal")));
    
            put('7', new Operation("filtered listing", PhoneSearch.class.getMethod("searchPersonalFilter")));
    
            put('x', new Operation("quit", PhoneSearch.class.getMethod("quit")));

        } catch (Exception e) {
            System.out.println("no such method");
        }
    }};
}
