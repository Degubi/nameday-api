package namedayapi;

/**
 * Enum with suppored Temporal constants
 * @author Degubi
 */
public enum Temporal {

    TODAY("/today"),
    TOMORROW("/tomorrow"),
    YESTERDAY("yesterday");

    final String endPoint;

    Temporal(String endPoint) {
        this.endPoint = endPoint;
    }
}