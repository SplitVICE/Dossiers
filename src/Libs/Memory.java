package Libs;

import Models.Model_Proceeding;
import java.util.LinkedList;

public class Memory {

    public static String database_uri = "db.db";
    public static LinkedList<Model_Proceeding> list_model_proceeding = new LinkedList<Model_Proceeding>();
    public static String application_name = "Dossiers";
    public static String application_version = "1.0.0";

    public static java.awt.Image getIconImage() {
        return java.awt.Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png"));
    }
}
