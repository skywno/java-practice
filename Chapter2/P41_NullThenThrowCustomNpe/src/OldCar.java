import java.awt.*;

public class OldCar {
    private final String name;
    private final Color color;

    public OldCar(String name, Color color) throws NullPointerException{
        if (name == null) throw new NullPointerException("Car name cannot be null");
        if (color == null) throw new NullPointerException("Car name cannot be null");

        this.name = name;
        this.color = color;
    }

    public void assignDriver(String transport, Point location) {
        if (transport == null) throw new NullPointerException("transport cannot be null");
        if (location == null) throw new NullPointerException("location cannot be null");

    }
}
