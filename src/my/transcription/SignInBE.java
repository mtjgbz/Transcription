package my.transcription;

import java.sql.*;
import static my.transcription.SignIn.errorMsg;
import org.sqlite.*;

/**
 * Sign in BE
 * @author Noah, Michael, Casey, Erica
 */
public class SignInBE {

    private String username;
    private String password;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    /**
     * Constructor
     */
    public SignInBE() {
    }

    /**
     * Sets up the Database
     */
    public void setupDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enableFullSync(true);
            config.setReadOnly(false);
            SQLiteDataSource ds = new SQLiteDataSource(config);
            ds.setUrl("jdbc:sqlite::resource:" + getClass().getResource("TAA.db").toString());
            conn = ds.getConnection();
            stmt = conn.createStatement();
        } catch (Exception e) {
            errorMsg(e.toString(), "Error de la base de datos.");
        }
    }

    /**
     * closes the database
     */
    public void closeDB() {
        try {
            stmt.close();
            if (rs != null) {
                rs.close();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets u to username
     * @param u 
     */
    public void setUsername(String u) {
        username = u;
    }

    /**
     * sets p to password
     * @param p 
     */
    public void setPassword(String p) {
        password = p;
    }

    /**
     * Verifies that the password is correct.
     * @param username
     * @param password
     * @return 
     */
    public boolean checkPassword(String username, String password) {
        try {
            String query = "SELECT COUNT(*) AS Users FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "';";
            rs = stmt.executeQuery(query);
            if (rs.getInt("Users") == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Checks if it's the admin trying to login
     * @param username
     * @return 
     */
    public boolean checkAdmin(String username) {

        return username.equals("admin");
    }
}
