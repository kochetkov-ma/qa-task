package qa.task;

/**
 * Реализовать в RobotDispatcherImpl.
 * НЕ МЕНЯТЬ!
 */
public interface RobotDispatcher {

    /**
     * Необходимо передвинуть робот [Robot robot] до указанной ступени [int stepIndex].
     *
     * @param robot     Robot который будем двигать, заряжать и очищать, чтобы он добрался до нужной ступени.
     * @param stepIndex Индекс ступени до которой необходимо добраться.
     * @see Robot
     */
    void stepUp(Robot robot, int stepIndex);
}
