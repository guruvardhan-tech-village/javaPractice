package student;

/**
 * Base class for all users in the system.
 */
public class User {
    // Protected allows the Student subclass to access this directly
    protected String name;

    // Constructor to initialize the user's name
    public User(String name) {
        this.name = name;
    }

    // Getter method for the name
    public String getName() {
        return name;
    }

    // Setter method to update the name if needed
    public void setName(String name) {
        this.name = name;
    }
}