
package proyectodomino;



public class BruteForce {
    
    public static void printMatriz(int [][] matriz){
        for (int[] fila : matriz) {
            for (int n : fila) {
                System.out.print(n + "\t");
            }
            System.out.println("");
        }
    }

        
    public static void exec(int [][] matriz, int [] solucion, int n){   
        int largo = ((n+1)*(n+2))/2;    //cantidad de fichas
        solucion = new int[largo];
        /*
        for(int [] f : matriz){
            for(int m : f){
                System.out.print(m);
            }
            System.out.println("");
        }
        System.out.println("");
        */
        bruteForce_aux(matriz, solucion, largo, n);
  
    }
    //hacer las validaciones en funciones para no repetir código
    
    private static void bruteForce_aux(int [][] matriz, int [] solucion, int largo, int n){
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
            
            System.out.println("++++++++++++++++++++++++++++");
            for(int num : solucion){
                System.out.print(num);
            }
            System.out.println("++++++++++++++++++++++++++++");
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
                                    System.out.println("se salio de la columna: "+pos);
                                    return;
                                }
                                f2 = matriz[fila][columna+1];
                                matriz[fila][columna+1] = -1;
                                break;
                            case 1:
                                if(fila+1 >= maxFila){
                                    System.out.println("se salio de la fila: "+pos);
                                    return;
                                }
                                f2 = matriz[fila+1][columna];
                                matriz[fila+1][columna] = -1;
                                break;
                        } 
                        if(f2 == -1){
                            System.out.println("no calzó bien: "+pos);
                            return;
                        }
                        else{
                            //revisa que la ficha no esté repetida
                            switch (fichas[f1][f2]) {
                                case -1:
                                    System.out.println("la ficha se repite: "+pos);
                                    return;
                                case 0:
                                    if(fichas[f2][f1] == -1){
                                        System.out.println("se repite una ficha: "+pos);
                                        return;
                                    }
                                    else{
                                        fichas[f2][f1] = -1;
                                    }   
                                    break;
                                case 1:
                                    fichas[f1][f2] = -1;
                                    break;
                            }
                        }
                        pos++;
                    }
                    columna++;
                }
                columna = 0;
                fila++;
            }
            //si llega hasta aqui es porque si es una solución, entonces la devuelve
            System.out.println("-----------------------------");
            for(int num : solucion){
                System.out.print(num);
            }
            System.out.println("");
            System.out.println("-----------------------------");
        }
        else{
            //
            solucion[largo-1] = 0;
            bruteForce_aux(matriz, solucion, largo-1, n);
            solucion[largo-1] = 1;
            bruteForce_aux(matriz, solucion, largo-1, n);
        }
    }
    
    
}
