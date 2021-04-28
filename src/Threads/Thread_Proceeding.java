package Threads;

import Libs.Memory;
import Libs.Run;
import Models.Model_Proceeding;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Proceeding implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(700);
            if (Run.DirExists(Memory.dossiers_files_folder_name)) {
                Run.deleteDirectory(new File(System.getProperty("user.dir") + "//" + Memory.dossiers_files_folder_name));
                Run.createDir(Memory.dossiers_files_folder_name);
            } else {
                Run.createDir(Memory.dossiers_files_folder_name);
            }
            for (int i = 0; i < Memory.list_model_proceeding.size(); i++) {
                Model_Proceeding dossier = Memory.list_model_proceeding.get(i);
                String file_path = Memory.dossiers_files_folder_name + "//";
                String file_name = dossier.getName() + " - " + dossier.getCategory() + " - " + dossier.getUuid();
                Run.BuildTxtFile(file_path, file_name, ".txt", dossier.get_proceeding_view());
            }
            System.out.println("Dossier files created");
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Proceeding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save_dossiers_into_txt_files() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
