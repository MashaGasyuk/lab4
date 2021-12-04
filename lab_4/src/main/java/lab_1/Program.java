package lab_1;

import lab_1.route.Route;

public class Program {
    public static void main(String[] args) {
        test();
        negtest();
        negtest1();
        negtest2();
    }
    public static void test(){
        Station station = new Station("a");
        Station station1 = new Station("b");
        Station station2 = new Station("c");

        Route route = new Route.Builder().addCode("aaa1").addStation(station).addStation(station1).addStation(station2).build();
    }
    public static void negtest(){
        try {
            Route route = new Route.Builder().build();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public static void negtest1(){
        try{
        Route route = new Route.Builder().addCode("aaa").build();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public static void negtest2(){
        Station station = new Station("a");
        Station station1 = new Station("b");
        Station station2 = new Station("c");
        try{
        Route route = new Route.Builder().addStation(station).addStation(station1).addStation(station2).build();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
