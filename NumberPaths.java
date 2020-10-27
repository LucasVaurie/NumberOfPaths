import java.util.*;
import java.io.*;
import java.math.*;

class NumberPaths {
    public static int calculChemins(int x, int y, int rows, int cols, int[][] array) {
        int[][] cache = new int[rows+1][cols+1];
        for (int i = 0 ; i <= rows ; i++) {
            for (int j = 0 ; j <= cols ; j++)
                cache[i][j] = -1;
        }
        return calculChemins(x, y, rows, cols, array, cache);
    }

    public static int calculChemins(int x, int y, int rows, int cols, int[][] array, int[][] cache) {
        // Cas où on sort des limites du tableau
        if (x == cols || y == rows)
            return 0;
        // Cas où on rencontre une case interdite de valeur 1
        if (array[x][y] == 1)
            return 0;
        // Cas où on est arrivé à (N-1,M-1)
        if (x == cols-1 && y == rows-1)
            return 1;
        if (cache[x][y] == -1)
            cache[x][y] = calculChemins(x, y+1, rows, cols, array, cache) + calculChemins(x+1, y, rows, cols, array, cache);
        return cache[x][y];
    } 
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] tab = new int[M][N];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        System.err.println("Nb de lignes : " + M);
        System.err.println("Nb de colonnes : " + N);
        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();
            for (int j = 0 ; j < N ; j++) {
                tab[i][j] = (int)(ROW.charAt(j)-'0');
                //System.err.println(tab[i][j]);
            }
            //System.err.println(ROW);
        }

        //System.out.println("answer");
        System.out.println(calculChemins(0, 0, M, N, tab));
    }
}