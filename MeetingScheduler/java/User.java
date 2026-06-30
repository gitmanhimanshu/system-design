package MeetingScheduler.java;

public class User {
    private String name;
    private String id;
    private String email;

    public User(String name, String id, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }
}
