package com.aniruddh.lld.elevatorSystem.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.model.Elevator;
import com.aniruddh.lld.elevatorSystem.model.HallRequest;

import java.util.List;

public class RequestDispatcher {

    private final Scheduler scheduler;

    public RequestDispatcher(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Elevator dispatch(HallRequest request, List<Elevator> elevators) {
        Elevator chosen = scheduler.assignElevator(request, elevators);
        chosen.addStop(request.getSourceFloor());
        chosen.addStop(request.getDestinationFloor());
        return chosen;
    }
}
