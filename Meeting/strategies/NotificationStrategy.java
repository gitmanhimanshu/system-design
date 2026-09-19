package Meeting.strategies;

import Meeting.models.*;
public interface NotificationStrategy{
    public void send(User user,String message);
}