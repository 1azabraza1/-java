import java.util.*;

public class Main {
    //static public String str1;
    static String [] arab = new String[] {"100", "50", "10","1","2","3","4","5","6","7","8","9"};
    static String [] rome = new String[] {"C", "L", "X","I","II","III","IV","V","VI","VII","VIII","IX"};
    static List<String> romeList = Arrays.asList(rome);
    static List<String> arabList = Arrays.asList(arab);

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        String str1 = scan.nextLine();

        try {
            System.out.println(calc(str1));

        } catch (Exception e) {
            throw new Exception();
        }

    }
    public static String calc(String input) throws Exception{

        String[] str = input.split(" ");
        String number1 = str[0];
        String number2 = str[2];
        int prov = 0;

        List<String> arithmetic = Arrays.asList(new String[]{"+", "-", "/", "*"});
        if (!arithmetic.contains(str[1])) {
            throw new Exception();
        }
        if (!arabList.subList(2, arab.length).contains(number1) & !romeList.subList(2, rome.length).contains(number1)) {
            throw new Exception();
        }
        if (!arabList.subList(2, arab.length).contains(number2) & !romeList.subList(2, rome.length).contains(number2)) {
            throw new Exception();
        }
        if (str.length != 3) {
            throw new Exception();
        }

        if (romeList.contains(str[0]) & romeList.contains(str[2])) {
            number1 = convert(str[0]);
            number2 = convert(str[2]);
            prov = 1;
        }


        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        String finalOfNum;
        switch (str[1]) {
            case "+":
                finalOfNum = String.valueOf(num1 + num2);
                if (prov == 0) {
                    return finalOfNum;
                }
                else {
                    return finalAll(finalOfNum);
                }
            case "-":
                finalOfNum = String.valueOf(num1 - num2);
                if (prov == 0) {
                    return finalOfNum;
                }
                else {
                    return finalAll(finalOfNum);
                }
            case "/":
                finalOfNum = String.valueOf(num1 / num2);
                if (prov == 0) {
                    return finalOfNum;
                }
                else {
                    return finalAll(finalOfNum);
                }
            case "*":
                finalOfNum = String.valueOf(num1 * num2);
                if (prov == 0) {
                    return finalOfNum;
                }
                else {
                    return finalAll(finalOfNum);
                }
        }
        return "";
    }

    public static String trans(String input) {
        String finalOftrans = "";
        int x1 = Integer.parseInt(input) / 10;
        int x2 = Integer.parseInt(input) % 10;
        String num2 = "";
        if (x2 != 0){
            num2 = convert(String.valueOf(x2));
        }
        String num1 = convert(String.valueOf(x1));

        String[] num1OfSplit = num1.split("");

        for (int i=0; i<num1OfSplit.length; i++) {
            finalOftrans += convert(String.valueOf(Integer.parseInt(convert(num1OfSplit[i])) * 10));
        }

        return finalOftrans + num2;
    }

    public static String convert(String input) {
        String str = input;
        if (arabList.contains(str)) {
            return romeList.get(arabList.indexOf(str));
        }
        else {
            return arabList.get(romeList.indexOf(str));
        }
    }

    public static String finalAll (String input) {
        if (arabList.contains(input)) {
            return convert(input);
        }
        else {
            return trans(input);
        }
    }

}



