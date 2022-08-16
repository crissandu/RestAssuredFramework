package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() throws Exception {
        if(req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

            return req;
        }
        return req;
    }


    public static String getGlobalValue(String key) throws Exception {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/global.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }


}
