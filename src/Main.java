import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        // объявляем переменные
        final String Sum = "+";
        final String Minus = "-";
        final String Mult = "*";
        final String Div = "/";
        String resultRoman;
        int value1;
        int value2;

        Scanner scanner = new Scanner(System.in); // создаем сканер с функией записи
        String inp = scanner.nextLine(); // сканируем запись пользователя
        String[] array = inp.split(" "); // массив для обраотки вводных

        if (array.length == 1){throw new RuntimeException("is not a mathematical operation");}
        if (array.length > 3){throw new RuntimeException("the format of the mathematical operation does not satisfy the task - two operands and one operator (+, -, /, *)");}

        String operator = array[1];



        try {
            value1 = Integer.parseInt(array[0]); //первый операнд
            value2 = Integer.parseInt(array[2]); //второй операнд
            //создали проверку чтобы число было не меньше 0 и не больше 10
            if (value1 > 10 || value1 < 0 || value2 > 10 || value2 < 0) {
                throw new RuntimeException("a number greater than 10 or less than zero");
            }

            // определяем оператор, проводим операцию,вывод результата
            switch (operator) {
                case Sum:
                    System.out.println(value1 + value2);
                    break;
                case Minus:
                    System.out.println(value1 - value2);
                    break;
                case Mult:
                    System.out.println(value1 * value2);
                    break;
                case Div:
                    System.out.println(value1 / value2);
                    break;
            }

        } catch (NumberFormatException exception) {
            String RomeValue1 = array[0];
            String RomeValue2 = array[2];
            if (digit(RomeValue1) > 10 || digit(RomeValue1) < 0 || digit(RomeValue2) > 10 || digit(RomeValue2) < 0) {
                throw new RuntimeException();

            }

            int result = 0;
            switch (operator) {
                case Sum:
                    result = digit(RomeValue1) + digit(RomeValue2);
                    break;
                case Minus:
                    result = digit(RomeValue1) - digit(RomeValue2);
                    break;
                case Mult:
                    result = digit(RomeValue1) * digit(RomeValue2);
                    break;
                case Div:
                    result = digit(RomeValue1) / digit(RomeValue2);
                    break;



            }
            if (Math.signum(result)==-1){throw new RuntimeException("there are no negative numbers in the roman system");}
            System.out.println(romearray(result));



        }
    }
        //метод для определения римской цифры
        public static int digit (String x){
            if (x.equals("I")){return 1;}
            if (x.equals("II")){return 2;}
            if (x.equals("III")){return 3;}
            if (x.equals("IV")){return 4;}
            if (x.equals("V")){return 5;}
            if (x.equals("VI")){return 6;}
            if (x.equals("VII")){return 7;}
            if (x.equals("VIII")){return 8;}
            if (x.equals("IX")){return 9;}
            if (x.equals("X")){return 10;}
            else{throw new RuntimeException("different number systems are used at the same time or characters cannot be recognized.");}

        }

        // метод для получения окончательного результата
        public static String romearray ( int number){
            String[] array = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX","LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            final String res = array[number-1];
            return res;

        }
    }
