import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoding {
    private static String alhab = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static char decode(char symbol, int key) {

        if (alhab.indexOf(symbol) != -1) {
            int zero = alhab.indexOf(symbol) - key < 0 ? alhab.length() - Math.abs(alhab.indexOf(symbol) - key) : alhab.indexOf(symbol) - key;

            return alhab.charAt(Math.abs(zero));

        } else {
            return symbol;
        }

    }
    public static String decodCharToString(String address,int keyShifr) {
        String stringFile = EncryptionCaesar.convertingToString(address);
        String str = stringFile.toLowerCase();
        char[] charArray = new char[stringFile.length()];
        for (int i = 0; i < stringFile.length(); i++) {
            charArray[i] = Decoding.decode(str.charAt(i), keyShifr);
        }
        String charString = new String(charArray);
        return charString;
    }
    public static void newFileForDecodeText (String encryptedString,String addressFile) {

        try {
            Files.writeString(Path.of(addressFile), encryptedString);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }


    }

    public static void main(String[] args) {
        String text = "фхнжйч, инсе, мейёер ёрд";
        String str = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(decode(str.charAt(i), 5));
        }
    }

}
