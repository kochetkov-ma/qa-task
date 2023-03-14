package qa.task;

import java.util.Random;

/**
 * Реализация робота для проведения теста.
 * НЕ МЕНЯТЬ!
 */
public class RobotImpl implements Robot {

    private final Random random = new Random();
    int currentStep = 0;
    int stepTry = 0;
    int cleanTry = 0;
    int chargeTry = 0;
    private int power = 10;
    private int failChain = 0;

    @Override
    public void clean() {
        cleanTry++;
        if (failChain < 2)
            throw new IllegalStateException("Робот чистый и не нуждается в чистке. Он выскользнул у нас из рук и сломался. Придется начинать сначала");

        failChain = 0;
    }

    @Override
    public void charge() {
        chargeTry++;
        power++;
        if (power > 10)
            throw new IllegalStateException("Робот взорвался от перенапряжения");
    }

    @Override
    public boolean step() {
        stepTry++;
        if (power <= 0)
            throw new IllegalStateException("Робот разрядился и уже не зарядить. Придется начинать сначала");

        if (failChain >= 2)
            throw new IllegalStateException("Робот загрязнился и уже не очистить. Придется начинать сначала");

        power--;
        if (random.nextInt(3) != 1) {
            failChain = 0;
            currentStep++;
            return true;
        } else {
            failChain++;
            if (currentStep > 0) currentStep--;
            return false;
        }
    }
}
