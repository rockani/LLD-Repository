package com.aniruddh.lld.elevatorSystem.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.model.Elevator;
import com.aniruddh.lld.elevatorSystem.model.HallRequest;

import java.util.List;

public class ElevatorSystem {
    private final RequestDispatcher requestDispatcher;
    private final ElevatorManager elevatorManager;
    public ElevatorSystem(RequestDispatcher requestDispatcher, ElevatorManager elevatorManager) {
        this.requestDispatcher = requestDispatcher;
        this.elevatorManager = elevatorManager;
    }

    public  void handleRequest(HallRequest hallRequest) {
        List<Elevator> elevatorList = elevatorManager.getElevatorList();
        Elevator assignedElevator = requestDispatcher.dispatch(hallRequest, elevatorList);

    }
    public void step() {
        elevatorManager.stepAll();
    }

    public List<Elevator> getElevators() {
        return elevatorManager.getElevatorList();
    }
}
