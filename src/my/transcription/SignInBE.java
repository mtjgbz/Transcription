package my.transcription;
import java.sql.*;

public class SignInBE {
    private String username;
    private String password;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public SignInBE(){

    }

    public void setupDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:TAA.db");
            System.out.println("Database opened successfully.");
            stmt = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try {
            stmt.close();
            rs.close();
            conn.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String u){
        username = u;
    }

    public void setPassword(String p){
        password = p;
    }

    public boolean checkPassword(String username, String password){
        try {
            String query = "SELECT COUNT(*) AS Users FROM USERS WHERE USERNAME LIKE '" + username + "' AND PASSWORD LIKE '" + password + "';";
            rs = stmt.executeQuery(query);
            if (rs.getInt("Users") == 1){
                //maybe just return true here and then use results to print something like this somewhere else
                //query = "SELECT Fname FROM USERS WHERE USERNAME LIKE '" + username + "';";
                //rs = stmt.executeQuery(query);
                //String fname = rs.getString("Fname"); 
                //System.out.println("Welcome, " + fname);
                return true;
            }
            else {
                return false;
            }
        } 
        catch (SQLException e) {
                e.printStackTrace();
        }

        return false;
    }

    public boolean checkAdmin(String username, String password) {

        if(username == "admin") {
            return true;
        }
        else {
            System.out.println("Login failed. Please try again.");
            return false;
        }

    }

}
