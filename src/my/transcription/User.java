/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Component;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.sqlite.*;

/**
 *
 * @author Erica
 */
public class User {

    private static Connection conn;
    private static JFrame parentFrame;
    private static String dbPath;

    /**
     * Creates the window for the file browser and sets it visible.
     */
    public static void updateLessonFile() {
        UpdateLessonFile frame = new UpdateLessonFile();
        frame.setVisible(true);
    }

    /**
     * Creates the text file with the list of applicable transcriptions for each
     * lesson. Updates the database with the resulting text file.
     *
     * @param transcriptions Path where all the transcription files are located
     * @param path Path for the text file to be stored in
     */
    public static void createTextFile(String transcriptions, String path) {
        try {
            dbPath = path;
            Statement stmt = setupDB(parentFrame, dbPath);
            Statement stmt2 = conn.createStatement();
            String query = "SELECT Lesson, Sublesson FROM LESSON_PLAN";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> filePaths = new ArrayList<String>();
            ArrayList<Integer> lessons = new ArrayList<Integer>();
            ArrayList<String> sublessons = new ArrayList<String>();
            while (rs.next()) {
                int lesson = rs.getInt("Lesson");
                String sublesson = rs.getString("Sublesson");
                query = "SELECT RegularExpression FROM LESSON_PLAN WHERE "
                        + "Lesson = " + lesson + " AND "
                        + "Sublesson LIKE '" + sublesson + "';";
                ResultSet rsExp = stmt2.executeQuery(query);

                lessons.add(lesson);
                sublessons.add(sublesson);

                String regex = rsExp.getString("RegularExpression");
                regex = regex.replace(" ", "");

                String filePath = "";
                filePath = searchFile(regex, transcriptions, filePath);

                filePaths.add(filePath);
            }
            stmt2.close();
            closeDB(stmt, rs);

            stmt = setupDB(parentFrame, dbPath);
            for (int i = 0; i < filePaths.size(); i++) {
                String newQuery = "UPDATE LESSONS SET FileList = '" + filePaths.get(i) + "' "
                        + "WHERE Lesson = " + lessons.get(i) + " AND "
                        + "Sublesson LIKE '" + sublessons.get(i) + "';";
                stmt.execute(newQuery);
            }
            closeDB(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Searches the directory given and uses the given writer to write the path
     * to the text file if it matches requirements.
     *
     * @param regex Regular expression to search the transcription files
     * @param path Directory or file to search for transcription files
     * @param out Writer for the final text file
     */
    private static String searchFile(String regex, String path, String out) {
        try {
            //Search through all the files
            File home = new File(path);
            File[] fileList = home.listFiles();
            if (fileList == null) {
                return null;
            }

            for (File f : fileList) {
                if (f.isDirectory()) {
                    out = searchFile(regex, f.getPath(), out);
                } 
                else if (f.getName().contains(".trs")) {
                    if (setupFile(f.getPath(), regex)) {
                        try {
                            out = out + f.getPath();
                            out = out + "; ";
                            return out;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * Creates the tone path and stores it in the Database.
     * Updates the database with the tone path as lesson 0.
     *
     * @param transcriptions Path where all the tonal files are located
     * @param path Path for the tone
     */
    public static void createTonePath(String transcriptions, String path) {
        try {
            dbPath = path;
            Statement stmt = setupDB(parentFrame, dbPath);
            System.out.println(transcriptions);
            String newQuery = "UPDATE LESSONS SET FileList = '" + transcriptions + "' WHERE Lesson = 0;";
            stmt.execute(newQuery);

            closeDB(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds or updates a given Lesson, Sublesson pair in the TAA database
     * 
     * @param lesson Lesson number to be added or updated
     * @param subLesson Sublesson to be added or updated
     * @param regEx Regular Expression associated with Lesson and Sublesson
     * @param path Path to Database resource
     */
    public static void addLesson(String lesson, String subLesson, String regEx, String path) {
        try {
            dbPath = path;
            Statement stmt = setupDB(parentFrame, dbPath);
            String query = "SELECT COUNT(*) AS RegularExpression"
                    + " FROM LESSON_PLAN WHERE Lesson = '"
                    + lesson + "' AND Sublesson = '"
                    + subLesson + "';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.getInt("RegularExpression") == 1) {
                String newQuery = "UPDATE LESSON_PLAN SET RegularExpression = '"
                        + regEx + "' WHERE Lesson = '" + lesson
                        + "' AND Sublesson = '" + subLesson + "';";
                stmt.execute(newQuery);
            } else {
                String newQuery = "INSERT INTO LESSON_PLAN"
                        + "(Lesson, Sublesson, RegularExpression) VALUES ('"
                        + lesson + "', '"
                        + subLesson + "', '"
                        + regEx + "');";
                stmt.execute(newQuery);
                
                newQuery = "INSERT INTO LESSON"
                        + "(Lesson, Sublesson) VALUES ('"
                        + lesson + "', '"
                        + subLesson + "');";
                stmt.execute(newQuery);
            }
            closeDB(stmt,rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches the given file to see if there is any phrase matching the
     * regular expression given.
     *
     * @param filename File to search with regular expression
     * @param regex Regular expression to search with
     * @return True if the file contains a word matching the regular expression
     */
    private static boolean setupFile(String filename, String regex) {
        try {
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Sync");
            Pattern regexp = Pattern.compile(regex);
            Matcher matcher = regexp.matcher(inputFile.getName());

            //System.out.println(inputFile.getName());
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                String value = nNode.getNextSibling().getNodeValue();
                matcher.reset(value);

                if (matcher.find()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Sets up the database.
     *
     * @return Statement that is a part of the database
     */
    public static Statement setupDB(JFrame pFrame, String DatabasePath) {
        try {
            dbPath = DatabasePath;
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enableFullSync(true);
            config.setReadOnly(false);
            SQLiteDataSource ds = new SQLiteDataSource(config);
            ds.setUrl("jdbc:sqlite::resource:" + DatabasePath);
            conn = ds.getConnection();
            System.out.println("Database opened successfully");
            Statement stmt = conn.createStatement();
            parentFrame = pFrame;
            return stmt;
        } catch (Exception e) {
            errorMessage(parentFrame, e.getMessage(), "Error");
            pFrame.dispose();
        }
        return null;
    }

    /**
     * Closes the connection to the database
     *
     * @param stmt Statement to be closed with the database
     */
    public static void closeDB(Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            errorMessage(parentFrame, e.getMessage(), "Error");
        }
    }

    /**
     * Closes the connection to the database.
     *
     * @param stmt Statement to be closed with the database
     * @param rs ResultSet to be closed with the database
     */
    public static void closeDB(Statement stmt, ResultSet rs) {
        try {
            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates an error message to be displayed.
     *
     * @param container Parent container for the pane to be within.
     * @param message Message to be displayed within the dialog.
     * @param title Title at the top of dialog.
     */
    public static void errorMessage(Component container, String message, String title) {
        JOptionPane.showMessageDialog(container, message, title,
                JOptionPane.ERROR_MESSAGE);
    }
}
