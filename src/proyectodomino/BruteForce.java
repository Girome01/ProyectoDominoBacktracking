
package proyectodomino;

import java.util.ArrayList;



public class BruteForce {
    //static int impresiones = 0;
            
    public static ArrayList<int[]> exec(int [][] matriz, int n){   
        int largo = ((n+1)*(n+2))/2;    //cantidad de fichas
        int [] solucion = new int[largo];
        ArrayList<int[]> soluciones = new ArrayList<>();
        bruteForce_aux(matriz, solucion, largo, n, soluciones);
        return soluciones;
    }
    //hacer las validaciones en funciones para no repetir código
    
    private static void bruteForce_aux(int [][] matriz, int [] solucion, int largo, int n, ArrayList<int[]> soluciones){
        if (largo == 0){
            //a continuación, se prueba la solución
            /*
            1. se hace un ciclo que recorra cada numero de la solucion
            2. se busca el primer espacio sin -1 que haya
            3. se verifica si cabe la ficha
            4. se coloca -1 en los puestos ocupados
            5. se revisa si la ficha ya existe
            6. retorna la solucion
            */
            int [][] fichas = DominoFunctions.generateTiles(n); //matriz para revisar que no hayan fichas repetidas
            matriz = DominoFunctions.copyMatriz(matriz);
            int maxFila = matriz.length;
            int maxColumna = matriz[0].length;
            int fila = 0;
            int columna = 0;
            int f1 = -1;                 //datos de la ficha
            int f2 = -1;
            int pos = 0;
            /*
            for(int num : solucion){
                System.out.print(num);
            }
            */
            for(int [] f : matriz){
                for(int numero : f){
                     f1 = -1;                 //datos de la ficha
                     f2 = -1;
                    if(numero != -1){
                        f1 = numero;
                        matriz[fila][columna] = -1;
                        switch(solucion[pos]){  
                            case 0:
                                if(columna+1 >= maxColumna){
                                    //System.out.println("se salio de la columna: "+pos);
                                    return;
                                }
                                f2 = matriz[fila][columna+1];
                                matriz[fila][columna+1] = -1;
                                break;
                            case 1:
                                if(fila+1 >= maxFila){
                                    //System.out.println("se salio de la fila: "+pos);
                                    return;
                                }
                                f2 = matriz[fila+1][columna];
                                matriz[fila+1][columna] = -1;
                                break;
                        } 
                        if(f2 == -1){
                            //System.out.println("no calzó bien: "+pos);
                            return;
                        }
                        else{
                            if (!DominoFunctions.comprobarFicha(f1, f2, fichas)){ //revisa que la ficha no esté repetida
                                //la ficha se repite
                                return;
                            };
                        }
                        pos++;
                    }
                    columna++;
                }
                columna = 0;
                fila++;
            }
            //System.out.println("-----------------------------");
            int [] currentSolution = DominoFunctions.copyArray(solucion);
            soluciones.add(currentSolution);
        }
        else{
            solucion[largo-1] = 0;
            bruteForce_aux(matriz, solucion, largo-1, n, soluciones);
            solucion[largo-1] = 1;
            bruteForce_aux(matriz, solucion, largo-1, n, soluciones);
        }
    }
    
    
}
