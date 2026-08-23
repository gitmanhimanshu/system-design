package Elevator.models;

import java.util.Collections;
import java.util.TreeSet;
import Elevator.enums.Direction;
public class Elevator {
 private int id;
 private int currentFloor;
 private Direction direction;
 private TreeSet<Integer> upStops;
 private TreeSet<Integer> downStops;
 public Elevator(int id){
  this.id = id;
  this.currentFloor = 0;
  this.direction = Direction.IDLE;
  this.upStops = new TreeSet<>();
  this.downStops = new TreeSet<>();
 }
 public void addStop(int floor){
  if(floor>this.currentFloor){
    upStops.add(floor);
    if(this.direction==Direction.IDLE){
      this.direction = Direction.UP;
    }
  }else if(floor<this.currentFloor){
    downStops.add(floor);
    if(this.direction==Direction.IDLE){
      this.direction = Direction.DOWN;
    }
  }
 }
  public void step(){
    if(this.direction==Direction.UP&&!upStops.isEmpty()){
      this.currentFloor=upStops.pollFirst();
      stopAndOpenDoor();
      if(upStops.isEmpty()){
        this.direction = downStops.isEmpty() ? Direction.IDLE : Direction.DOWN;
      }
    }else if(this.direction==Direction.DOWN&&!downStops.isEmpty()){
      this.currentFloor=downStops.pollFirst();
      stopAndOpenDoor();
      if(downStops.isEmpty()){
        this.direction = upStops.isEmpty() ? Direction.IDLE : Direction.UP;
      }
    }
  }
   private void stopAndOpenDoor() {
        System.out.println("Elevator " + id + " stopped at floor " + currentFloor + " [door open]");
    }
        public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }

}
