import java.util.Scanner;

public class calc {

    public static void main(String[] args) {
        Scanner virazh = new Scanner(System.in);
        System.out.print("Введите арифметическое выражение состоящее из двух арабских или римских чисел: ");
        String vvod = virazh.nextLine();
        String[] znaki = {"+", "-", "/", "*"};
        String[] znaki2 = {"\\+", "-", "/", "\\*"};   // экранированные знаки для сплита
        Converter conv = new Converter();
        //Определяем арифметическое действие:
        int dey = -777;
        for (int i = 0; i < znaki.length; i++) {
            if (vvod.contains(znaki[i])) {
                dey = i;
                break;
            }
        }
        int q2 = 0; // проверяем количество действий
        char a1 = '+';
        char a2 = '-';
        char a3 = '/';
        char a4 = '*';
        for (int z = 0; z < vvod.length(); z++) {
            if (vvod.charAt(z) == a1) {
                q2 = q2 + 1;
            }
            if (vvod.charAt(z) == a2) {
                q2 = q2 + 1;
            }
            if (vvod.charAt(z) == a3) {
                q2 = q2 + 1;
            }
            if (vvod.charAt(z) == a4) {
                q2 = q2 + 1;
            }
        }

        String[] mas = vvod.split(znaki2[dey]); // заполняем массив числами
        if (conv.isRoman(mas[0]) == conv.isRoman(mas[1])) {  //Определяем, находятся ли числа в одном формате
            int a, b;
            //Определяем, римские ли это числа
            boolean isRoman = conv.isRoman(mas[0]);
            if (isRoman) {
                //если римские, то конвертируем их в арабские
                a = conv.romanToInt(mas[0]);
                b = conv.romanToInt(mas[1]);
            } else {
                //если арабские, конвертируем их из строки в число
                a = Integer.parseInt(mas[0]);
                b = Integer.parseInt(mas[1]);
            }
            //выполняем выражение
            int otvet;
            switch (znaki[dey]) {
                case "+":
                    otvet = a + b;
                    break;
                case "-":
                    otvet = a - b;
                    break;
                case "*":
                    otvet = a * b;
                    break;
                default:
                    otvet = a / b;
                    break;
            }
            if (isRoman) {
                //если числа были римские, возвращаем результат в римском числе
                System.out.println(conv.intToRoman(otvet));
            } else {
                //если числа были арабские, возвращаем результат в арабском числе
                System.out.println(otvet);
            }
        } else {
            System.out.println("Ошибка");
        }
        if (q2 > 1) {
            System.out.println("Ошибка");
            return;
        }
    }
}