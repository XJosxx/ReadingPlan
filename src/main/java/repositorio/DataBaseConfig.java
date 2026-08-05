package repositorio;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;

public class DataBaseConfig {


    private static final Properties properties = new Properties();


    //lee el archivo properties de resources
    static {
        //lectura del classpath para encontrar el db.properties
        try (InputStream entrada = DataBaseConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (entrada == null) {
                throw new RuntimeException("No se pudo encontrar el archivo db.properties");
            }
            properties.load(entrada);
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo de configuración: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public static Connection obtenerConexion() {

        final String url = properties.getProperty("db.url");
        final String username = properties.getProperty("db.username");
        final  String password = properties.getProperty("db.password");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            System.err.println("Error al cargar el archivo de configuración: " + e.getMessage());
            return null;
        }
    }

    
}
