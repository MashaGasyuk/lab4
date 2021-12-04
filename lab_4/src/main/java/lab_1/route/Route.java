package lab_1.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lab_1.Station;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Клас у якому описується маршрут для якогось транспорту.
 * Клас є набором точок між якими ходить транспорт
 */

public class Route {
    @Size(min = 4, message = "ID must be more than 3 character")
    @Pattern(regexp = "[a-z]+[1-9]+|[a-z]+[1-9][0-9]")
    @NotNull
    private String code;

    @Size(min = 2)
    @NotNull
    private List<Station> stationsR = new ArrayList<>();

    public Route(){
        //stations = new ArrayList<>();
    }

    public static class Builder {
        private Route route;

        public Builder() {
            route = new Route();
        }
        public Builder addCode(String code){
            route.setCode(code);
            return this;
        }
        public Builder addStation(Station station){
            route.addStation(station);

            return this;
        }
        public Builder setStations(ArrayList<Station> stations){
            route.setStationsR(stations);

            return this;
        }
        public Route build(){
            validate(route);
            return route;
        }

    }
    private static void validate(Route route) throws IllegalArgumentException{
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Route>> check = validator.validate(route);
        StringBuilder builder = new StringBuilder();
        for(ConstraintViolation<Route> i: check){
            builder.append("Error ").append(i.getInvalidValue()).append(" Because ").append(i.getMessage()).append("\n");
        }
        if(builder.length() > 0){
            throw new IllegalArgumentException(builder.toString());
        }
    }
    public String getCode() {
        return code;
    }

    public List<Station> getStationsR() {
        return stationsR;
    }

    /**
     * З цієї станції траспорт починає рухатись. Початок Маршруту
     * @return
     */
    public Station getStartStation() {
        return stationsR.get(0);
    }

    public int getStationsCount(){
        return stationsR.size();
    }
    /**
     *Тут траспорт закінчує рухатись. Кінець маршруту
     * @return
     */
    public Station getEndStation() {
        return stationsR.get(stationsR.size()-1);
    }

    protected void setCode(String code) {
        this.code = code;
    }

    /**
     * Присвоює маршруту переданний список станцій
     * @param stationsR
     */
    protected void setStationsR(List<Station> stationsR) {
        this.stationsR = stationsR;
    }

    /**
     * Додає станцію до маршруту
     * @param station
     */
    protected void addStation(Station station){
        this.stationsR.add(station);
    }

    /**
     * Видаляє станцію з маршруту
     * @param station
     */
    protected void removeStation(Station station){
        this.stationsR.remove(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(code, route.code) && Objects.equals(stationsR, route.stationsR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, stationsR);
    }

    @Override
    public String toString() {
        return "Route{" +
                "code='" + code + '\'' +
                ", stations=" + stationsR +
                '}';
    }


}
