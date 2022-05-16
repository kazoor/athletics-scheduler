package ClientInput;
import java.util.*;
import com.opencsv.CSVReader;
import java.io.FileReader;


public class ClientInput {
    public static void Menu() {
        System.out.println("Working!");
        int choice;
        String fileName;
        boolean rep = true;
        Scanner sc = new Scanner(System.in);
        while(rep){
            System.out.println("Client Menu");
            System.out.println("1. Input Schedule path");
            System.out.println("2. View schedule");
            System.out.println("3. Lorem ipsum schedule");
            System.out.println("Enter choice(1-3): ");

            choice=sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter path to CSV file: ");
                    fileName = sc.next();
                    System.out.println(fileName);
                    try(CSVReader reader = new CSVReader(new FileReader(fileName))){
                        System.out.println("CSV file found!");
                        rep = false;
                    }catch(Exception e){
                        System.out.println("CSV file not found try again\n");
                    }
                }
                case 2 -> {
                    System.out.println("View schedule");
                    rep = true;
                }
                case 3 -> {
                    System.out.println("Lorem");
                }
            }
        }
    }
    void Run(){
        try{
            Menu();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}