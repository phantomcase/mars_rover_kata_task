import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoverCommand implements IfRoverCommand{
    private boolean valid = true;
    private Point position;
    private Orientation orientation;
    private String movement;
    public RoverCommand(String positionCommand, String movementCommand){
        Pattern positionPat = Pattern.compile("^(\\d+) (\\d+) ([NEWS])$");
        Matcher positionMatcher = positionPat.matcher(positionCommand);
        boolean positionValid = positionMatcher.matches();
        if(positionValid){
            position = new Point(Integer.parseInt(positionMatcher.group(1)),Integer.parseInt(positionMatcher.group(2)));
            orientation = new Orientation(positionMatcher.group(3));
        }
        valid= valid && positionValid;
        Pattern movementPat = Pattern.compile("^[LRM]+$");
        Matcher movementMatcher = movementPat.matcher(movementCommand);
        boolean movementVaild = movementMatcher.matches();
        if(movementVaild){
            movement = movementCommand;
        }
        valid= valid && movementVaild;
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String getMovement() {
        return movement;
    }
}
