package Mastermind;

import java.util.Scanner;

public class Skocko {
    private static final Scanner sc = new Scanner(System.in);

    private final int maxGuesses;
    private int numberOfGuesses = 0;
    private final Fields correctFields;
    private final Fields currentGuessFields;

    public Skocko(int size, int maxGuesses) {
        System.out.println("~~~Добродошли у MasterMind~~~");
        System.out.println();
        System.out.println("Имате " + maxGuesses + " покушаја да нађете комбинацију!");
        System.out.println("Дозвољени карактери: " + Fields.allowedFieldValues);
        System.out.println();

        this.maxGuesses = maxGuesses;
        correctFields = new Fields(size);
        correctFields.setRandomFields();

        currentGuessFields = new Fields(size);
    }

    public void setCorrectFields(){
        correctFields.setFields(sc);
    }

    public void makeAGuess(){
        numberOfGuesses++;
        currentGuessFields.setFields(sc);

        currentGuessFields.compareFields(correctFields);
    }

    public boolean isGameOver(){
        if(numberOfGuesses > maxGuesses){
            System.out.println("Изгубили сте, искористили сте све покушаје!");
            System.out.println(correctFields);
            return true;
        }
        if(currentGuessFields.equals(correctFields)){
            System.out.println("Браво, погодак из " + numberOfGuesses + " покушаја");
            return true;
        }

        return false;
    }
    /////
}

