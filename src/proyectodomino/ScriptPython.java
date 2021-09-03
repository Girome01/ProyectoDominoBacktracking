package proyectodomino;

import java.io.*;
import java.time.LocalTime;


public class ScriptPython {
    

    public static int[][] runScript(int n){
        try{
            String s = null;
            int i = 0;  //fila
            int j = 0;  //columna
            int result[][] = new int[n+1][n+2];
            Process p = Runtime.getRuntime().exec("python C:\\Users\\pdina\\Documents\\GitHub\\ProyectoDominoBacktracking\\dominoes.py "+n);
            //Process p = Runtime.getRuntime().exec("python C:\\Users\\Gilberth\\Documents\\Github\\ProyectoDominoBacktracking\\dominoes.py "+n);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            while( i < (n+1)){
                s = in.readLine();
                String str[] = s.split(" ");
                for(String num : str){
                    result[i][j] = Integer.parseInt(num);
                    j++;
                }
                j = 0;
                i++;
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
