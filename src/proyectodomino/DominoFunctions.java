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
                current[i][j] = old[i][j];
            }
        }
        return current;
    }
    
    public static int[] copyArray(int [] old){
        int [] current = new int [old.length];
        for(int i = 0; i < old.length; i++){
            current[i] = old[i];
        }
        return current;
    }
    
    public static void printMatriz(int [][] matriz){
        for (int[] fila : matriz) {
            for (int n : fila) {
                System.out.print(n + "\t");
            }
            System.out.println("");
        }
    }
    
    public static boolean comprobarFicha(int f1, int f2, int [][] fichas){
        switch (fichas[f1][f2]) {
            case -1:
                //System.out.println("la ficha se repite: ");
                return false;
            case 0:
                if(fichas[f2][f1] == -1){
                    //System.out.println("se repite una ficha: ");
                    return false;
                }
                else{
                    fichas[f2][f1] = -1;
                    return true;
                }   
            case 1:
                fichas[f1][f2] = -1;
                return true;
        }
        return false;
    }
       
}
