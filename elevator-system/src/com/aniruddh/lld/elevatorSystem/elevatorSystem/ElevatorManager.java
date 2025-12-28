package com.aniruddh.lld.elevatorSystem.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.model.Elevator;
import com.aniruddh.lld.elevatorSystem.publisher.ElevatorEventPublisher;

import java.util.List;

public class ElevatorManager {

    List<Elevator> elevatorList;


    public ElevatorManager(List<Elevator> elevatorList) {
        this.elevatorList = elevatorList;

    }


    void stepAll() {
        for (Elevator e : elevatorList) {
            e.step();
        }
    }
    public List<Elevator> getElevatorList() {
        return elevatorList;
    }
}
