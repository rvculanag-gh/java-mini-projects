import java.util.ArrayList;
import java.util.List;

public class AsciiToBinary {
    public String charToBinary(char letter) {
        String[] binaryArray = new String[]{"0", "0", "0", "0", "0", "0", "0", "0"};

        byte position = 0;
        short divider = 128;

        if (letter % 2 != 0) {
            binaryArray[binaryArray.length - 1] = "1";
            letter -= 1;
        }

        while (letter > 0) {
            if (letter >= divider) {
                binaryArray[position] = "1";
                letter -= divider;
            }

            position += 1;
            divider /= 2;
        }

        return String.join("", binaryArray);
    }

    public List<String> wordToBinary(String word) {
        var words = new ArrayList<String>();

        for (var letter : word.toCharArray()) {
            var binary = charToBinary(letter);
            var format = letter + " - " + binary;

            words.add(format);
        }

        return words;
    }

    public static void main(String[] args) {
        var converter = new AsciiToBinary();
        var converted = converter.wordToBinary("hello");

        converted.forEach(System.out::println);
    }
}
