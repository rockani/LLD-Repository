import com.aniruddh.lld.elevatorSystem.elevatorSystem.DirectionAwareScheduler;
import com.aniruddh.lld.elevatorSystem.elevatorSystem.ElevatorManager;
import com.aniruddh.lld.elevatorSystem.elevatorSystem.ElevatorSystem;
import com.aniruddh.lld.elevatorSystem.elevatorSystem.RequestDispatcher;
import com.aniruddh.lld.elevatorSystem.model.Elevator;
import com.aniruddh.lld.elevatorSystem.model.HallPanelDisplay;
import com.aniruddh.lld.elevatorSystem.model.HallRequest;
import com.aniruddh.lld.elevatorSystem.publisher.ElevatorEventPublisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // GLOBAL EVENT BUS
        ElevatorEventPublisher publisher = new ElevatorEventPublisher(new ArrayList<>());

        // Add hall display panels on floors 0–10
        for (int floor = 0; floor <= 10; floor++) {
            publisher.subscribe(new HallPanelDisplay(floor));
        }

        List<Elevator> elevatorList = new ArrayList<>(Arrays.asList(new Elevator(1,publisher),new Elevator(2,publisher),new Elevator(3,publisher),
                new Elevator(4,publisher)));
        // Create ElevatorSystem using your constructors
        // Works with all variations you uploaded
        ElevatorSystem system = new ElevatorSystem(

                new RequestDispatcher(new DirectionAwareScheduler()) , new ElevatorManager(elevatorList)
        );

        // Few test hall requests
        system.handleRequest(new HallRequest(0, 7));   // from ground floor to 7
        system.handleRequest(new HallRequest(3, 10));  // from floor 3 to 10
        system.handleRequest(new HallRequest(9, 2));   // down request

        // Simulate time-based movement (ticks)
        for (int t = 0; t < 25; t++) {
            System.out.println("\n===== TIME STEP " + t + " =====");
            system.step();

            // Optional: print elevator states (clean console output)
            system.getElevators().forEach(e -> {
                System.out.println(
                        "Elevator " + e.getId() +
                                " | floor=" + e.getCurrentFloorNumber() +
                                " | dir=" + e.getCurrentDirection()
                );
            });

            Thread.sleep(500);
        }
    }
}
