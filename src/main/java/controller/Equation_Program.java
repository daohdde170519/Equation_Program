package controller;

import Library.Check_Valid;
import static java.lang.System.exit;
import view.Menu;

/**
 *
 * @author DAO
 */
public class Equation_Program extends Menu<String> {
    private static String mc[] = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};
    Check_Valid ck;

    public Equation_Program() {
        super("Equation Program", mc);
        ck = new Check_Valid();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> superlativeEquation();
            case 2 -> quadraticEquation();
            case 3 -> exit(0);
            default ->
                System.out.println("Try again");
        }
    }

    // Hàm xuất danh sách số lẻ, chẵn, và số mà có căn bậc 2 nguyên
    private void printNumbers(String label, double... numbers) {
        System.out.print(label);
        for (double num : numbers) {
            if (ck.checkOdd(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Number is even: ");
        for (double num : numbers) {
            if (ck.checkEven(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Number is perfect square: ");
        for (double num : numbers) {
            if (ck.checkSquareNumber(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // Hàm tính và in kết quả cho phương trình bậc nhất
    public void superlativeEquation() {
        System.out.print("Enter A: ");
        double a = ck.checkInputDouble();
        System.out.print("Enter B: ");
        double b = ck.checkInputDouble();
        double x = -b / a;
        System.out.println("Solution: x=" + x);

        printNumbers("Number is odd: ", a, b, x);
    }

    // Hàm tính và in kết quả cho phương trình bậc hai
    public void quadraticEquation() {
        System.out.print("Enter A: ");
        double a = ck.checkInputDouble();
        System.out.print("Enter B: ");
        double b = ck.checkInputDouble();
        System.out.print("Enter C: ");
        double c = ck.checkInputDouble();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);

        printNumbers("Number is odd: ", a, b, c, x1, x2);
    }
}
