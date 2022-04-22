public class MainClass {
    /**
     *
     *
     * */

    public static String[] model = new String[10];

    public static void main(String[] Prince) {
        testAddTodoList();
    }
    //There are 3 business logic (show , add, remove), also 3 view (show , add, remove)
    /**
     * To show main menu from to do list
     * */
    public static void showTodoList(){
        for (var i = 0; i < model.length; i++){
            String todo = model[i];
            var no = i + 1;

            if ( todo != null){
                System.out.println(no + "." + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Learning Java Basic";
        model[1] = "Study case";

        showTodoList();
    }

    /**
     * To add from to do list
     * */
    public static void addTodoList(String todo){
        // check to see if there are null data or not first in model
        var isFull = true;
        for (var check = 0; check < model.length; check++) {
            if (model[check] == null) {
                // there are null data on model
                isFull = false;
                break;
            }
        }

        // if full, we resize array, this is logic to resize the model capacity
        if(isFull){
            var temp = model;
            model = new String[model.length * 2]; //If we do this then the data from before will gone, because we reset it

            for(int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        // add data to position which the data = null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
     for (int i = 0; i <25; i++){
         addTodoList("Contoh to do ke " + i);
     }

     showTodoList();
    }

    /**
     * To Remove from to do list
     * */
    public static void removeTodoList(Integer number){

    }

    /**
     * To view the main menu of to do list
     * */
    public static void viewShowTodoList(){

    }

    /**
     * To view the add of to do list
     * */
    public static void viewAddTodoList(){

    }

    /**
     * To view the remove of to do list
     * */
    public static void viewRemoveTodoList(){

    }
}
