package baseline;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

public class Item {
    //create Item class

//private Title
    private String title;
//private description
    private String description;
//private complete
    private boolean complete;
//private dueDate (YYYY-MM-DD)
    private String dueDateString;

// public Item()
    public Item(){
        //constructor that initializes the private fields
        this.title = "Title of your task goes here";

        this.description = "Notes about the task goes here";

        this.dueDateString = setValidDueDate();


        this.complete = false;
    }

//also add many constructors with different parameters
    public Item(String newTitle){
        this.title = newTitle;

        this.description = "Notes about the task goes here";

        this.dueDateString = setValidDueDate();//create a method that receives input and creates a valid dueDate

        this.complete = false;
    }


    public Item(String newTitle, String newDescription){
        this.title = newTitle;

        editDescription(newDescription);

        this.dueDateString = setValidDueDate();//create a method that receives input and creates a valid dueDate

        this.complete = false;
    }

    public Item(String newTitle, String newDescription, int year, int month, int day){
        this.title = newTitle;

        this.description = newDescription;

        this.dueDateString = setValidDueDate(year, month, day);//create a method that receives input and creates a valid dueDate

        this.complete = false;
    }


    public Item( String newTitle, int year, int month, int day){
        this.title = newTitle;

        this.description = "Notes about the task goes here";

        this.dueDateString = setValidDueDate(year, month, day);//create a method that receives input and creates a valid dueDate

        this.complete = false;
    }

    //public void editTitle()
    public void editTitle(String newTitle){
        this.title = newTitle;
    }


//public void editDescription()
    public void editDescription(String newDescription){//takes a string and save it into the description field
        if(newDescription.length() >= 1 && newDescription.length() <= 256)
            this.description = newDescription;
        else
            throw new IllegalArgumentException("Maximum amount of characters allowed is 256");
    }




//public void setValidDueDate()
    public  String setValidDueDate(int year, int month, int day){
        //the user will use this to set the due date of a new item object

        LocalDate date =  LocalDate.now();
            if( (year >= date.getYear()) &&
                    (month >= date.getMonthValue()) &&
                    (day >= date.getDayOfMonth()) )
            {
                String newDueDate = String.format("%d-%d-%d", year, month, day);
                return newDueDate;
            }
            else{
                System.err.printf("One of your inputs (year, month, or day) was not valid," +
                        "today's date will be used instead.");
                int nYear = date.getYear();
                int nMonth = date.getMonthValue();
                int nDay = date.getDayOfMonth();

                String today = String.format("%d-%d-%d", nYear, nMonth, nDay);

                return today;
            }
    }

    public  String setValidDueDate(){
        //the user will use this to set the due date of a new item object
        LocalDate date = LocalDate.now();

        int nYear = date.getYear();
        int nMonth = date.getMonthValue();
        int nDay = date.getDayOfMonth();

        String today = String.format("%d-%d-%d", nYear, nMonth, nDay);

        return today;

    }

    //public void editValidDueDate()
    public void editValidDueDate(int year, int month, int day){
        //the user will use this to edit the due date of an already existing item
        LocalDate date =  LocalDate.now();
        if( (year >= date.getYear()) &&
                (month >= date.getMonthValue()) &&
                (day >= date.getDayOfMonth()) )
        {
            String newDueDate = String.format("%d-%d-%d", year, month, day);
            this.dueDateString = newDueDate;
        }
        else{
            System.err.printf("One of your inputs (year, month, or day) was not valid," +
                    "today's date will be used instead.");
            int nYear = date.getYear();
            int nMonth = date.getMonthValue();
            int nDay = date.getDayOfMonth();

            String today = String.format("%d-%d-%d", nYear, nMonth, nDay);

            this.dueDateString = today;
        }
    }


    //public void markComplete()
    public void setComplete(){
        this.complete = true;
    }

    //public String getTitle()
    public String getTitle(){
        return this.title;
    }

    //public String getDescription()
    public String getDescription(){
        return this.description;
    }



    //public String getDueDate()
    public String getDueDate(){
        return this.dueDateString;
    }

    //public boolean getComplete()
    public boolean getComplete(){
        return this.complete;
    }

    //public void markIncomplete
    public void markIncomplete(){
        this.complete = false;
    }

//end Item class
}
