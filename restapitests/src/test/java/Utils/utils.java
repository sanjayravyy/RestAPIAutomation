package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {

    RequestSpecification req;
    PrintStream log;

    public utils() throws FileNotFoundException {
        log = new PrintStream(new FileOutputStream("logging.txt"));
    }

    public RequestSpecification requestSpecification() throws IOException {
    
        req = new RequestSpecBuilder()
            .setBaseUri(getGlobalProperty("base_url"))
            .addQueryParam("key", getGlobalProperty("key"))
            .addFilter(RequestLoggingFilter.logRequestTo(log))
            .addFilter(ResponseLoggingFilter.logResponseTo(log))
            .setContentType(ContentType.JSON)
            .build();
        return req;
    }

    public static String getGlobalProperty(String key) throws IOException{
        Properties property = new Properties();
        FileInputStream file = new FileInputStream("C:\\Automation\\Mobile Java Repo\\Rest API Placeholder\\restapitests\\src\\test\\java\\propertiesfiles\\globalfile.properties");
        property.load(file);
        String value = property.getProperty(key);
         return value;
    }
}
