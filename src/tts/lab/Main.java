package tts.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // print the valid characters for input.
        System.out.println();
        System.out.println("The valid characters for input:");
        AsciiChars.printNumbers();
        AsciiChars.printUpperCaseLetters();
        AsciiChars.printLowerCaseLetters();
        System.out.println();
        //
        do {
            System.out.println();
            System.out.print("Please enter your name: ");
            String nameUser = scanner.next();
            nameUser += scanner.nextLine();
            System.out.println("Hello " + nameUser + "!");
            //
            System.out.println();
            System.out.print("Would you wish to continue to the interactive portion? (y|n): ");
            String askYesNo = scanner.next();
            if (!askYesNo.equals("y")) {
                break;
            }
            //
            System.out.println();
            System.out.print("What is the name of your favorite pet?: ");
            String namePet = scanner.next();
            namePet += scanner.nextLine();
            //
            System.out.println();
            System.out.print("What is the age of your favorite pet?: ");
            int agePet = scanner.nextInt();
            //
            System.out.println();
            System.out.print("What is your lucky number?: ");
            int luckyNumber = scanner.nextInt();
            //
            System.out.println();
            System.out.print("Do you have a favorite quarterback? (y|n): ");
            String askYesNoFavoriteQuarterback = scanner.next();
            if (askYesNoFavoriteQuarterback.equals("y")) {
                System.out.println();
                System.out.print("What is his jersey number?: ");
                int jerseyNumber = scanner.nextInt();
            }
            //
            System.out.println();
            System.out.print("What is two-digit model year of your car?: ");
            String twoDigitModelYearCar = scanner.next();
            twoDigitModelYearCar += scanner.nextLine();
            //
            System.out.println();
            System.out.print("What is the first name of the their favorite actor or actress?: ");
            String nameActorOrActress = scanner.next();
            nameActorOrActress += scanner.nextLine();
            //
            int randomNumber = 1;
            do {
                System.out.println();
                System.out.print("Enter a random number between 1 and 50: ");
                randomNumber = scanner.nextInt();
            } while (randomNumber < 1 || 50 < randomNumber);
            //
            // Constants
            final int MAX_MAGIC_BALL_NUMBER = 75;
            final int MAX_LOTTERY_NUMBER = 65;
            // Randoms
            int randomMagicBall = (int) (Math.random() * MAX_MAGIC_BALL_NUMBER);
            int randomOne = (int) (Math.random() * MAX_LOTTERY_NUMBER);
            int randomTwo = (int) (Math.random() * MAX_LOTTERY_NUMBER);
            int randomThree = (int) (Math.random() * MAX_LOTTERY_NUMBER);
            // Generate "magic ball".
            int magicBall = luckyNumber * randomMagicBall;
            if (MAX_MAGIC_BALL_NUMBER <= magicBall) {
                magicBall -= MAX_MAGIC_BALL_NUMBER;
            }
            if (MAX_MAGIC_BALL_NUMBER <= magicBall) {
                magicBall = MAX_MAGIC_BALL_NUMBER - randomThree;
            }
            // Generate the "Lottery numbers"
            int[] lotteryNumbers = new int[5];
            // 1- Convert the first letter of their favorite actor/actress to an integer and use that value.
            lotteryNumbers[0] = (int) nameActorOrActress.charAt(0);
            if (100 <= lotteryNumbers[0]) {
                lotteryNumbers[0] -= 100;
            } else if (66 <= lotteryNumbers[0]) {
                lotteryNumbers[0] -= 65;
            }
            // 2- Convert the last letter of their favorite actor/actress to an integer and use that value.
            lotteryNumbers[1] = (int) nameActorOrActress.charAt(nameActorOrActress.length() - 1);
            if (100 <= lotteryNumbers[1]) {
                lotteryNumbers[1] -= 100;
            } else if (66 <= lotteryNumbers[1]) {
                lotteryNumbers[1] -= 65;
            }
            // 3- Find the 3rd letter of their favorite pet. Convert that character value to an integer value.
            lotteryNumbers[2] = (namePet.length() >= 3) ? (int) namePet.charAt(2) : (int) namePet.charAt(0);
            if (100 <= lotteryNumbers[2]) {
                lotteryNumbers[2] -= 100;
            } else if (66 <= lotteryNumbers[2]) {
                lotteryNumbers[1] -= 65;
            }
            // 4- Use the age of their favorite pet + their lucky number.
            lotteryNumbers[3] = agePet + luckyNumber;
            if (65 < lotteryNumbers[3]) {
                lotteryNumbers[3] -= randomOne;
            }
            // 5- Use the random number between 1 and 50, subtracting one of the generated random numbers.
            lotteryNumbers[4] = randomNumber - randomTwo;
            if (lotteryNumbers[4] <= 1) {
                lotteryNumbers[4] += randomTwo;
            }
            //
            // Remove duplicate numbers
            while (true) {
                if (lotteryNumbers[0] == lotteryNumbers[1]) {
                    int randomNumberTmp = (int) (Math.random() * 10);
                    if (lotteryNumbers[1] + randomNumberTmp <= MAX_LOTTERY_NUMBER) {
                        lotteryNumbers[1] += randomNumberTmp;
                    } else {
                        lotteryNumbers[1] -= randomNumberTmp;
                    }
                } else {
                    break;
                }
            }
            while (true) {
                if (lotteryNumbers[0] == lotteryNumbers[2] || lotteryNumbers[1] == lotteryNumbers[2]) {
                    int randomNumberTmp = (int) (Math.random() * 10);
                    if (lotteryNumbers[2] + randomNumberTmp <= MAX_LOTTERY_NUMBER) {
                        lotteryNumbers[2] += randomNumberTmp;
                    } else {
                        lotteryNumbers[2] -= randomNumberTmp;
                    }
                } else {
                    break;
                }
            }
            while (true) {
                if (lotteryNumbers[0] == lotteryNumbers[3] || lotteryNumbers[1] == lotteryNumbers[3] || lotteryNumbers[2] == lotteryNumbers[3]) {
                    int randomNumberTmp = (int) (Math.random() * 10);
                    if (lotteryNumbers[3] + randomNumberTmp <= MAX_LOTTERY_NUMBER) {
                        lotteryNumbers[3] += randomNumberTmp;
                    } else {
                        lotteryNumbers[3] -= randomNumberTmp;
                    }
                } else {
                    break;
                }
            }
            while (true) {
                if (lotteryNumbers[0] == lotteryNumbers[4] || lotteryNumbers[1] == lotteryNumbers[4] || lotteryNumbers[2] == lotteryNumbers[4] || lotteryNumbers[3] == lotteryNumbers[4]) {
                    int randomNumberTmp = (int) (Math.random() * 10);
                    if (lotteryNumbers[4] + randomNumberTmp <= MAX_LOTTERY_NUMBER) {
                        lotteryNumbers[4] += randomNumberTmp;
                    } else {
                        lotteryNumbers[4] -= randomNumberTmp;
                    }
                } else {
                    break;
                }
            }
            // Sort.
            Arrays.sort(lotteryNumbers);
            System.out.println();
            System.out.print("Lottery numbers: ");
            for (int x = 0; x < lotteryNumbers.length; x++) {
                System.out.print(lotteryNumbers[x]);
                if (x < lotteryNumbers.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("  Magic ball: " + magicBall);
            //
            System.out.println();
            System.out.println();
            System.out.print("Play again? (y|n): ");
            String askYesNoForPlay = scanner.next();
            if (!askYesNoForPlay.equals("y")) {
                break;
            }
            //
        } while (true);
        //
        scanner.close();
    }
}
