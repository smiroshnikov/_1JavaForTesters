package chapter18;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class Lesson18Test {
    @Test
    public void propertiesPush() {
        Properties properties = new Properties();
        assertThat(properties.size(), is(0));
        properties.setProperty("browser", "firefox");
        properties.setProperty("port", "8080");
        assertThat(properties.getProperty("port"), is("8080"));
        assertThat(properties.getProperty("golden_penis"), is(nullValue()));
        for (String key :
                properties.stringPropertyNames()) {
            System.out.println("Key: " + key + " " + "Value: " + properties.getProperty(key));

        }
        // or better way
        properties.list(System.out);
    }

    @Test
    public void bobTest() {
        Properties properties = new Properties();
        properties.setProperty("name", "bob");
        properties.setProperty("gender", "male");
        properties.setProperty("passwords", "paSSw0rd");
        assertThat(properties.size(), is(3));
        properties.list(System.out);
        assertThat(properties.getProperty("gender"), is(notNullValue()));
        assertThat(properties.getProperty("permission", "Admin"), is("Admin"));
        String workingDirectory = System.getProperty("user.dir");
        System.out.println(workingDirectory);
        // I can define a new path for resource files
        // String resourceFilePath = workingDirectory +
        // "/src/test/resources/" +
        //"property_files/" +
        //"static_example.properties";
        Properties sys = System.getProperties();
        System.out.println(sys.getProperty("file.separator"));
        System.out.println(sys.getProperty("os.name"));
        System.out.println(sys.getProperty("os.version"));
        System.out.println(sys.getProperty("os.arch"));
        System.out.println(sys.getProperty("user.name"));
        System.out.println(sys.getProperty("user.home"));
        float value = 102.0f;
        System.out.println(value);


    }

    @Test
    public void tempFileExample() throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println(tempDir);
        String tempResouceFilePath = new File(tempDir, "tempFileForPropertiesStore.properties").getAbsolutePath();
        Properties saved = new Properties();
        saved.setProperty("prop1", "hello");
        saved.setProperty("prop2", "Ser");

        FileOutputStream outputFile = new FileOutputStream(tempResouceFilePath);
        saved.store(outputFile, "This is a line that I do not understand ! ");
        outputFile.close();


    }

}
