package props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getDataFromProp(String propName, Boolean isJdbcProp) {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            if (isJdbcProp) {
                return new StringBuilder("jdbc:")
                        .append(prop.getProperty("postgres.db.host"))
                        .append("/")
                        .append(prop.getProperty("postgres.db.database"))
                        .toString();
            } else {
                return new  StringBuilder(prop.getProperty(propName)).toString();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
