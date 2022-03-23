import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionCommands {
    private boolean valid = true;
    private Point plateauSize;
    final List<RoverCommand> roverCommands = new ArrayList<>();
    public ActionCommands(String command) {
        String[] commands = command.split("\\r?\\n");

        String[] roverCommandAry = Arrays.copyOfRange(commands, 1, commands.length);

        String plateauCommand = commands[0];
        Pattern plateauSizePat = Pattern.compile("^(\\d+) (\\d+)$");
        Matcher plateauSizeMatcher = plateauSizePat.matcher(plateauCommand);
        boolean plateauSizeValid = plateauSizeMatcher.matches();
        valid = valid && plateauSizeValid;
        if(plateauSizeValid){
            plateauSize = new Point(Integer.parseInt(plateauSizeMatcher.group(1)), Integer.parseInt(plateauSizeMatcher.group(2)));
        }

        boolean isEvenLines = roverCommandAry.length % 2 == 0;
        valid = valid && isEvenLines;
        if(isEvenLines){
            for(int i = 0; i < roverCommandAry.length/2; i++){
                RoverCommand tempCommand = new RoverCommand(roverCommandAry[i*2],roverCommandAry[i*2+1]);
                valid = valid && tempCommand.isValid();
                if(tempCommand.isValid()) {
                    roverCommands.add(tempCommand);
                }
            }

        }
    }
    public boolean isValid(){
        return valid;
    }
    public Point getPlateauSize(){
        return plateauSize;
    }
    public List<RoverCommand> getRoverCommands(){
        return roverCommands;
    }

}
