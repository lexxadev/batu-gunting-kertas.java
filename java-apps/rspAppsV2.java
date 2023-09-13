import java.util.Random;
import java.util.Scanner;

public class rspAppsV2 {
    // utility
    public static java.util.Scanner scanner = new Scanner(System.in);
    public static java.util.Random random = new Random();

    // code start
    public static void main(String[] args) {
        showMenu();
    }

    // Function user input
    public static String userInput(String getInput) {
        System.out.print(getInput + " : ");

        String isInput = scanner.nextLine();
        return isInput;
    }

    // Menu
    public static void showMenu() {
        while (true) {
            System.out.println("<==== WELCOME! ====>");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");

            var userInput = userInput("Select");
            if (userInput.equals("1")) {
                gameStart();
            } else if (userInput.equals("2")) {
                System.out.println("Thanks for playing :)");
                break;
            } else {
                System.out.println("Select a number between 1 or 2");
            }
        }
    }

    public static int userHighscore(int getScore) {
        int result = getScore;
        result = 0;

        return result;
    }

    // Ketika user memulai game
    public static void gameStart() {
        System.out.println("Welcome to Rock Scissors Paper game!");
        // Logic ketika player meng-input Pilihan
        int playerScore = 0;
        while (true) {
            userHighscore(0); // Set ulang skor player
            // Pilihan yang harus di-input oleh player
            System.out.println("Option : scissors - rock - paper!");

            var getPlayerOption = userInput("Choose your option");
            if (!(getPlayerOption.equals("scissors") || getPlayerOption.equals("rock") || getPlayerOption.equals("paper"))) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            // Logic computer
            int randNumber = random.nextInt(3);
            String isComputer = null;

            switch (randNumber) {
                case 0:
                    isComputer = "scissors";
                    break;
                case 1:
                    isComputer = "rock";
                    break;
                case 2:
                    isComputer = "paper";
                    break;
            }

            System.out.println("Computer Option : " + isComputer);

            if (getPlayerOption.equals(isComputer)) {
                System.out.println("Result : Draw!!");
            } else if ((getPlayerOption.equals("scissors") && isComputer.equals("paper"))
                    || (getPlayerOption.equals("rock") && isComputer.equals("scissors"))
                    || (getPlayerOption.equals("paper") && isComputer.equals("rock"))) {
                System.out.println("Result : Win!!!");
                playerScore += 10;
            } else {
                System.out.println("Result : Lose!!");
                playerScore -= 5;
            }
            System.out.println("Your score : " + playerScore);

            System.out.println("Would you restart the game? (y/n) : ");

            String userAnswer = userInput("Answer");
            if (!userAnswer.equals("y")) {
                break;
            }
        }

        System.out.println("Thanks for playing :)");
        scanner.close();
    }
}
