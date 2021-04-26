package Libs;

import Controllers.Controller_Proceeding;
import Frames.Home;
import Models.Model_Proceeding;
import java.util.UUID;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Run {

    public SQLite sqlite_instance;

    public Run() {
        handler_database();
        handler_load_data();
        Home home = new Home();
    }

    public void handler_database() {
        sqlite_instance = new SQLite();
        boolean db_exists = sqlite_instance.check_if_db_exists("db.db");

        if (!db_exists) {
            System.out.println("Database does not exist");
            sqlite_instance.createNewDatabase();
            System.out.println("Database created");
        } else {
            System.out.println("Database found");
        }

        boolean db_table_exists = sqlite_instance.check_if_table_exists("proceeding");

        if (!db_table_exists) {
            System.out.println("Table proceedings does not exist");
            Controller_Proceeding controller_Proceeding = new Controller_Proceeding(sqlite_instance.getData_source_path());
            controller_Proceeding.create_table();
            System.out.println("Table proceedings created");
        } else {
            System.out.println("Table proceedings found");
        }
    }

    public void handler_load_data() {
        Controller_Proceeding controller_Proceeding = new Controller_Proceeding(Memory.database_uri);
        controller_Proceeding.load_proceedings_set_on_memory();
        System.out.println("Proceedings data loaded");
    }

    public static String get_uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * Shows JOptionPane panel.
     *
     * @param message Body message.
     * @param title Title message.
     * @param icon Type of icon to show. Options: "Error", "Message", "Alert",
     * "QuestionMark"
     */
    public static void joptionPaneMessage(String message, String title, String icon) {
        switch (icon) {
            case "Error":
                JOptionPane.showMessageDialog(null, message, title, 0);
                break;
            case "Message":
                JOptionPane.showMessageDialog(null, message, title, 1);
                break;
            case "Alert":
                JOptionPane.showMessageDialog(null, message, title, 2);
                break;
            case "QuestionMark":
                JOptionPane.showMessageDialog(null, message, title, 3);
                break;
            default:
                JOptionPane.showMessageDialog(null, message, title, 1);
        }
    }

    public static String get_date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void copy_to_clipboard(String input) {
        StringSelection selection = new StringSelection(input);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    /**
     * Shows a JOptionPane that asks the user something.
     *
     * @param message Body message.
     * @param title Title message.
     * @param option Shows answer buttons. 0: Yes & No buttons. Yes returns 0.
     * No returns 1. X returns -1. 1: Yes, No & Cancel buttons. Yes returns 0.
     * No returns 1, Cancel returns 2. X returns -1. 2: Accept & Cancel buttons.
     * Accept returns 0. Cancel returns 2. X returns -1.
     * @param icon Shows an icon. "Error": shows error icon. "Message": shows
     * informative icon. "Alert": shows exclamation icon. "QuestionMark": shows
     * question mark icon.
     * @return int - Returns the number of the specified button pressed. Read
     * option @param description.
     */
    public static int joptionPaneAsk(String message, String title, int option, String icon) {
        switch (icon) {
            case "Error":
                return JOptionPane.showConfirmDialog(null, message, title, option, 0);
            case "Message":
                return JOptionPane.showConfirmDialog(null, message, title, option, 1);
            case "Alert":
                return JOptionPane.showConfirmDialog(null, message, title, option, 2);
            case "QuestionMark":
                return JOptionPane.showConfirmDialog(null, message, title, option, 3);
            default:
                return JOptionPane.showConfirmDialog(null, message, title, option, 1);
        }
    }
}
