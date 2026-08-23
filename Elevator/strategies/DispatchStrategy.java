package Elevator.strategies;
import java.util.*;

import Elevator.models.Elevator;
import Elevator.requests.ExternalRequest;
public interface DispatchStrategy {
  Elevator selectElevator(List<Elevator> elevators, ExternalRequest request);
}
