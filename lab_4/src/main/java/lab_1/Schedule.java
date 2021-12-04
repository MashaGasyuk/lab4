package lab_1;

import lab_1.trip.Trip;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Клас маршрутів руху. Клас зберігає в собі маршрути. Видає інформацію про них
 */
public class Schedule {
    @NotNull
    @Size(min=1)
    private List<Trip> trips;

    protected Schedule() {
        trips = new ArrayList<>();
    }

    public static class Builder{
        private Schedule schedule;

        public Builder() {
            schedule = new Schedule();
        }
        public Builder addTrip(Trip trip){
            schedule.trips.add(trip);
            return this;
        }
        public Builder setTrips(List<Trip> trips){
            schedule.trips = trips;
            return this;
        }
        public Schedule build(){
            validate(schedule);
            return schedule;
        }
    }
    private static void validate(Schedule route) throws IllegalArgumentException{
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Schedule>> check = validator.validate(route);
        StringBuilder builder = new StringBuilder();
        for(ConstraintViolation<Schedule> i: check){
            builder.append("Error ").append(i.getInvalidValue()).append(" Because ").append(i.getMessage()).append("\n");
        }
        if(builder.length() > 0){
            throw new IllegalArgumentException(builder.toString());
        }
    }
    /**
     * Повертає всі маршрути, які будуть в цей день
     * @param day
     * @return
     */
    public ArrayList<Trip> getTripsAtDay(LocalDateTime day) {
        assert (day!=null);
        ArrayList<Trip> tripsAtDay= new ArrayList<>();
        for (var trip: trips) {
            if(trip.getStartTime().isAfter(day) && trip.getEndTime().isBefore(day)){
                tripsAtDay.add(trip);
            }
        }
        return tripsAtDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(trips, schedule.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trips);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "trips=" + trips +
                '}';
    }
}
