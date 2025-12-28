package com.aniruddh.lld.elevatorSystem.main.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.main.model.Elevator;

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
