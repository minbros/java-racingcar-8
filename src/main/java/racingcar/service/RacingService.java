package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingService {
    private final Cars cars;

    public RacingService(Cars cars) {
        this.cars = cars;
    }

    public void playGame(int count) {
    }

    public void addCar(Car car) {

    }

    public List<Car> getCars() {
        return List.of();
    }

    public List<Car> getWinningCars() {
        return List.of();
    }
}
