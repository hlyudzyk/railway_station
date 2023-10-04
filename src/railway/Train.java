package railway;

import java.time.LocalDateTime;


public final class Train {
    private final int trainNumber;
    private final String destination;
    private final LocalDateTime departureDateTime;
    private final int totalSeats;
    private final int coupeSeats;
    private final int platzKartSeats;

    public Train(){
        this(0,"No destination",LocalDateTime.now(),0,0);
    }
    public Train(int trainNumber, String destination, LocalDateTime departureDateTime,
        int coupeSeats,int platzKartSeats){
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.coupeSeats = coupeSeats;
        this.platzKartSeats = platzKartSeats;
        this.totalSeats = coupeSeats + platzKartSeats;

    }

    public int getTrainNumber(){
        return this.trainNumber;
    }
    public String getDestination(){
        return this.destination;
    }
    public LocalDateTime getDepartureDateTime(){ return this.departureDateTime;}
    public int getTotalSeats(){return this.totalSeats;}

    @Override
    public String toString(){
        return "This is train number " + this.trainNumber +" and it's heading to: " + this.destination
            + " at " + this.getDepartureDateTime().toString();
    }



}
