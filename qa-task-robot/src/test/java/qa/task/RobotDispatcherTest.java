package qa.task;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * Тест можно запускать для проверки.
 * НЕ МЕНЯТЬ!
 */
@TestInstance(PER_CLASS)
class RobotDispatcherTest {

    private final AtomicBoolean zeroChecked = new AtomicBoolean(false);

    @RepeatedTest(5)
    @DisplayName("Робот должен забраться на ожидаемую ступень")
    void robotShouldClimbOnExceptedStep() {

        // Создание реализации RobotDispatcherImpl
        RobotDispatcher robotDispatcher = new RobotDispatcher();

        // Создание тестового робота
        RobotImpl robot = new RobotImpl();

        // Случайная ступенька, на которую нужно забраться
        int expectedStepIndex = zeroChecked.compareAndSet(false, true)
                ? 0
                : ThreadLocalRandom.current().nextInt(0, 100);

        // Выполнить подъем
        robotDispatcher.stepUp(robot, expectedStepIndex);

        // Получить ступень, на которой оказался робот
        int actualStepIndex = robot.currentStep;

        // Проверка
        Assertions.assertEquals(
                expectedStepIndex,
                actualStepIndex,
                String.format("Робот должен подняться на ступень '%s'.\nНо твой робот находится на ступени '%s'", expectedStepIndex, actualStepIndex)
        );
    }
}