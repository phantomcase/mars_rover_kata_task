import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int width = 0;
    private int height = 0;
    private List<BlockItem> blockItems = new ArrayList<>();
    public Plateau(int width, int height){
        this.width=width;
        this.height=height;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void addBlockItem(BlockItem item){
        blockItems.add(item);
    }

    public Position checkMovementAvailable(Position position, double xMove, double yMove){
        Position newPosition = new Position(position.x+xMove, position.y+yMove);
        final boolean[] isAvailable = {true};
        blockItems.forEach((item) -> {
            Position itemPosition = item.getPosition();
            isAvailable[0] = isAvailable[0] && !(itemPosition.x== newPosition.x && itemPosition.y==newPosition.y);
        });
        isAvailable[0] = isAvailable[0] && newPosition.x<this.width+1;
        isAvailable[0] = isAvailable[0] && newPosition.y<this.height+1;
        if(isAvailable[0]){
            return newPosition;
        }else{
            return null;
        }
    }
}
