package racingcar;

import racingcar.dto.Distance;
import racingcar.dto.Name;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int STOP_LOWER_BOUNDARY = 0;
    public static final int RUN_LOWER_BOUNDARY = 4;
    public static final int RUN_UPPER_BOUNDARY = 10;

    public static final int START_POINT = 0;

    private final Name name;
    private Distance distance;

    public Car() {
        this.name = new Name("");
        this.distance = new Distance(START_POINT);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance(START_POINT);
    }

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void initialize() {
        this.distance = new Distance(START_POINT);
    }

    public int runOrStop(int number) {
        if (number < STOP_LOWER_BOUNDARY || number > RUN_UPPER_BOUNDARY) {
            throw new IllegalArgumentException("Random Number should be between 0 to 10.");
        }

        if (number >= RUN_LOWER_BOUNDARY) {
            distance.increment();
        }

        return distance.getDistance();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public int compareTo(Car car) {
        return this.distance.compareTo(car.distance);
    }
}
