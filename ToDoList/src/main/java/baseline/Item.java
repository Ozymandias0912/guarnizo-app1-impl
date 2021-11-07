package baseline;

import javafx.scene.control.CheckBox;

public class Item {
    //create Item class

    //private row
    private int row;
    //private Title
    private String title;
//private description
    private String description;
//private complete
    private CheckBox complete;
//private dueDate (YYYY-MM-DD)
    private String dueDateString;

    //constructor


    public Item(int row, String title, String description, CheckBox complete, String dueDateString) {
        this.row = row;
        this.title = title;
        this.description = description;
        this.complete = complete;
        this.dueDateString = dueDateString;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheckBox getComplete() {
        return complete;
    }

    public void setComplete(CheckBox complete) {
        this.complete = complete;
    }

    public String getDueDateString() {
        return dueDateString;
    }

    public void setDueDateString(String dueDateString) {
        this.dueDateString = dueDateString;
    }
}//end Item class
