package p1_pes1338;

public class Car {

    private char symbol = 'X';                  //private symbol data field
    private int position = 0;                   //private position data field

    public Car() {                              //default constructor
    }

    public Car(char symbolIn) {                 //parametized constructor
        this.symbol = symbolIn;

    }

    public void setPosition(int positionIn) {
        this.position = positionIn;
    }

    public int getPosition() {
        return this.position;
    }

    public void setSymbol(char symbolIn) {
        this.symbol = symbolIn;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void displayPosition() {             //display progress along track
        for (int i = 0; i <= this.position; i++) {
            if (this.position != 0) {
                System.out.print(".");
            }
        }
        System.out.println(this.symbol);

    }

    public int tossOneDice() {                  //toss one dice
        return (int) (Math.random() * 6 + 1);
    }

    public void displaceByTwoDiceTosses() {     // change position by two dice tosses
        int totalDisplacement = tossOneDice() + tossOneDice();
        this.position += totalDisplacement;
    }

}
