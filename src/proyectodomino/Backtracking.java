
package proyectodomino;

import java.util.ArrayList;


public class Backtracking {
    
    public static void printMatriz(int [][] matriz){
        for (int[] fila : matriz) {
            for (int n : fila) {
                System.out.print(n + "\t");
            }
            System.out.println("");
        }
    }

        
    public static ArrayList<int[]> exec(int [][] matriz, int n){   
        int largo = ((n+1)*(n+2))/2;    //cantidad de fichas
        int [] solucion = new int[largo];
        int [][] fichas = DominoFunctions.generateTiles(n);
        ArrayList<int[]> soluciones = new ArrayList<>();
        int [][] matriz2 = DominoFunctions.copyMatriz(matriz);
        backtracking(matriz2, solucion, fichas, 0, 0, 0, soluciones);
        return soluciones;
    }
    
    private static boolean comprobarFicha(int f1, int f2, int [][] fichas){
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
    
    private static void backtracking(int [][] matriz, int [] solucion, int [][] fichas, int pos, int columna, int fila, ArrayList<int[]> soluciones){
        if (pos >= solucion.length){
            /*System.out.println("--------------------------------------------------------------------------------------");
            for(int num : solucion){
                System.out.print(num);
            }
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------");
            
            System.out.println("-----------------------------");*/
            int [] currentSolution = DominoFunctions.copyArray(solucion);
            soluciones.add(currentSolution);
        }
        else{
            int [][] fichasO = DominoFunctions.copyMatriz(fichas);
            int [][] matrizO = DominoFunctions.copyMatriz(matriz);
            //solucion[pos] = 0;
            if(columna+1 >= matriz[0].length){
                //System.out.println("se salio de la columna: "+pos);
            }else if(matriz[fila][columna] != -1 & matriz[fila][columna+1] != -1){
                if(comprobarFicha( matriz[fila][columna], matriz[fila][columna+1], fichas) ){
                    matriz[fila][columna] = -1;
                    matriz[fila][columna+1] = -1;
                    solucion[pos] = 0;
                    backtracking(matriz, solucion, fichas, pos+1, columna+2, fila, soluciones);
                }else{
                    //System.out.println("la ficha se repite: "+pos);
                }
            }else{
                //BT_aux(matriz, solucion, fichas, pos, columna+1, fila);
                //System.out.println("no calzó bien: "+pos);
            }
            //solucion[pos] = 1;
            if(fila+1 >= matriz.length || columna >= matriz[0].length){
                //System.out.println("se salio de la fila: "+pos);
            }else if(matrizO[fila][columna] != -1 & matrizO[fila+1][columna] != -1){
                if(comprobarFicha( matrizO[fila][columna], matrizO[fila+1][columna], fichasO) ){
                    matrizO[fila][columna] = -1;
                    matrizO[fila+1][columna] = -1;
                    solucion[pos] = 1;
                    backtracking(matrizO, solucion, fichasO, pos+1, columna+1, fila, soluciones);
                }else{
                    //System.out.println("la ficha se repite: "+pos);
                }
            }else{
                //BT_aux(matrizO, solucion, fichasO, pos , columna+1, fila);
                //System.out.println("no calzó bien: "+pos);
            }if(columna < matriz[0].length && matrizO[fila][columna] == -1){
                backtracking(matrizO, solucion, fichasO, pos , columna+1, fila, soluciones);
            }
            if( (columna >= matrizO[0].length && fila+1 < matrizO.length) && pos < solucion.length){
                backtracking(matrizO, solucion, fichasO, pos, 0, fila+1, soluciones);
            }
        }
    }
}

