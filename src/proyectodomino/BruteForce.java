
package proyectodomino;



public class BruteForce {
        
    public static void exec(int [][] matriz, int [] solucion, int n){
        int largo = ((n+1)*(n+2))/2;    //cantidad de fichas
        solucion = new int[largo];
        
        bruteForce_aux(matriz, solucion, largo);      
    }
    
    private static void bruteForce_aux(int [][] matriz, int [] solucion, int largo){
        if (largo == 0){
            //aqui se prueba la respuesta
            
            /*
            for(int num : solucion){
                System.out.print(num);
            }
            System.out.println("");
            */
        }
        else{
            solucion[largo-1] = 0;
            bruteForce_aux(matriz, solucion, largo-1);
            solucion[largo-1] = 1;
            bruteForce_aux(matriz, solucion, largo-1);
        }
    }
}
