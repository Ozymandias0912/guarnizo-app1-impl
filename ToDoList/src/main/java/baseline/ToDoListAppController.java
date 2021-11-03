package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class ToDoListAppController implements Initializable {

    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, Boolean> completed;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, String> dueDate;

    @FXML
    private TableColumn<Item, String> title;

    @FXML
    private TextField titleInput;

    @FXML
    private TextField yearInput;

    @FXML
    private TextField monthInput;

    @FXML
    private TextField dayInput;

    @FXML
    private TextField descriptionInput;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
        dueDate.setCellValueFactory(new PropertyValueFactory<Item, String>("dueDate"));
        description.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        completed.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("completed"));

    }

    //adding a row with a button
    @FXML
    void addWithDueDate (ActionEvent event){
        Item newItem = new Item(titleInput.getText(), descriptionInput.getText(),
                Integer.parseInt(yearInput.getText()), Integer.parseInt(monthInput.getText()),
                Integer.parseInt(dayInput.getText()) );

        ObservableList <Item> list = table.getItems();
        list.add(newItem);

        table.setItems(list);
    }
    //trying to make the date optional
    @FXML
    void add (ActionEvent event){
        Item newItem = new Item(titleInput.getText(), descriptionInput.getText());

        ObservableList <Item> list = table.getItems();
        list.add(newItem);

        table.setItems(list);
    }
//remove button
    @FXML
    void remove (ActionEvent event){
        int selectedItem = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedItem);
    }
//remove all tasks button
    @FXML
    void removeAll (ActionEvent event){
        table.getItems().clear();
    }

    //edit task button

    @FXML
    void editDueDate (ActionEvent event){

        //removing new version of the item
        int selectedItem = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedItem);

        //adding new version of the item
        Item newItem = new Item(titleInput.getText(), descriptionInput.getText(),
                Integer.parseInt(yearInput.getText()), Integer.parseInt(monthInput.getText()), Integer.parseInt(dayInput.getText()));

        ObservableList <Item> list = table.getItems();
        list.add(selectedItem, newItem);

        table.setItems(list);

    }

    @FXML
    void edit (ActionEvent event){

        //removing new version of the item
        int selectedItem = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedItem);

        //adding new version of the item
        Item newItem = new Item(titleInput.getText(), descriptionInput.getText() );

        ObservableList <Item> list = table.getItems();
        list.add(selectedItem, newItem);

        table.setItems(list);

    }

}
