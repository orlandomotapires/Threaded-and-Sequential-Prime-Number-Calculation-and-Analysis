import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable {
    // Instance variables to store start and end line numbers, thread number, and array of lists
    private final int startLine;
    private final int endLine;
    private final int num_thread;
    private final List<Integer>[] arrayOfLists; 
    
    // Constructor to initialize instance variables
    public MyRunnable(int startLine, int endLine, int num_threads, int num_thread, List<Integer>[] arrayOfLists) {
        this.startLine = startLine;
        this.endLine = endLine;
        this.arrayOfLists = arrayOfLists; // Assign the provided array of lists
        this.num_thread = num_thread;
    }

    @Override
    public void run() {
        try {
            // Open buffered reader to read from the input file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Main.input));

            String line;
            int lineNumber = 0;

            // Skip lines until reaching the start line for this thread
            while (lineNumber < startLine) {
                bufferedReader.readLine(); // Read and discard line
                lineNumber++;
            }
            
            int lineCount = 0; // Counter for the lines read
            // Read and process lines within the block assigned to this thread
            while (lineNumber < endLine && (line = bufferedReader.readLine()) != null) {
                
                int numberToCheck = Integer.parseInt(line); // Convert the string number to integer

                // Check if the number is prime
                if (Trial_division_algorithm.isPrime_Trial_division(numberToCheck)) {
                    // If the list for this thread is null, initialize it
                    if (arrayOfLists[this.num_thread] == null) {
                        arrayOfLists[this.num_thread] = new ArrayList<>();
                    }
                    // Add the prime number to the list for this thread
                    arrayOfLists[this.num_thread].add(numberToCheck);
                }

                lineNumber++;
            }

            // Close the buffered reader
            bufferedReader.close();
        } catch (NumberFormatException | IOException e) {
            // Handle NumberFormatException and IOException
            e.printStackTrace();
        }
    }

    // Method to write elapsed time to the time_analyses.txt file
    static synchronized void writeTimeAnalysis(double elapsedTime) {
        try {
            // Open buffered writer to append to the time_analyses.txt file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Main.timeAnalyses, true));
            // Write thread name and elapsed time to the file
            bufferedWriter.newLine();
            bufferedWriter.write(Double.toString(elapsedTime));
            bufferedWriter.newLine();
            // Close the buffered writer
            bufferedWriter.close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }
}
