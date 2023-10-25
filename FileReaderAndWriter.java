import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
    private String fileName;

    public FileReaderAndWriter(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName(Project projectName) {
        // This method might return a file name based on the project name or other criteria.
        return projectName.getName() + ".txt";
    }

    public void addToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFromFile(String data) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder fileContents = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(data)) {
                    fileContents.append(line).append("\n");
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContents.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editFile(String oldData, String newData) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder fileContents = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(oldData) || line.contains(oldData)) {
                    fileContents.append(newData).append("\n");
                } else {
                    fileContents.append(line).append("\n");
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContents.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFile() {
        try {
            if (new File(fileName).delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File deletion failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(String query) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(query)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
