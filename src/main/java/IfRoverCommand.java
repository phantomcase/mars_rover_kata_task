import java.awt.*;

public interface IfRoverCommand {
    public boolean isValid();
    public Point getPosition();
    public Orientation getOrientation();
    public String getMovement();
}
