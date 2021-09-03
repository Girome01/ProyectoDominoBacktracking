package proyectodomino;


import java.io.IOException;
import proyectodomino.gui.Tablero;

public class ProyectoDomino {

    
    public static void main(String[] args) throws IOException {
        
        //Tablero tablero = new Tablero();
        //tablero.setVisible(true);
        int [][] matriz = null;
        int [] solucion = null;
        BruteForce.exec(matriz, solucion, 3);
        /*
        int [][] matriz = FileManager.getMatriz(3);
        for(int [] fila : matriz){
            for(int n : fila){
                System.out.print(n+"\t");
            }
            System.out.println("");
        }*/
        
        //prueba matriz de tiles para revisar
        /*
        int matriz[][] = DominoFunctions.generateTiles(3);
        for(int[] fila : matriz){
            for(int columna : fila){
                System.out.print(columna+"\t");
            }
            System.out.println("");
        }*/
        
                
    }
    
}
