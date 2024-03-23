
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Input and output file paths
    static String input = "./txt_files/Entrada01.txt";
    static String output = "./txt_files/Prime_numbers.txt";
    static String timeAnalyses = "./txt_files/time_analyses.txt"; // Path to time analyses file

    public static void main(String[] args) {
        // Clear existing content in Prime_numbers.txt and time_analyses.txt files
        clearFile(output);
        clearFile(timeAnalyses);

        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose the number of threads
        System.out.println("Choose the amount of threads you want to use: 1, 5, 10");
        int num_threads = scanner.nextInt();

        // Array to hold threads
        Thread threads[] = new Thread[num_threads];

        // Suppress warnings for unchecked type casting
        @SuppressWarnings("unchecked")
        // Array of lists to store prime numbers found by each thread
        List<Integer>[] arrayOfLists = new ArrayList[num_threads];

        try {
            // Count total lines in the input file
            int totalLines = count_lines(input);
            // Calculate lines per thread
            int linesPerThread = totalLines / num_threads;

            long startTime = System.nanoTime(); // Record the start time of prime number calculation

            // Spawn threads
            for (int i = 0; i < num_threads; i++) {
                int startLine = i * linesPerThread + 1; // Calculate starting line for the thread
                int endLine = (i + 1) * linesPerThread; // Calculate ending line for the thread

                // If it's the last thread, assign remaining lines to it
                if (i == num_threads - 1) endLine = totalLines;

                // Create and start thread
                threads[i] = new Thread(new MyRunnable(startLine, endLine, num_threads, i, arrayOfLists));
                threads[i].start();
            }

            long endTime = System.nanoTime(); // Record the end time of prime number calculation
            long elapsedTime = endTime - startTime; // Calculate elapsed time
            double seconds = (double) elapsedTime / 1_000_000_000.0; // Convert nanoseconds to seconds

            // Write elapsed time to the time_analyses.txt file
            MyRunnable.writeTimeAnalysis(seconds);
            

        } catch (IOException e) {
            // Handle IOException
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            // Close scanner
            scanner.close();
        }

        // Wait for all threads to finish
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Write prime numbers found by each thread to the output file
        insert_final_file(arrayOfLists);
    }

    // Method to count lines in a file
    public static int count_lines(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int lineCount = 0;
        try {
            // Count lines
            while (reader.readLine() != null) {
                lineCount++;
            }
        } finally {
            // Close reader
            reader.close();
        }
        return lineCount;
    }

    // Method to insert prime numbers into the final file
    public static void insert_final_file(List<Integer>[] arrayOfLists){
        try {
            // Open buffered writer for appending to the output file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Main.output, true));
            // Iterate through each list in arrayOfLists
            for(List<Integer> al: arrayOfLists) {
                // Iterate through each integer in the list
                for(Integer i: al){
                    // Write integer to file
                    bufferedWriter.write(Integer.toString(i));
                    // Write newline character
                    bufferedWriter.newLine();
                }
            }

            // Close buffered writer
            bufferedWriter.close();

        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } 
    }

    // Method to clear content of a file
    public static void clearFile(String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(""); // Write empty string to clear content
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
