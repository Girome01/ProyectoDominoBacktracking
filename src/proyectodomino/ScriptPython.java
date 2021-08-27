package proyectodomino;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScriptPython {
    
    
    public static List<List<String>> runScript(int n){
        try{
            String s = null;
            int i = 0;
            List<List<String>> matriz = new ArrayList<>();
            Process p = Runtime.getRuntime().exec("python C:\\Users\\pdina\\Documents\\GitHub\\ProyectoDominoBacktracking\\dominoes.py "+n);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while( (s=in.readLine()) != null){
                String str[] = s.split(" ");
                matriz.add(Arrays.asList(str));
                //System.out.println(matriz.get(i));
                i++;
                //System.out.println(s);
            }
            return matriz;
        }
        catch(IOException ie){
            ie.printStackTrace();
            return null;
        }
    }
}
