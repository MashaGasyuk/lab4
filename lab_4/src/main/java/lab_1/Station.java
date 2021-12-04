package lab_1;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * Клас у якому описується базова станція, якогось транспорту
 */
public class Station implements Serializable {
    @Size(min = 4, message = "ID must be more than 3 character")
    private String name;

    public Station(){
        name = "";
    }

    public Station(String name) {
        assert (!Objects.equals(name, ""));
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
