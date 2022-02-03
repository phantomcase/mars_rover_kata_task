import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

public class Rover implements BlockItem{
    private UUID uuid = UUID.randomUUID();
    private Position position;
    private Orientation orientation;
    final double moveDistant = 1;

    public String execute(RoverCommand command, Plateau plateau){
        this.orientation = new Orientation(command.getOrientation().getDegree());
        this.position = new Position(command.getPosition().x, command.getPosition().y);
        String movements[] = command.getMovement().split("");
        for(int i = 0; i < movements.length; i++){
            String singleCommand = movements[i];
            switch (singleCommand){
                case "L":
                    this.orientation.addDegree(-90);
                    break;
                case "R":
                    this.orientation.addDegree(90);
                    break;
                case "M":
                    Double xForce = Math.asin(Math.toRadians(this.orientation.getDegree()))*moveDistant;
                    Double yForce = Math.acos(Math.toRadians(this.orientation.getDegree()))*moveDistant;
                    Position newPosition = plateau.checkMovementAvailable(this.position, xForce, yForce);
                    if(newPosition == null){
//                        System.out.println("Rover "+uuid+" Movement blocked by object or hitted the Edge");
                        return "Rover "+uuid+" Movement blocked by object or hitted the Edge";
                    }else{
                        this.position = newPosition;
                    }
                    break;
            }
            String[] resultArray = { String.valueOf((int)this.position.x), String.valueOf((int)this.position.y), this.getOrientation().getDirection() };
            return String.join(" ", resultArray);
        }

        return "";
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