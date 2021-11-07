package baseline;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
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

        row.setCellValueFactory(new PropertyValueFactory<>("row"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        completed.setCellValueFactory(new PropertyValueFactory<>("completed"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        //create checkbox objects
        for(int i = 0; i < 99; i++){

            list.add(new Item( i + 1, "Call Boss", "Now", new CheckBox(), ""));

        }


        table.setItems(list);


    }







}//end class controller
