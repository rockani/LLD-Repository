package com.aniruddh.lld.elevatorSystem.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.model.Elevator;
import com.aniruddh.lld.elevatorSystem.model.HallRequest;

import java.util.List;

public interface Scheduler {
    Elevator assignElevator(HallRequest request, List<Elevator> elevatorList);
}
