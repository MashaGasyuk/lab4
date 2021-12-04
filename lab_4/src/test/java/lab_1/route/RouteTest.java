package lab_1.route;

import lab_1.Station;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RouteTest {
    @Test(dataProvider = "simpleProvider")
    public void test(String code, String station, String station1, String station2){
        Route route = new Route.Builder()
                .addCode(code)
                .addStation(new Station(station))
                .addStation(new Station(station1))
                .addStation(new Station(station2)).build();
        assertEquals(route.getCode(),code);
    }
    @DataProvider
    public Object[][] simpleProvider(){
        return new Object[][]{
                {"aaa1","a","b","c"}
        };
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest(){
        Route route = new Route.Builder().build();

    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest1(){
        Route route = new Route.Builder().addCode("aaa").build();
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negtest2(){
        Station station = new Station("a");
        Station station1 = new Station("b");
        Station station2 = new Station("c");
        Route route = new Route.Builder().addStation(station).addStation(station1).addStation(station2).build();
    }

}