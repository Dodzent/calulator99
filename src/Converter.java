import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> rimKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();

    public Converter() {
        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");

        rimKeyMap.put('i', 1);
        rimKeyMap.put('v', 5);
        rimKeyMap.put('x', 10);
        rimKeyMap.put('I', 1);
        rimKeyMap.put('V', 5);
        rimKeyMap.put('X', 10);
    }
    public boolean isRoman(String number){
        return  rimKeyMap.containsKey(number.charAt(0));
    }
    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabKeyMap.floorKey(number);
            roman += arabKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int otvet =  rimKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian =  rimKeyMap.get(arr[i]);

            if (arabian <  rimKeyMap.get(arr[i + 1])) {
                otvet -= arabian;
            } else {
                otvet += arabian;
            }
        }
        return otvet;
    }
}