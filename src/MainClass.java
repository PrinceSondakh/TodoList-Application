import java.sql.SQLOutput;

public class MainClass {
    /**
     *
     *
     * */

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] Prince) {
        testViewAddTodoList();
    }
    //There are 3 business logic (show , add, remove), also 3 view (show , add, remove)
    /**
     * To show main menu from to do list
     * */
    public static void showTodoList(){
        System.out.println("TODOLIST");
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
     * To Remove from to do list (*the LOGIC)
     * */
    public static boolean removeTodoList(Integer number){ //logic
        if((number - 1) >= model.length){ //Check if number-1 more than array length
            return false; //not valid
        } else if (model[number - 1] == null) { //check the data in the index null or not, (kalau sblmnya tdk ada datanya)
            return false;
        } else { /** logic UNTUK MENGGESER ANGKA =================================== bro*/
            for (int i = (number - 1); i < model.length; i++){
                if(i == (model.length - 1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info +" : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * To view the main menu of to do list
     * */
    public static void viewShowTodoList(){
        while(true){ //dilakukan perulangan agar tidak berhenti sekali
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if(input.equals("1")){ //Komparasi biasa number / ==... string yaitu equals
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    /**
     * To view the add of to do list
     * */
    public static void viewAddTodoList(){
        System.out.println("ADD TO DO LIST");

        var todo = input("Todo (x Jika Batal)");

        if(todo.equals("x")){
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();

        showTodoList();
    }

    /**
     * To view the remove of to do list
     * */
    public static void viewRemoveTodoList(){
        System.out.println("DELETING TODOLIST");

        var number = input("Delete number that you wish (x Jika Batal)");

        if(number.equals("x")){
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }
}



