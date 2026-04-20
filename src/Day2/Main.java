package Day2;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("first_name :");
        String first_name = sc.nextLine();
        System.out.print("last_name :");
        String last_name = sc.nextLine();
        System.out.print("gender :");
        String gender = sc.nextLine();
        System.out.print("age :");
        int age = sc.nextInt();
        System.out.print("weight :");
        double weight = sc.nextDouble();
        Details details = new Details(first_name, last_name, gender, age, weight);
        System.out.println(details);
    }
}