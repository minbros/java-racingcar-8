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
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars.get();
    }

    public List<Car> getWinningCars() {
        return cars.getWinningCars();
    }
}
