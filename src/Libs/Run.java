package Libs;

import Controllers.Controller_Proceeding;
import Frames.Home;
import Threads.Thread_Proceeding;
import java.awt.Desktop;
import java.awt.Frame;
import java.util.UUID;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Run {

    public SQLite sqlite_instance;

    public Run() {
        handler_database();
        handler_load_data();
        handler_writer();
        Home home = new Home();
    }

    private void handler_database() {
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

    private void handler_load_data() {
        Controller_Proceeding controller_Proceeding = new Controller_Proceeding(Memory.database_uri);
        controller_Proceeding.load_proceedings_set_on_memory();
        System.out.println("Proceedings data loaded");
    }

    private void handler_writer() {
        Thread_Proceeding thread_Proceeding = new Thread_Proceeding();
        thread_Proceeding.save_dossiers_into_txt_files();
    }

    public static String get_uuid() {
        return UUID.randomUUID().toString();
    }

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

    public static void openLink(String link) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void BuildTxtFile(String path, String txtFileName, String extension, String content) {
        /*"\r\n" to jump between lines*/
        //System.out.print("writing...");
        File file;
        if (!path.equals("here")) {
            file = new File(path + "\\" + txtFileName + extension);
        } else {
            file = new File(System.getProperty("user.dir") + "\\" + txtFileName + extension);
        }
        try {
            String frase = content;
            if (frase.equals("")) {
                frase = "No content.";
            }
            FileWriter escritura = new FileWriter(file.getPath());
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }
            //System.out.println("done");
            escritura.close();
        } catch (Exception ex) {
            System.out.println("Error\n" + ex);
        }
    }

    public static void createDir(String folderName) {
        File file = new File(System.getProperty("user.dir") + "\\" + folderName);
        file.mkdir();
    }

    public static boolean DirExists(String folderName) {
        File file = new File(System.getProperty("user.dir") + "\\" + folderName);
        return file.exists();
    }

    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
