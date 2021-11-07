package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class ToDoListAppController implements Initializable {

    @FXML
    private TableColumn<Item, Integer> row;

    @FXML
    private TableColumn<Item, String> title;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, CheckBox> completed;

    @FXML
    private TableColumn<Item, String> dueDate;

    @FXML
    private TableView<Item> table;

    ObservableList<Item> list = FXCollections.observableArrayList();


    //Initializing...

    @Override
    public void initialize(URL url, ResourceBundle rb){

        //create checkbox objects
        for(int i = 0; i < 100; i++){

            CheckBox check = new CheckBox("task #" + (i + 1));

            list.add(new Item( i + 1, "", "", check, ""));
        }

        table.setItems(list);

        row.setCellValueFactory(new PropertyValueFactory<Item, Integer>("row"));
        title.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
        description.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        completed.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("completed"));
        dueDate.setCellValueFactory(new PropertyValueFactory<Item, String>("dueDate"));
    }





}//end class controller
