import main.ManagerEmploy;
import utils.Validate;
import model.Employ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {

        //init
        List<Employ> employList = new ArrayList<>();
        ManagerEmploy mn = new ManagerEmploy(employList);
        Scanner scanner = new Scanner(System.in);
        String choice;

        //input employ
        do {
            mn.addEmploy();
            do {
                choice = Validate.getString(scanner, "Enter a next Student(Y/N)?:");
                choice = choice.toLowerCase();
            } while (!((choice.equals("y")) || (choice.equals("n"))));
        } while (choice.equals("y"));

        // show list employ
        mn.showAllStudentList();
        // show Employee's average salary
        System.out.println("Employee's average salary:  "+mn.calculateAverageSalary());
        //show employees whose salary is lower than average salary
        mn.showListEmploySalaries();

    }
}
