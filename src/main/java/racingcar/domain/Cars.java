package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 자동차 경주에 사용되는 모든 자동차를 다루는 일급 컬렉션입니다.
 * <ul>
 *     <li>carList: 자동차를 저장하는 리스트</li>
 *     <li>names: 이름 검증을 위해 사용되는 집합</li>
 * </ul>
 * @see Car
 */
public class Cars {
    private final List<Car> carList = new ArrayList<>();
    private final Set<String> names = new HashSet<>();

    /**
     * @throws IllegalArgumentException 자동차의 이름이 중복되는 경우
     */
    public void add(Car car) {
        if (names.contains(car.getName())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
        }
        carList.add(car);
        names.add(car.getName());
    }

    public List<Car> getAll() {
        return List.copyOf(carList);
    }

    public List<Car> getWinningCars() {
        if (carList.isEmpty()) {
            return List.of();
        }
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    /**
     * 존재하는 모든 자동차를 랜덤 값에 맞게 움직입니다.
     * @param randomValues 이동을 위해 사용되는 랜덤 값
     * @throws IllegalArgumentException 랜덤 값의 개수가 자동차의 개수와 맞지 않을 경우
     */
    public void moveAll(List<Integer> randomValues) {
        if (carList.size() != randomValues.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_RANDOM_VALUES_NOT_EQUALS_NUMBER_OF_CARS.getMessage());
        }
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(randomValues.get(i));
        }
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
