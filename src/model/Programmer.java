package model;

import utils.Validate;

import java.util.List;
import java.util.Scanner;

public class Programmer extends Employ {
    private int overtimeHours;

    public Programmer() {
        super();
    }

    public Programmer(String employeeCode, String fullName, int age, String phoneNumber, String email, float basicSalary, int overtimeHours) {
        super(employeeCode, fullName, age, phoneNumber, email, basicSalary);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double countSalary() {
        return getBasicSalary() + getOvertimeHours()*400.000;
    }

    @Override
    public void inputEmploy() {}

    @Override
    public void inputEmploy(List<Employ> employList) {
        Scanner scanner = new Scanner(System.in);
        boolean checkID;
        do {
            checkID = true;
            setEmployeeCode(Validate.getString(scanner,"Enter Employ code:"));

            for (Employ ep : employList) {
                if (ep.getEmployeeCode().equalsIgnoreCase(getEmployeeCode())){
                    System.out.println("The ID is available");
                    checkID = false;
                    break;
                }
            }
        } while (!checkID);
        setFullName(Validate.getString(scanner, "Enter name employ: "));
        setAge(Validate.getInt(scanner, "Enter age employ: "));
        setPhoneNumber(Validate.getPhone(scanner, "Enter phone Number employ: "));
        setEmail(Validate.getEmail(scanner, "Enter email employ: "));
        setBasicSalary(Validate.getFloat(scanner, "Enter basic Salary employ: "));
        this.overtimeHours = Validate.getInt(scanner,"Enter over timeHours: ");
    }

    @Override
    public String toString(){
        return super.toString() + "Overtime Hours: " + this.overtimeHours;
    }

}
