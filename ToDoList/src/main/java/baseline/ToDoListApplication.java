/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Juan Guarnizo
 */
package baseline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoListApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ToDoListApplication.class.getResource("ToDoListApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/*Pseudocode*/
//create Item class

//private Title
//private description
//private dueDate (YYYY-MM-DD)
//private complete

//public Item()
//constructor that initializes the private fields
//also add many constructors with different parameters

//public void setDescription()
//takes a string and save it into the description field

//public void editTitle()
//takes a string and save it into the title field

//public void setDueDate()
//takes integers and sets the dueDate field

//public void setComplete()
//set the boolean field to false

//public String getDescription()
//returns the string in the description field

//public String getTitle()
//returns the string in the title field

//public String getDueDate()
//returns the String in due date field

//public boolean getComplete()
//returns the boolean in complete field

//public void editTitle()
//This method edits the title field for the item class
//public void editDescription()
//This method edits the description field for the item class
//public void editDueDate()
//This method edits the dueDate field for the item class
//public void markComplete
//This method sets the boolean field complete to true
//public void markIncomplete
//This method sets the boolean field complete to false
//end Item class


//create class ToDoList

//private Title at least 3 characters long
//private item[] at least 256 items

//setters and getters

//public addItem()
//public removeItem()
//public displayItemsInToDoList()
//public displayIncompleteItems()
//public displayCompleteItems()

//end class ToDoList

//create class application

//private ToDoList[] at least 256 ToDOLists

//setters and getters

//public addToDoList()
//public removeToDoList()
//public editToDoList()
//public saveToDoList()
//select the list
//specify the file location and name
//all selected list should be saved to a single text file
//public loadToDoList()

//end class application