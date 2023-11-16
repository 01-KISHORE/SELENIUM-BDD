package KISHORE.AUTOMATION.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    private FileReader fileReader;
    public String getData(String key){
        try {
            fileReader = new FileReader("resources/testConfig.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
