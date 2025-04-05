package model;
import java.io.Serializable ;

public class Person implements Serializable {
    protected String name;
    protected String id;
    protected String email;

    public Person(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
