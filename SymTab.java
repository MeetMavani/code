import java.io.*;
import java.util.Scanner;

class SymTab {
    // Initial Setup
    public static void main(String args[]) throws Exception {
        File inputfile = new File("C:\\Users\\Patil\\Desktop\\input.txt");
        Scanner inputFile = new Scanner(inputfile);

        //Assigning values and initializing variables
        String[][] intermediate = new String[100][3];
        int linecount = -1;
        String[][] SymTab = new String[100][3];
        String[][] OpTab = new String[100][3];
        String[][] LitTab = new String[100][3];
        int LC = 0;

        // Iterating through the file
        while (inputFile.hasNextLine()) {
            linecount++;
            String line = inputFile.nextLine();
            String[] tokens = line.split("\t");

            // Symbol Table operations
            if (linecount == 0) {
                LC = Integer.parseInt(tokens[2]);
            }
            else {
                SymTab[linecount][0] = tokens[0];
            }
            SymTab[linecount][1] = Integer.toString(LC);

            // Operand Table operations
            OpTab[linecount][0] = tokens[1];

            if (tokens[1].equalsIgnoreCase("START") || tokens[1].equalsIgnoreCase("END") || tokens[1].equalsIgnoreCase("ORIGIN") || tokens[1].equalsIgnoreCase("EQU") || tokens[1].equalsIgnoreCase("LTORG")) {
                OpTab[linecount][1] = "AD";
                OpTab[linecount][2] = "R11";
            }
            else if (tokens[1].equalsIgnoreCase("DS") || tokens[1].equalsIgnoreCase("DC")) {
                OpTab[linecount][1] = "DL";
                OpTab[linecount][2] = "R7";
            }
            else {
                OpTab[linecount][1] = "IS";
                OpTab[linecount][2] = "(04, 1)";
            }

            // Literal Table operations
            if (tokens.length == 3 && tokens[2].charAt(0) == '=') {
                LitTab[linecount][0] = tokens[2];
                LitTab[linecount][1] = Integer.toString(LC);
            }

            LC++;
        }

        // Display or output Symbol Table
        for (int i = 0; i < linecount; i++) {
            if (SymTab[i][0] != "") {
                System.out.print(SymTab[i][0] + "\t" + SymTab[i][1] + "\t" + Integer.toString(1));
                System.out.println();
            }
        }
        System.out.println("----------------");

        for (int i = 0; i < linecount; i++) {
            if (OpTab[i][0] != "") {
                System.out.print(OpTab[i][0] + "\t" + OpTab[i][1] + "\t" + OpTab[i][2]);
                System.out.println();
                }
            }
        
            System.out.println("----------------");

        for (int i = 0; i < linecount; i++) {
            if (LitTab[i][0] != null) {
                System.out.print(LitTab[i][0] + "\t"+ LitTab[i][1]);
                System.out.println();
            }
        }
        System.out.println("----------------");

        inputFile.close();
    }
};