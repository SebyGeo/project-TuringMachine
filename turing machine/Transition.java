public class Transition {
    private String stateA;
    private char readSymbol;
    private char writeSymbol;
    private char direction; // 'L' pentru stânga, 'R' pentru dreapta
    private String stateB;

    public Transition(String stateA, char readSymbol, char writeSymbol, char direction, String stateB) {
        this.stateA = stateA;
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
        this.stateB = stateB;
    }

    public String getStateA() { return stateA; }
    public char getReadSymbol() { return readSymbol; }
    public char getWriteSymbol() { return writeSymbol; }
    public char getDirection() { return direction; }
    public String getStateB() { return stateB; }
}