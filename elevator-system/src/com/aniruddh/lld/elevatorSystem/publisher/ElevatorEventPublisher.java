package com.aniruddh.lld.elevatorSystem.publisher;

import com.aniruddh.lld.elevatorSystem.event.ElevatorEvent;
import com.aniruddh.lld.elevatorSystem.event.ElevatorEventListener;

import java.util.List;

public class ElevatorEventPublisher {
    public ElevatorEventPublisher(List<ElevatorEventListener> elevatorEventListeners) {
        this.elevatorEventListeners = elevatorEventListeners;
    }

    private final List<ElevatorEventListener> elevatorEventListeners;
    public void subscribe(ElevatorEventListener elevatorEventListener) {
        elevatorEventListeners.add(elevatorEventListener);
    }

    public void publish(ElevatorEvent event) {
        for(ElevatorEventListener elevatorEventListener : elevatorEventListeners){
            elevatorEventListener.onElevatorEvent(event);
        }
    }
}
