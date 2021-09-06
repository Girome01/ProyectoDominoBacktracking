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
    
    public static int[][] copyMatriz(int [][] old){
        int [][] current = new int [old.length][old[0].length];
        for(int i=0; i<old.length; i++){
            for(int j=0; j<old[i].length; j++){
                current[i][j]=old[i][j];
            }
        }
        return current;
    }
    
       
}
