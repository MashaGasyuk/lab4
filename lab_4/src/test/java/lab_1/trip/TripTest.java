package lab_1.trip;

import lab_1.Station;
import lab_1.route.Route;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class TripTest {
    @Test(dataProvider = "simpleProvider")
    public void test(String code, String station, String station1, String station2){
        Route route = new Route.Builder()
                .addCode(code)
                .addStation(new Station(station))
                .addStation(new Station(station1))
                .addStation(new Station(station2)).build();
        Trip trip = new TripBuilder()
                .addRoute(route)
                .addStartTime(LocalDateTime.of(2020,10,11,9,15))
                .addEndTime(LocalDateTime.of(2020,10,11,10,0))
                .build();


        assertEquals(trip.getRoute().getCode(),route.getCode());
    }
    @DataProvider
    public Object[][] simpleProvider(){
        return new Object[][]{
                {"aaa15","a","b","c"}
        };
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest(){
        Route route = new Route.Builder()
                .addCode("aaa1")
                .addStation(new Station("21"))
                .addStation(new Station("s2"))
                .addStation(new Station("s3"))
                .build();
        Trip trip = new TripBuilder()
                .addRoute(route)
                .addStartTime(LocalDateTime.of(2020,10,11,9,15))
                .build()
                ;


    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest1(){
        Route route = new Route.Builder()
                .addCode("aaa1")
                .addStation(new Station("21"))
                .addStation(new Station("s2"))
                .addStation(new Station("s3"))
                .build();
        Trip trip = new TripBuilder()
                .addRoute(route)
                .build()
                ;
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest2(){
        Route route = new Route.Builder()
                .addCode("aaa1")
                .addStation(new Station("21"))
                .addStation(new Station("s2"))
                .addStation(new Station("s3"))
                .build();
        Trip trip = new TripBuilder()
                .addStartTime(LocalDateTime.of(2020,10,11,9,15))
                .build()
                ;
    }

}