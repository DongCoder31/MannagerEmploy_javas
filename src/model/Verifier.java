package model;

import utils.Validate;

import java.util.List;
import java.util.Scanner;

public class Verifier extends Employ {
    private int errorNumbeDetected;

    public Verifier() {
        super();
    }

    public Verifier(String employeeCode, String fullName, int age, String phoneNumber, String email, float basicSalary, int errorNumbeDetected) {
        super(employeeCode, fullName, age, phoneNumber, email, basicSalary);
        this.errorNumbeDetected = errorNumbeDetected;
    }

    public int getErrorNumbeDetected() {
        return errorNumbeDetected;
    }

    public void setErrorNumbeDetected(int errorNumbeDetected) {
        this.errorNumbeDetected = errorNumbeDetected;
    }

    @Override
    public double countSalary() {
        return getBasicSalary() + getErrorNumbeDetected()*150.000;
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
        setPhoneNumber(Validate.getPhone(scanner, "Enter phone number employ: "));
        setEmail(Validate.getEmail(scanner, "Enter email employ: "));
        setBasicSalary(Validate.getFloat(scanner, "Enter basic salary employ: "));
        this.errorNumbeDetected = Validate.getInt(scanner,"Enter error numbe detected: ");
    }

    @Override
    public String toString(){
        return super.toString() + "Error Numbe Detected: " + this.errorNumbeDetected;
    }
}
