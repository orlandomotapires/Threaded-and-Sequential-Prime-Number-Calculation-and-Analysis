import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sieve_threads{
    public static void main(String[] args){

        String filePath = "./Entrada01.txt";

        // Creating the sieve
        
        try {
            FileReader fileReader = new FileReader(filePath); // Create a FileReader object to read the file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Wrap FileReader in a BufferedReader for efficient reading     
            String line;         
            while ((line = bufferedReader.readLine()) != null) { // Read each line of the file until reaching the end



                // Process each line as needed
                System.out.println(line);
            }
            
            bufferedReader.close(); // Close the BufferedReader
            
        } catch (IOException e) { // Handle any potential IO exceptions
            
            e.printStackTrace();
        }
    }
}