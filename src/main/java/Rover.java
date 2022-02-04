import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

public class Rover implements BlockItem{
    private final UUID uuid = UUID.randomUUID();
    private Position position;
    private Orientation orientation;
    final double moveDistant = 1;

    public String execute(RoverCommand command, Plateau plateau){
        this.orientation = new Orientation(command.getOrientation().getDegree());
        this.position = new Position(command.getPosition().x, command.getPosition().y);
        String[] movements = command.getMovement().split("");
        for (String singleCommand : movements) {
            switch (singleCommand) {
                case "L":
                    orientation.addDegree(-90);
                    break;
                case "R":
                    orientation.addDegree(90);
                    break;
                case "M":
                    int tmpDegree = orientation.getDegree();
//                    double tmpRadions = degToRadians(tmpDegree);
                    double tmpRadions = Math.toRadians(tmpDegree);
                    double xForce = Math.sin(tmpRadions);
                    double yForce = Math.cos(tmpRadions);
                    Position newPosition = plateau.checkMovementAvailable(this.position, xForce, yForce);
                    if (newPosition == null) {
//                        System.out.println("Rover "+uuid+" Movement blocked by object or hitted the Edge");
                        return "Rover " + uuid + " Movement blocked by object or hitted the Edge";
                    } else {
                        this.position = newPosition;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + singleCommand);
            }

        }
        String[] resultArray = { String.valueOf(Math.round(this.position.x)), String.valueOf(Math.round(this.position.y)), this.getOrientation().getDirection() };
        return String.join(" ", resultArray);
    }

    @Override
    public UUID getUUId() {
        return uuid;
    }

    public Position getPosition(){
        return position;
    }

    public Orientation getOrientation(){
        return orientation;
    }

}
