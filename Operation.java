import java.lang.reflect.Method;

public class Operation {
    String name;
    Method method;

    public Operation(String name, Method method) {
        this.name = name;
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }
}
