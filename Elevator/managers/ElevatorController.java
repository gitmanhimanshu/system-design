package Elevator.managers;

import java.util.ArrayList;
import java.util.List;

import Elevator.models.Elevator;
import Elevator.requests.ExternalRequest;
import Elevator.strategies.DispatchStrategy;

public class ElevatorController {
 private static ElevatorController instance;
 private List<Elevator> elevators;
    private DispatchStrategy dispatchStrategy;
   private ElevatorController(){
    elevators=new ArrayList<>();
   } 
   public static ElevatorController getInstance(){
    if(instance==null){
     instance=new ElevatorController();
    }
    return instance;
   }
   public void registerElevator(Elevator elevator) {
    elevators.add(elevator);
   }
   public void setDispatchStrategy(DispatchStrategy dispatchStrategy) {
    this.dispatchStrategy = dispatchStrategy;
   }
   public List<Elevator> getElevators(){
    return elevators;
   }
   public void handleExternalRequest(ExternalRequest request) {
    Elevator selected=dispatchStrategy.selectElevator(elevators, request);
    System.out.println("Selected Elevator: " + selected.getId());
    selected.addStop(request.getFloor());
}
}