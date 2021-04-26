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

    public SQLite(String data_source_path) {
        this.database_uri = data_source_path;
    }

    public SQLite() {
    }

    public void Query(String query, String console_log) {
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            Statement stmt = this.con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
        } finally {
            System.out.println(console_log);
            Close_connection();
        }
    }

    public Boolean check_if_db_exists(String db_path) {
        java.io.File file = new java.io.File(db_path);
        if (file.exists()) {
            return true;
        } else {
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
            Close_connection();
        }
    }

    public void createNewDatabase() {
        String url = "jdbc:sqlite:" + this.database_uri;
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            if (this.con != null) {
                DatabaseMetaData meta = this.con.getMetaData();
            }
            Close_connection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Close_connection();
        }
    }

    public void createNewTable(String table_specs) {
        String sqlQuery = table_specs;
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            Statement stmt = this.con.createStatement();
            stmt.execute(table_specs);
            Close_connection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Close_connection();
        }
    }

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
