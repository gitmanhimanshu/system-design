package Elevator.requests;

import Elevator.enums.Direction;

public class ExternalRequest {
  private int floor;
  private Direction direction;
  public ExternalRequest(int floor, Direction direction) {
    this.floor = floor;
    this.direction = direction;
  }
  public int getFloor() {
    return floor;
  }
  public Direction getDirection() {
    return direction;
  }
}
