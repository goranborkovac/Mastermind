package Mastermind;

public class Aplication {
    public static void main(String[] args) {
        var game = new Skocko(5, 2);

        while (!game.isGameOver()) {
            game.makeAGuess();
        }

        // Git Hub upload

    }
}
