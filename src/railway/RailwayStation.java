package railway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RailwayStation {
    public static void main(String[] args){

        ArrayList<Train> trains = new ArrayList<>();

        trains.add(new Train(1,"Odesa", LocalDateTime.now().plusHours(13),20,10));
        trains.add(new Train(2,"Lviv", LocalDateTime.now().plusHours(10),10,5));
        trains.add(new Train(3,"Kyiv", LocalDateTime.now().plusHours(7),1,5));
        trains.add(new Train(4,"Lviv", LocalDateTime.now().plusHours(17),20,10));
        trains.add(new Train(5,"Odesa", LocalDateTime.now().plusHours(17),20,10));
        trains.add(new Train(6,"Lviv", LocalDateTime.now().plusHours(17),20,10));

        List<Train> trainsToLviv = RailwayDispatcher.getTrains(trains,
            new TrainFilter.Builder().withDestinationValue("Lviv").build());

        List<Train> trainsToOdesaTomorrow = RailwayDispatcher.getTrains(trains,
            new TrainFilter.Builder().withDestinationValue("Odesa").
                withDepartureTimeValue(LocalDateTime.now().plusHours(12)).build());

        List<Train> trainsToKyivAndSeats = RailwayDispatcher.getTrains(trains,
            new TrainFilter.Builder().withDestinationValue("Kyiv").
                withSeatsValue().build());

        RailwayDispatcher.printTrains(trainsToLviv);
        RailwayDispatcher.printTrains(trainsToOdesaTomorrow);
        RailwayDispatcher.printTrains(trainsToKyivAndSeats);

    }
}
