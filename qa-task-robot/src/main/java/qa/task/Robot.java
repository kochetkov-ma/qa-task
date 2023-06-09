package qa.task;

/**
 * Робот, у которого доступно 3 действия.
 * НЕ МЕНЯТЬ!
 */
public interface Robot {

    /**
     * Очистить робота, чтобы он мог продолжить забираться вверх.
     */
    void clean();

    /**
     * Зарядить робота на один заряд.
     */
    void charge();

    /**
     * Попробовать подняться на ступень.
     *
     * @return true - если удалось подняться / false - если робот упал на одну ступень вниз.
     */
    boolean step();
}
