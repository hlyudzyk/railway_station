package railway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public final class RailwayDispatcher {
    private RailwayDispatcher(){}
    public static List<Train> getTrains(Collection<Train> trains, TrainFilter trainFilter){
        ArrayList<Train> outTrains = new ArrayList<>();
        for(Train train:trains){
            if(trainFilter.matches(train)){
                outTrains.add(train);
            }
        }
        return outTrains;
    }
    public static void printTrains(Collection<Train> trains){
        for(Train train:trains){
            System.out.println(train.toString());
        }
    }
}
