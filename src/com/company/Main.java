package com.company;

import java.util.Scanner;

public class Main {
    final char[] alphabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};
    Scanner sc = new Scanner(System.in);

    public char convertNumberToLetter(int position) {
        char letter = alphabet[position];
        return letter;
    }

    public int convertLetterToNumber(char letter) {
        int position = 0;
        for (int x = 0; x < alphabet.length; x++) {
            if (letter == alphabet[x]){
                position = x;
            }
        }return position;
    }

    public int[] textToNumberShiftArray(String text, int shiftValue) {
        char[] textCharAnte = text.toCharArray();
        int [] numberArray = new int[textCharAnte.length];
        for (int x = 0; x < textCharAnte.length; x++){
            int shiftedNumber = convertLetterToNumber(textCharAnte[x]);
            if (shiftedNumber != 0){   //0 being " " in the alphabet array as we do not want to shift that in our encrypted code
                shiftedNumber += shiftValue;
                if (shiftedNumber > (alphabet.length - 1)){//
                    shiftedNumber -= (alphabet.length - 1);
                }
            }
            numberArray[x] = shiftedNumber;
        }return numberArray;
    }

    public String cipherEncryption (String text, int shiftValue){
        String encryptedText = "";
        int length = textToNumberShiftArray(text, shiftValue).length;
        int [] encryptedNumbers = textToNumberShiftArray(text, shiftValue);
        for(int x = 0; x < length; x++){
            int position = encryptedNumbers[x];
            encryptedText += "" + convertNumberToLetter(position);

        }return encryptedText;
    }

    public static void main(String[] args) {
        Main prg = new Main();

        System.out.println(prg.cipherEncryption("THIS IS A TEST TO TEST THIS TEST", 10));

    }
}
