package lab_1.trip;

import lab_1.route.Route;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

public class TripBuilder {
    private Trip trip;

    public TripBuilder() {
        trip = new Trip();
    }

    public TripBuilder addRoute(Route route){
        trip.setRoute(route);

        return this;
    }
    public TripBuilder addStartTime(LocalDateTime start){
        trip.setStart(start);

        return this;
    }
    public TripBuilder addEndTime(LocalDateTime end){
        trip.setEnd(end);

        return this;
    }
    public Trip build(){
        validate(trip);
        return trip;
    }
    private static void validate(Trip route) throws IllegalArgumentException{
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Trip>> check = validator.validate(route);
        StringBuilder builder = new StringBuilder();
        for(ConstraintViolation<Trip> i: check){
            builder.append("Error ").append(i.getInvalidValue()).append(" Because ").append(i.getMessage()).append("\n");
        }
        if(builder.length() > 0){
            throw new IllegalArgumentException(builder.toString());
        }
    }
}
