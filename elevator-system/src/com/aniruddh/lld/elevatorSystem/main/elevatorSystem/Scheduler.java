package com.aniruddh.lld.elevatorSystem.main.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.main.model.Elevator;
import com.aniruddh.lld.elevatorSystem.main.model.HallRequest;

import java.util.List;

public interface Scheduler {
    Elevator assignElevator(HallRequest request, List<Elevator> elevatorList);
}
