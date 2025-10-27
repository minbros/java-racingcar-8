package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

/**
 * 자동차 경주 게임 로직을 담당하는 클래스입니다.
 * <li>cars: 경주에 이용되는 모든 자동차 담당</li>
 *
 * @see Cars
 */
public class RacingService {
    private final Cars cars;

    public RacingService(Cars cars) {
        this.cars = cars;
    }

    /**
     * 한 회만큼 자동차 경주를 진행합니다.
     * <p>
     * 자동차 개수만큼의 랜덤 값을 생성해 자동차의 이동에 사용합니다.
     * </p>
     *
     * @see Cars#moveAll(List)
     */
    public void playOneRound() {
        cars.moveAll(generateRandomValues());
    }

    /**
     * @throws IllegalArgumentException 자동차의 이름이 중복되는 경우
     * @see Cars#add(Car)
     */
    public void addCar(String name) {
        addCar(name, 0);
    }

    public List<Car> getCars() {
        return cars.getAll();
    }

    public List<Car> getWinningCars() {
        return cars.getWinningCars();
    }

    void addCar(String name, int position) {
        cars.add(new Car(name, position));
    }

    private List<Integer> generateRandomValues() {
        return getCars().stream()
                .map(car -> Randoms.pickNumberInRange(0, 9))
                .toList();
    }
}
