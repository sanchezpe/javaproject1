package p1_pes1338;

public class P1_pes1338 {

    //Creates array of cars and assigns a symbol to each car
    public static Car[] registerCars(int numberOfCarsIn) {
        Car[] cars = new Car[numberOfCarsIn];
        for (int i = 0; i < cars.length; i++) {
//            cars[i] = new Car((char) (9398 + i));
//            cars[i] = new Car((char) (9312 + i));
            cars[i] = new Car((char) ((int) 'A' + i));
            cars[i].setPosition(0);
        }
        return cars;
    }

    public static void displayCarsPositionInRace(Car[] carsIn) {
        for (int i = 0; i < carsIn.length; i++) {
            carsIn[i].displayPosition();
        }
    }

    // Displace the cars / Change position of the cars
    public static void displaceCars(Car[] carsIn) {
        for (int j = 0; j < carsIn.length; j++) {
            carsIn[j].displaceByTwoDiceTosses();
        }
    }

    public static void cleanScreen() {
        for (int i = 0; i <= 100; i++) {
            System.out.println();
        }
    }

    public static void freezeScreen(int delayIn) {
        try {
            Thread.sleep(delayIn);
        } catch (Exception e) {
        }
    }

    public static void displayWinners(Car[] carsIn) {
        System.out.print("Winners: ");
        for (int i = 0; i < carsIn.length; i++) {
            if (distanceFirstPlace(carsIn) == carsIn[i].getPosition()) {
                System.out.print(carsIn[i].getSymbol() + "  ");
            }
        }
        System.out.println();
    }

    public static int distanceFirstPlace(Car[] carsIn) {
        int firstPlace = carsIn[0].getPosition();

        for (int i = 0; i < carsIn.length; i++) {
            if (firstPlace <= carsIn[i].getPosition()) {
                firstPlace = carsIn[i].getPosition();
            }
        }
        return firstPlace;
    }

    public static void startRacing(int lengthOfTrackIn, Car[] carsIn, int delayInMillisecondsIn) {
        cleanScreen();
        displayCarsPositionInRace(carsIn); // cars at start line
        freezeScreen(delayInMillisecondsIn);

        while (distanceFirstPlace(carsIn) <= lengthOfTrackIn) {
            cleanScreen();
            displaceCars(carsIn);
            displayCarsPositionInRace(carsIn);
            freezeScreen(delayInMillisecondsIn);
        }
    }

    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter the length of the race: ");
        int lengthOfTrack = input.nextInt();

        System.out.print("Enter the number of cars in the race: ");
        int numberOfCars = input.nextInt();
        Car[] cars = registerCars(numberOfCars);

        System.out.print("Enter delay factor (smaller is faster): ");
        int delayInMilliseconds = input.nextInt();

        startRacing(lengthOfTrack, cars, delayInMilliseconds);

        System.out.println();
        displayWinners(cars);
    }
}
