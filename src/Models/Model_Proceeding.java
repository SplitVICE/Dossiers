package Models;

import Libs.Memory;
import Libs.Run;
import java.util.LinkedList;

public class Model_Proceeding {
    private int id;
    private String name;
    private String category;
    private String date;
    private String body;
    private String uuid;

    public Model_Proceeding(String name, String category, String body) {
        this.name = name;
        this.category = category;
        this.body = body;
        this.date = Run.get_date();
        this.uuid = Run.get_uuid();
    }
    
    public Model_Proceeding(String name, String category, String body, String uuid) {
        this.name = name;
        this.category = category;
        this.body = body;
        this.date = Run.get_date();
        this.uuid = uuid;
    }

    public Model_Proceeding(int id, String name, String category, String date, String body, String uuid) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.body = body;
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.category;
    }
    
    public static LinkedList<String> get_categories_not_repeated(){
        LinkedList<String> category_list = new LinkedList<String>();
        for (int i = 0; i < Memory.list_model_proceeding.size(); i++) {
            if(!category_list.contains(Memory.list_model_proceeding.get(i).getCategory())){
                category_list.add(Memory.list_model_proceeding.get(i).getCategory());
            }    
        }
        return category_list;
    }
    
    public String get_proceeding_view(){
        return this.name + "\n" + this.category + "\n" + this.uuid + "\nDate: " + this.date + "\n\n" + this.body;
    }

    public Model_Proceeding() {
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
