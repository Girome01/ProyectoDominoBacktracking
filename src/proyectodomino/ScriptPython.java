package proyectodomino;

import java.io.*;
import java.time.LocalTime;


public class ScriptPython {
    

    public static int [] runScript(int n){
        try{
            String s = null;
            int i = 0;  //indice del array resultado
            int j = 0;  //indice de la fila que se está leyendo
            int [] result = new int[(n+1)*(n+2)];
            Process p = Runtime.getRuntime().exec("python C:\\Users\\pdina\\Documents\\GitHub\\ProyectoDominoBacktracking\\dominoes.py "+n);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            while( j < (n+1)){
                s = in.readLine();
                String str[] = s.split(" ");
                for(String num : str){
                    result[i] = Integer.parseInt(num);
                    i++;
                }  
                j++;
            }
            s = in.readLine();
            System.out.println(LocalTime.now());
            System.out.println("Respuesta: "+s);
            
            in.close();
            p.destroy();
            return result;
        }
        catch(IOException ex){
            System.out.println("Error: "+ex);
            return null;
        } 
        catch(NullPointerException ex){
            System.out.println("Error: "+ex);
            return null;
        }
    }
}
