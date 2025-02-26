import java.util.Scanner;

public class LearnSwitch {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        boolean endProgram = false;
        while(endProgram != true){
            System.out.print("Input day in week start with capital letter else are lowercase , Only one day of a week will let you out!: ");
            String day = sc.nextLine(); String message = switch(day)
            {
                case "Monday" -> {
                    endProgram = true;
                    yield "The workday has begun. And now you're out!";
                }
                case "Tuesday" -> "4 days left";
                case "Wednesday" -> "That's nice half way through";
                case "Thursday" -> "Now that's tough";
                case "Friday" -> "Almost there...";
                case "Saturday" -> "Nice.";
                case "Sunday" -> "For fuck sake.. now the cycle begin." ;
                default -> "Wrong format : Only day start with capital and else lowercase.";
            };
            System.out.println(message);
        }
        sc.close();
    } 
}
