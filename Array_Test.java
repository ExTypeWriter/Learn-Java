import java.util.Scanner;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Array_Test {
    public static class DVD {
        public String name;
        public int releaseYear;
        public String director;

        public DVD(String name, int releaseYear, String director) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.director = director;
        }

        public String toString() {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            return formatter.format(date) + " " + this.name + ", directed by " + this.director + ", released in "
                    + this.releaseYear;
        }

    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        boolean end_of_program = false;
        while (end_of_program == false) {
            System.out.println("DVD Manager");
            System.out.println("Enter 1 to store new DVD.");
            System.out.println("Enter 2 to show all current DVD.");
            System.out.println("Enter 0 or Exit to exit the program.");
            System.out.print("Your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "0":
                case "exit":
                case "Exit":
                    System.out.print("\033[H\033[2J");  
                    System.out.println("Thanks for using our program.");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        // Handle the exception here (e.g., print an error message)
                        e.printStackTrace();
                    }
                    System.out.print("\033[H\033[2J");  
                    end_of_program = true;
                    break;
                case "1":
                    FileWriter file = null;
                    try {
                        file = new FileWriter("log.txt", true);
                        System.out.print("Input numbers of dvd you want to store : ");
                        int number_of_dvd = sc.nextInt();
                        sc.nextLine();
                        DVD[] BoxSet = new DVD[number_of_dvd]; // Move BoxSet declaration and initialization here
                        int i = 0;
                        while (i < number_of_dvd) {
                            System.out.print("Title of #" + (i + 1) + " DVD : ");
                            String name = sc.nextLine();
                            System.out.print("Director of #" + (i + 1) + " DVD : ");
                            String director = sc.nextLine();
                            System.out.print("Publish year of #" + (i + 1) + " DVD : ");
                            int releaseYear = sc.nextInt();
                            sc.nextLine();
                            BoxSet[i] = new DVD(name, releaseYear, director);
                            i++;
                        }
                        for (DVD dvd : BoxSet) {
                            file.write(dvd.toString() + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (file != null) {
                                file.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "2":
                    try {
                        System.out.print("\033[H\033[2J"); 
                        int allcount = 0; 
                        File myObj = new File("log.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                            allcount++;
                        }
                        System.out.println("Current number of DVD : "+allcount);
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");  
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
            }
        }
        sc.close();
    }
}