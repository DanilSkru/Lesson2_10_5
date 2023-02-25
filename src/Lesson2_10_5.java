import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Lesson2_10_5 {
    public static void main(String[] args) throws IOException {
        File file_in = new File("forcalc.txt");
        Scanner sc = new Scanner(file_in);
        String text = sc.nextLine();
        String[] elements = text.split(" ");
        double a = 0, b = 0;
        String operator = null;
        String answer = null;
        try {
            a = Double.parseDouble(elements[0]);
            b = Double.parseDouble(elements[2]);
            operator = elements[1];
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/"))
                throw new Exception("Operation Error!");
            if (operator.equals("/") && Math.abs(b) < 2 * Double.MIN_VALUE)
                throw new Exception("Error! Division by zero");
            switch (operator) {
                case "+":
                    answer = String.valueOf(a + b);
                    break;
                case "-":
                    answer = String.valueOf(a - b);
                    break;
                case "*":
                    answer = String.valueOf(a * b);
                    break;
                case "/":
                    answer = String.valueOf(a / b);
                    break;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Error! Not number");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        File file_out = new File("outcalc.txt");
        FileWriter writer = new FileWriter(file_out);
        writer.write(answer);
        writer.flush();
        writer.close();
    }
}