class NumberPaths {
    /**
    * Initialise un tableau 'cache' à double entrée et
    * appelle la fonction surchargée du même nom
    *
    * @param x
    *     Ligne (row) de départ de l'analyse, en int
    * @param y
    *     Colonne (col) de départ de l'analyse, en int
    * @param rows
    *     Nombre de lignes du tableau, en int
    * @param cols
    *     Nombre de colonnes du tableau, en int
    * @param array
    *     Tableau double entrée représentant la carte (valeurs 0 ou 1), en int
    * @return Le nombre de chemins possibles entre deux points (via appel de la fonction surchargée)
    */
    public static int calculChemins(int x, int y, int rows, int cols, int[][] array) {
        int[][] cache = new int[rows+1][cols+1];
        // initialisation du cache
        for (int i = 0 ; i <= rows ; i++) {
            for (int j = 0 ; j <= cols ; j++)
                cache[i][j] = -1;
        }
        return calculChemins(x, y, rows, cols, array, cache);
    }
    /**
    * Calcule le nombre de chemins entre deux points, le départ (x, y) et l'arrivée (rows-1, cols-1)
    * appelle la fonction surchargée du même nom
    *
    * @param cache
    *     Tableau double entrée représentant le cache, avec valeurs déjà calculées ou non
    * @return Le nombre de chemins possibles entre deux points (via appel de la fonction surchargée)
    */
    public static int calculChemins(int x, int y, int rows, int cols, int[][] array, int[][] cache) {
        // Cas où on sort des limites du tableau OU Cas où on rencontre une case interdite de valeur 1
        if ((x == cols || y == rows) || (array[x][y] == 1))
            return 0;
        // Cas où on est arrivé à (N-1,M-1)
        if (x == cols-1 && y == rows-1)
            return 1;
        // Cas où donnée déjà dans le cache
        if (cache[x][y] == -1)
            cache[x][y] = calculChemins(x, y+1, rows, cols, array, cache) + calculChemins(x+1, y, rows, cols, array, cache);
        return cache[x][y];
    } 

    /**
    * Fonction principale main du programme
    */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] tab = new int[M][N];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();
            for (int j = 0 ; j < N ; j++) {
                tab[i][j] = (int)(ROW.charAt(j)-'0');
            }
        }
        System.out.println(calculChemins(0, 0, M, N, tab));
        in.close();
    }
}
