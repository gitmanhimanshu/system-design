
package Meeting.strategies;
import Meeting.models.*;
public class SmsStrategy implements  NotificationStrategy{
    public void send(User user, String message){
        System.out.println(user.getName()+" "+message);
    }
}