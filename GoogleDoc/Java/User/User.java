package Java.User;
public class User{
 private String name;
  private String email;
  private String id;
  private Role role;
  public User(String name, String email, String id, Role role) {
    this.name = name;
    this.email = email;
    this.id = id;
    this.role = role;
  }
  public String getName() {
    return name;
  }
  public String getEmail() {
    return email;
  }
  public String getId() {
    return id;
  }
  public Role getRole() {
    return role;
  }
}
