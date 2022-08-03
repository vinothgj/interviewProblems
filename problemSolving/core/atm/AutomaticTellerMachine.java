package core.atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class AutomaticTellerMachine {
    public static void main(String[] args) throws IOException {
        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath);

        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);

        FileInputStream configFile = new FileInputStream("C:/Users/egajvin/IdeaProjects/handsOn/MatrixSolution/src/core/atm/resources" + File.separator + "config.properties");
        Properties configProperties = new Properties();
        configProperties.load(configFile);


        String[] denominations = configProperties.getProperty("denomination").split(",");

        Arrays.stream(denominations).forEach(s -> {
            System.out.println(s);
        });

    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
