package Libs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLite {

    private String database_uri = Memory.database_uri; // Set database uri here or set in object declaration
    private Connection con;
    ResultSet rs;

    //Connection example:
    //public static SQLite sqlite = new SQLite(SQLiteDB.db");
    //To get program path System.getProperty("user.dir")
    public SQLite(String data_source_path) {
        this.database_uri = data_source_path;
    }

    public SQLite() {
    }

    /**
     * Executes a SQLite querys such as INSERT, DELETE and Update.
     *
     * @param query Query statement. Such as SELECT * from TABLE;
     * @param console_log Message that will be shown on console when the
     * function ends.
     */
    public void Query(String query, String console_log) {
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            Statement stmt = this.con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            // e.printStackTrace();
        } finally {
            System.out.println(console_log);
            Close_connection();
        }
    }

    /**
     * Checks if database exists using Java.io File.
     *
     * @param db_path Path to database.
     * @return Returns true if .db file is found.
     */
    public Boolean check_if_db_exists(String db_path) {
        java.io.File file = new java.io.File(db_path);
        if (file.exists()) {
            //System.out.println("Database exists.");
            return true;
        } else {
            //System.out.println("*** Database does not exists! ***");
            return false;
        }
    }

    public Boolean check_if_table_exists(String table_name) {
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            DatabaseMetaData dbm = this.con.getMetaData();
            ResultSet rs = dbm.getTables(null, null, table_name, null);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // System.out.println("Query finished");
            Close_connection();
        }
    }

    //Method to create a new database
    public void createNewDatabase() {
        String url = "jdbc:sqlite:" + this.database_uri;
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            if (this.con != null) {
                DatabaseMetaData meta = this.con.getMetaData();
            }
            Close_connection();
            //System.out.println("*** Database has been created ***");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Close_connection();
        }
    }

    //Create table to databases
    public void createNewTable(String table_specs) {
        String sqlQuery = table_specs;
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            Statement stmt = this.con.createStatement();
            // create a new table
            stmt.execute(table_specs);
            Close_connection();
            System.out.println("*** Database table has been created ***");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Close_connection();
        }
    }

    /**
     * Closes connection of Database.
     */
    private void Close_connection() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getData_source_path() {
        return database_uri;
    }

    public void setData_source_path(String data_source_path) {
        this.database_uri = data_source_path;
    }

}
