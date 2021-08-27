package proyectodomino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProyectoDomino {

    
    public static void main(String[] args) {
        
        List<List<String>> matriz = new ArrayList<>();
        matriz = ScriptPython.runScript(2);
        for(List<String> fila : matriz){
            System.out.println(fila);
        }
        
    }
    
}
