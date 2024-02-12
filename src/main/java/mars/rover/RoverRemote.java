package mars.rover;

public class RoverRemote {
    private final Rover rover;


    public RoverRemote(Rover rover){
        this.rover = rover;

    }
    public String execute(String commands){
        for (int i=0;i<commands.length();i++){
            char command = commands.charAt(i);
            switch (command){
                case 'L':
                    rover.turnLeft();
                    break;
                case 'R':
                    rover.turnRight();
                    break;
                case 'M':
                    rover.moveForward();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported Move.");
            }
        }
        return rover.toString();
    }

}
