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
    
    /*
    Recibe la cantidad de piezas del set
    */
    public static int[][] generateSolutions(int n){
        int cantidad = (int) Math.pow(2, n) + 1;
        int largo = ((n+1)*(n+2))/2;
        int soluciones[][] = new int[cantidad][largo]; //cada fila tiene una posible solución
        
        //
        
        return soluciones;
    }
    
}
