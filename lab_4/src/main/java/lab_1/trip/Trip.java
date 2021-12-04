package lab_1.trip;

import lab_1.route.Route;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Trip  {
    @NotNull
    private Route route;
    @NotNull
    private LocalDateTime start;
    @NotNull
    private LocalDateTime end;



    public Route getRoute() {
        return route;
    }

    protected void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getStartTime() {
        return start;
    }

    protected void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEndTime() {
        return end;
    }

    protected void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(route, trip.route) && Objects.equals(start, trip.start) && Objects.equals(end, trip.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, start, end);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "route=" + route +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
