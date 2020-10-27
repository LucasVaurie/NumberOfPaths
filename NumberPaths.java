import java.util.*;
import java.io.*;
import java.math.*;

class NumberPaths {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();
            System.err.println(ROW);
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("answer");
    }
}