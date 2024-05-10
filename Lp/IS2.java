import java.util.*;

class IS2 {

    public static void main(String[] args) {
        String plainText, cipherText;
        plainText = "LaboratoryPracticeII";
        int k = 0;
        char encr[][] = new char[4][5];
        char decr[][] = new char[4][5];

        for(int i = 0; i < encr.length; i++) {

            for(int j = 0; j < encr[0].length; j++) {
                encr[i][j] = plainText.charAt(k++);
            }
        }
        cipherText = "";
        for(int i = 0; i < encr[0].length; i++) {

            for(int j = 0; j < encr.length; j++) {
                cipherText += encr[j][i];
            }
        }
        System.out.println("CipherText : "+ cipherText);
        k = 0;
        for(int i = 0; i < decr[0].length; i++) {
            for(int j = 0; j < decr.length; j++) {
                decr[j][i] = cipherText.charAt(k++);
            }
        }
        System.out.print("Decrypted Text : ");
        for(int i = 0; i < decr.length; i++) {
            for(int j = 0; j < decr[0].length; j++) {
                System.out.print(decr[i][j]);
            }
        }
    }
}