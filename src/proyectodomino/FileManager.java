package proyectodomino;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;


public class FileManager {
    
    public static int [][] getMatriz(int n) throws IOException{
        int [][] matriz = new int[n+1][n+2];
        String s = FileManager.readFile(
                        "C:\\Users\\pdina\\Documents\\GitHub\\ProyectoDominoBacktracking\\src"+
                          "\\proyectodomino\\tableros\\TableroDoble"+n+".txt");
        /*String s = FileManager.readFile(
                        "C:\\Users\\Gilberth\\Documents\\Github\\ProyectoDominoBacktracking\\src"+
                                "\\proyectodomino\\tableros\\TableroDoble"+n+".txt");*/
        
        String partes[] = s.split("\n");
        //System.out.print("Respuesta: ");
        System.out.println(partes[n+4]);
        
        for(int i = 0; i < n+1; i++){ //i es fila
            String [] fila = partes[i+2].split(" ");
            for(int j = 0; j < n+2; j++){
                matriz[i][j] = Integer.parseInt(fila[j]);
            }
        }
        return matriz;
    }
    
    // read txt file
    private static String readFile (String path) throws FileNotFoundException, IOException
    {
        String everything;

        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        everything = sb.toString();
        }   

        return everything;
    }
}
