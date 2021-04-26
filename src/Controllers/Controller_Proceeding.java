package Controllers;

import Libs.Memory;
import Libs.Run;
import Libs.SQLite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Model_Proceeding;
import java.util.LinkedList;

public class Controller_Proceeding {

    private String database_uri;
    private Connection con;
    ResultSet rs;

    public Controller_Proceeding(String database_uri) {
        this.database_uri = database_uri;
    }

    /**
     * Executes a SQLite querys such as INSERT, DELETE and Update.
     *
     * @param query Query statement. Such as SELECT * from TABLE;
     * @param console_log Message that will be shown on console when the
     * function ends.
     */
    private void Query(String query, String console_log) {
        try {
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            Statement stmt = this.con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            // e.printStackTrace();
        } finally {
            //System.out.println(console_log);
            Close_connection();
        }
    }

    public void save_proceeding(Model_Proceeding item) {
        String query = "INSERT INTO proceeding (uuid, name, category, date, body)\n"
                + "VALUES ('" + Run.get_uuid() + "', "
                + "'" + item.getName() + "', "
                + "'" + item.getCategory() + "', "
                + "'" + Run.get_date() + "', "
                + "'" + item.getBody() + "');";
        Query(query, "");
        System.out.println("Proceeding stored on database");
    }

    public void delete_proceeding(int id) {
        String query = "DELETE FROM proceeding WHERE id == " + id + ";";
        Query(query, "");
        System.out.println("Proceeding deleted");
    }

    public void update_proceeding(Model_Proceeding item) {
        System.out.println("item name: " + item.getName());
        System.out.println("item body: " + item.getBody());
        System.out.println("item category: " + item.getCategory());
        System.out.println("item id: " + item.getId());
        String query = "UPDATE proceeding\n"
                + "SET name = '" + item.getName() + "', body = '" + item.getBody() + "', category = '" + item.getCategory() + "'\n"
                + "WHERE id = " + item.getId() + ";";
        System.out.println(query);
        Query(query, "");
        System.out.println("Proceeding edited");
    }

    public LinkedList<Model_Proceeding> load_proceedings() {
        try {
            LinkedList<Model_Proceeding> temporal_list = new LinkedList<Model_Proceeding>();
            Model_Proceeding model_Proceeding;
            this.con = DriverManager.getConnection("jdbc:sqlite:" + database_uri);
            Statement stmt = this.con.createStatement();
            this.rs = stmt.executeQuery("SELECT * FROM proceeding");
            while (rs.next()) {
                model_Proceeding = new Model_Proceeding();
                model_Proceeding.setId(rs.getInt("id"));
                model_Proceeding.setUuid(rs.getString("uuid"));
                model_Proceeding.setName(rs.getString("name"));
                model_Proceeding.setCategory(rs.getString("category"));
                model_Proceeding.setDate(rs.getString("date"));
                model_Proceeding.setBody(rs.getString("body"));
                temporal_list.add(model_Proceeding);
            }
            return temporal_list;
        } catch (SQLException e) {
            return null;
            //e.printStackTrace();
        } finally {
            Close_connection();
        }
    }

    public void load_proceedings_set_on_memory() {
        Memory.list_model_proceeding = load_proceedings();
    }

    public void print_memory_proceedings_on_console() {
        for (int i = 0; i < Memory.list_model_proceeding.size(); i++) {
            System.out.println(Memory.list_model_proceeding.get(i));
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

    public void create_table() {
        String create_query = "CREATE TABLE \"proceeding\" (\n"
                + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                + "	\"uuid\"	TEXT NOT NULL,\n"
                + "	\"name\"	TEXT NOT NULL,\n"
                + "	\"category\"	TEXT NOT NULL,\n"
                + "	\"date\"	TEXT NOT NULL,\n"
                + "	\"body\"	TEXT NOT NULL,\n"
                + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                + ")";
        Query(create_query, "");
    }
}
