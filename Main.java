import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.Objects;
public class  Main {
    public static void main(String[] args) throws IOException {
        String operation = null;
        int result = 0;
        int num1 = 0;
        int num2 = 0;
        boolean r = false;
        boolean f = false;
        String[] roman = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите математическое выражение через пробел");
        String text = br.readLine();
        String[] text1 = text.split(" ");
        if (text1.length != 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)(Вводить нужно через пробел)");
                return;
            }
        }
        for (int i = 0; i < roman.length; i++) {
            if (Objects.equals(text1[0], roman[i])) {
                text1[0] = String.valueOf(i);
                r = true;
            }
            if (Objects.equals(text1[2], (roman)[i])) {
                text1[2] = String.valueOf(i);
                f = true;
            }
        }
        if (!Objects.equals(f, r)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("используются одновременно разные системы счисления");
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                try {
                    parseInt(text1[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Введенный символ не является целым числом");
                    return;
                }
                num1 = parseInt(text1[0]);
                if ((num1 < 0 || num1 > 10)) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("ВВеденное число не входит в промедуток от 1 до 10");
                        return;
                    }
                }
            }
            if (i == 1) {

                if ((text1[1].equals("-") || (text1[1].equals("+")) || (text1[1].equals("/")) || (text1[1].equals("*")))) {
                    operation = String.format(text1[1]);
                } else {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Введенное математичексое выражение неверно");
                        return;
                    }
                }
            }
            if (i == 2) {
                try {
                    parseInt(text1[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Введенный символ не является целым числом");
                    return;
                }
                num2 = parseInt(text1[2]);
                if ((num2 < 0 || num2 > 10)) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("ВВеденное число не входит в промедуток от 1 до 10");
                        return;
                    }
                }
            }
        }
        switch (Objects.requireNonNull(operation)) {
            case "+" -> result = (num1 + num2);
            case "-" -> result = (num1 - num2);
            case "/" -> result = (num1 / num2);
            case "*" -> result = (num1 * num2);
        }
        String m;
        if (f) {
            if (result < 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Резултат операции с римскими цифрами не может быть меньше 0");
                    return;
                }
            }
            m = String.valueOf(result);
            m = roman[parseInt(m)];
            System.out.println(m);
        } else {
            System.out.println(result);
        }
    }
}