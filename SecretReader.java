package training1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecretReader {
    public static void main(String[] args) {
        String filename = "secret.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading secrets from file:");
            System.out.println("---------------------------");
            
            while ((line = reader.readLine()) != null) {
                // Process each line
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    
                    System.out.println(key + " -> " + value);
                } else {
                    System.out.println(line);
                }
            }
            
            System.out.println("---------------------------");
            System.out.println("Secrets loaded successfully!");
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
