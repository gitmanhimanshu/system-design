package Elevator.strategies;

import java.util.List;

import Elevator.models.Elevator;
import Elevator.requests.ExternalRequest;

public class NearestElevatorStrategy implements DispatchStrategy {
  @Override
  public Elevator selectElevator(List<Elevator> elevators, ExternalRequest request) {
    Elevator best=null;
    int min=Integer.MAX_VALUE;
      for(Elevator e:elevators) {
       int d=Math.abs(e.getCurrentFloor()-request.getFloor());
       if(d<min) {
         min=d;
         best=e;
       }
      }
    return best;
  }
}
