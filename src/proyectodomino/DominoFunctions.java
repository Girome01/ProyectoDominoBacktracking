package proyectodomino;


public class DominoFunctions {
    public static int[][] generateTiles(int n){
        int matriz[][] = new int[n+1][n+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = i; j <= n; j++){
                matriz[i][j] = 1;
            }
        }
        return matriz;
    }
    
       
}
