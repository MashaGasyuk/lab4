package lab_1;

import lab_1.route.Route;
import lab_1.trip.Trip;
import lab_1.trip.TripBuilder;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class ScheduleTest {
    @Test
    public void goodtest(){
        Route route = new Route.Builder()
                .addCode("aaa11")
                .addStation(new Station("211"))
                .addStation(new Station("s21"))
                .addStation(new Station("s31"))
                .build();
        Trip trip = new TripBuilder()
                .addRoute(route)
                .addStartTime(LocalDateTime.of(2020,10,11,9,15))
                .addEndTime(LocalDateTime.of(2020,10,11,10,0))
                .build();
        Route route1 = new Route.Builder()
                .addCode("aaa12")
                .addStation(new Station("212"))
                .addStation(new Station("s22"))
                .addStation(new Station("s32"))
                .build();
        Trip trip1 = new TripBuilder()
                .addRoute(route)
                .addStartTime(LocalDateTime.of(2020,10,11,9,15))
                .addEndTime(LocalDateTime.of(2020,10,11,10,0))
                .build()
                ;

        Schedule schedule = new Schedule.Builder().addTrip(trip).addTrip(trip1).build();
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest(){
        Schedule schedule = new Schedule.Builder().build();
    }

}