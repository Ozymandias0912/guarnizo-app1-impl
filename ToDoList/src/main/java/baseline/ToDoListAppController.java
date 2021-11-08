package baseline;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;


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

    @FXML
    private FileChooser fileChooser = new FileChooser();



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

        fileChooser.setInitialDirectory(new File("src\\saved files"));

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


    //save in file menu: file -> save as

    @FXML
    public void saveFile(ActionEvent ae){

        File file = fileChooser.showSaveDialog(new Stage());

        if(file != null){

            String content = "";

            for(int i = 0; i < list.size(); i++){

                content = content + list.get(i).getTitle() + " " + list.get(i).getDescription() + " " +
                        list.get(i).getDueDateString() + " " + list.get(i).getComplete().toString() + "\n";
            }


            save(file, content);
        }
    }

    private void save(File file, String content) {

        try{
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadFile(ActionEvent ae){

        File file = fileChooser.showOpenDialog(new Stage());

        try {
            Scanner input = new Scanner(file);

            String title;
            String description;
            String dueDate;
            Boolean completed;

            while(input.hasNext()){

                title = input.next();
                dueDate = input.next();
                description = input.next();
                completed = input.nextBoolean();

                Item task = new Item(title, description, completed, dueDate);

                list.add(task);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




}//end class controller
