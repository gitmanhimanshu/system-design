
package Meeting.strategies;
import Meeting.models.*;
public class PushStrategy implements  NotificationStrategy{
    public void send(User user, String message){
        System.out.println(user.getName()+" "+message);
    }
}