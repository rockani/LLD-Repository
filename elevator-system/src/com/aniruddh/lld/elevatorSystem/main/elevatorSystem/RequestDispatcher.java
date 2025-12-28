package com.aniruddh.lld.elevatorSystem.main.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.main.model.Elevator;
import com.aniruddh.lld.elevatorSystem.main.model.HallRequest;

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
