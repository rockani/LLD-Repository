package com.aniruddh.lld.elevatorSystem.elevatorSystem;

import com.aniruddh.lld.elevatorSystem.enums.Direction;
import com.aniruddh.lld.elevatorSystem.model.Elevator;
import com.aniruddh.lld.elevatorSystem.model.HallRequest;

import java.util.List;

public class DirectionAwareScheduler implements Scheduler {
    @Override
    public Elevator assignElevator(HallRequest req, List<Elevator> elevators) {
        Elevator best = null;
        int bestScore = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloorNumber() - req.getSourceFloor());

            int directionPenalty =
                    (e.getCurrentDirection() != Direction.IDLE &&
                            e.getCurrentDirection() != req.getDirection()) ? 5 : 0;

            int score = distance + directionPenalty;

            if (score < bestScore) {
                bestScore = score;
                best = e;
            }
        }
        return best;
    }
}
