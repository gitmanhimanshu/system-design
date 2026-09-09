package SplitWise.models;
public class User{
  private String id;
  private String name;
  private long phoneNumber;
  public User(String id, String name, long phoneNumber) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  public String getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public long getNumber(){
    return phoneNumber;
  }
}