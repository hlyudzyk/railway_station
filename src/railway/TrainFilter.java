package railway;

import java.time.LocalDateTime;

public class TrainFilter {
    private boolean hasSeatsValue;
    private boolean hasDestinationValue;
    private boolean hasDepartureDateTimeValue;
    private String destinationValue;
    private LocalDateTime departureDateTimeValue;

    private TrainFilter(Builder builder){
        this.hasDestinationValue = builder.hasDestinationValue;
        this.hasDepartureDateTimeValue = builder.hasDepartureDateTimeValue;
        this.hasSeatsValue = builder.hasSeatsValue;
        this.destinationValue = builder.destinationValue;
        this.departureDateTimeValue = builder.departureDateTimeValue;
    }

    public boolean matches(Train train){
        if(hasSeatsValue && (train.getTotalSeats()==0)){
            return false;
        }
        if(hasDestinationValue &&
            (!train.getDestination().equals(this.destinationValue))){
            return false;
        }
        if(hasDepartureDateTimeValue&&
            train.getDepartureDateTime().isBefore(this.departureDateTimeValue)){
            return false;
        }
        return true;
    }

    public static class Builder{
        private boolean hasDestinationValue;
        private boolean hasDepartureDateTimeValue;
        private boolean hasSeatsValue;
        private String destinationValue;
        private LocalDateTime departureDateTimeValue;
        public Builder withDestinationValue(String destination){
            this.hasDestinationValue = true;
            this.destinationValue = destination;
            return this;
        }

        public Builder withDepartureTimeValue(LocalDateTime dateTime){
            this.hasDepartureDateTimeValue = true;
            this.departureDateTimeValue = dateTime;
            return this;
        }

        public Builder withSeatsValue(){
            this.hasSeatsValue = true;
            return this;
        }

        public TrainFilter build(){
            return new TrainFilter(this);
        }
    }




}
