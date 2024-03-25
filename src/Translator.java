import java.util.HashMap;

public class Translator {
    HashMap<Integer, String> numericAlpha = new HashMap<>();

    public Translator(int[] numeric, String[] alphabetic ) {
        for (int i = 0; i < alphabetic.length ; i++) {
            numericAlpha.put(numeric[i], alphabetic[i]);
        }
    }



    public String translate(Integer number) {
        return numericAlpha.get(number);
    }
}

