package baseline;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ToDoListAppController implements Initializable {


    @FXML
    private TableColumn<Item, String> title;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, Boolean> complete;

    @FXML
    private TableColumn<Item, String> dueDateString;

    @FXML
    private TableView<Item> table;



    ObservableList<Item> list = FXCollections.observableArrayList();

    //input characteristics
    @FXML
    private TextField titleInput;

    @FXML
    private TextField descriptionInput;

    @FXML
    private DatePicker datePicker;





    //Initializing...

    @Override
    public void initialize(URL url, ResourceBundle rb){

        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        complete.setCellFactory(CheckBoxTableCell.forTableColumn(complete));
        complete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        complete.setEditable(true);
        dueDateString.setCellValueFactory(new PropertyValueFactory<>("dueDateString"));
        table.setEditable(true);


        table.setItems(list);

    }//end initialize



    //add task button
    public void addTask(ActionEvent ae) {
        if(datePicker.getValue() == null){
            //add task with no due date
            Item task = new Item(titleInput.getText(), descriptionInput.getText(), false);

            task.setDescription(task.validateDescription(task.getDescription()));

            list.add(task);
        }
        else{
            //add task with due date
            Item task = new Item( titleInput.getText(), descriptionInput.getText(),
                    false,  datePicker.getValue().toString());

            //validate date
            if(datePicker.getValue().isBefore(LocalDate.now())){

                task.setDueDateString(LocalDate.now().toString());
            }
            else{

                task.setDueDateString(datePicker.getValue().toString());
            }

            //validate description
            task.setDescription(task.validateDescription(task.getDescription()));

            list.add(task);
        }
    }//end add task function

    //remove task button
    public void removeTask(ActionEvent ae){

        list.remove(table.getSelectionModel().getSelectedIndex());
    }

    //delete all button
    public void removeAllTasks(ActionEvent ae){

        list.remove(0, list.size());
    }

    //edit button
    public void editTask(ActionEvent ae){

        if(datePicker.getValue() == null){

            //get index of task in the list
            int index = table.getSelectionModel().getSelectedIndex();
            //remove task
            list.remove(index);
            //add task in the same index
            Item task = new Item(titleInput.getText(), descriptionInput.getText(), false);

            task.setDescription(task.validateDescription(task.getDescription()));

            list.add(index, task);
        }
        else{

            //get index of task in the list
            int index = table.getSelectionModel().getSelectedIndex();
            //remove task
            list.remove(index);
            //add task in the same index
            //add task with due date
            Item task = new Item( titleInput.getText(), descriptionInput.getText(),
                    false,  datePicker.getValue().toString());

            //validate date
            if(datePicker.getValue().isBefore(LocalDate.now())){

                task.setDueDateString(LocalDate.now().toString());
            }
            else{

                task.setDueDateString(datePicker.getValue().toString());
            }

            //validate description
            task.setDescription(task.validateDescription(task.getDescription()));

            list.add(index, task);
        }
    }


    //save in file button
    


}//end class controller
