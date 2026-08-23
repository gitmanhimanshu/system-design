package Elevator;

import Elevator.enums.Direction;
import Elevator.managers.ElevatorController;
import Elevator.models.Elevator;
import Elevator.requests.ExternalRequest;
import Elevator.strategies.NearestElevatorStrategy;

public class main {
  public static void main(String[] args) {
   ElevatorController controller=ElevatorController.getInstance();
   controller.setDispatchStrategy(new NearestElevatorStrategy()); 
   Elevator e1=new Elevator(1);
   Elevator e2=new Elevator(2);
   controller.registerElevator(e1);
   controller.registerElevator(e2);
   controller.handleExternalRequest(new ExternalRequest(5, Direction.UP));
   e1.addStop(8);

   while(e1.getDirection()!=Direction.IDLE){
    e1.step();
   }
  }

}
