public class Orientation {
    private int degree;
    public Orientation(int inputDegree){
        degree = inputDegree;
    }

    public Orientation(String direction){
        this.setDirection(direction);
    }

    public int addDegree(int inputDegree){
        int targetDegree = degree+inputDegree;
        int result = targetDegree%360;
        if(result<0){
            degree+=360;
        }
        return degree;
    }
    public int getDegree(){
        return degree;
    }
    public void setDirection(String direction){
        switch (direction){
            case "N":
                degree = 0;
                break;
            case "E":
                degree = 90;
            case "S":
                degree = 180;
            case "W":
                degree = 270;
        }
    }
    public String getDirection(){
        String result = String.valueOf(degree);
        switch (degree){
            case 0:
                result = "N";
                break;
            case 90:
                result = "E";
            case 180:
                result = "S";
            case 270:
                result = "W";
        }
        return result;
    }

}
