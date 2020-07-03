import java.io.*;
import java.util.Scanner;

public class ToDo {

    private void printOutTasks(File tasks){
        System.out.println("Your previous tasks:\n");

        try{
            Scanner fileScanner = new Scanner(tasks);
            while(fileScanner.hasNext()){
                System.out.println(fileScanner.nextLine());
            }

            System.out.println("\n-----------------------------------");
        }catch (FileNotFoundException error){
            System.out.println("That file doesn't exists.");
        }
    }


    private void writeToFile(){
        try(FileWriter writer = new FileWriter("tasks.txt",true)){
            try(BufferedWriter fileWriter = new BufferedWriter(writer)){
                Scanner input = new Scanner(System.in);
                System.out.println("Add the task please! (Write exit to escape)");
                String inputTask =  input.nextLine();

                while(!inputTask.toLowerCase().equals("exit")){
                    if(inputTask.equals("")){
                        System.out.println("Was that a miss click? You cannot save empty task! Try again!");
                    }else{
                        fileWriter.write("-  " + inputTask);
                        fileWriter.newLine();

                        System.out.println("task added to your TODO list.\n\n");
                    }

                    System.out.println("Add the task please! (Write exit to escape)");
                    inputTask =  input.nextLine();
                }
            }
        }catch (IOException error){
            System.out.println("An error occured! " + error);
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome in your TODO program!\n\n\n");

        try {
            File tasks = new File("tasks.txt");
            if (!tasks.exists()) {
                tasks.createNewFile();
            }else{
                ToDo toDo = new ToDo();
                toDo.printOutTasks(tasks);
            }
            ToDo toDo = new ToDo();
            toDo.writeToFile();
        } catch (IOException error){
            System.out.println("An error occured! " + error);
        }
    }
}
