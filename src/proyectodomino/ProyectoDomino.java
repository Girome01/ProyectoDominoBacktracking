package proyectodomino;


import java.io.IOException;
import proyectodomino.gui.Tablero;

public class ProyectoDomino {

    
    public static void main(String[] args) throws IOException {
        
        Tablero tablero = new Tablero();
        tablero.setVisible(true);
        
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
        
        //prueba generacion de matriz desde python
        /*
        int n = 3;
        int [][] matriz = ScriptPython.runScript(n);
        if (matriz == null){
            return;
        }
        for(int[] fila : matriz){
            for(int columna : fila){
                System.out.print(columna+"\t");
            }
            System.out.println("");
        }*/
        
    }
    
}
