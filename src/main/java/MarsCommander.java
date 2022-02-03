import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MarsCommander {
    private Plateau plateau;
    public String execute(String command){
        ActionCommands currentCommands = new ActionCommands(command);
        if(currentCommands.isValid()){
            Point plateauSize = currentCommands.getPlateauSize();
            plateau = new Plateau(plateauSize.x,plateauSize.y);
            List<RoverCommand> roverCommands = currentCommands.getRoverCommands();
            List<String> result = new ArrayList<>();

            roverCommands.forEach((roverCommand) -> {
                Rover tmpRover = new Rover();
                String moveResult = tmpRover.execute(roverCommand,this.plateau);
                result.add(moveResult);
            });
            return String.join("\n", result);
        }else{
            return "Not a Valid command!!!";
        }
    }
}
