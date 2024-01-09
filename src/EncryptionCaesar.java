import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncryptionCaesar {
    private static String alhab = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public EncryptionCaesar() {
    }

    public static String convertingToString(String address) {

        try {
            return new String(Files.readAllBytes(Paths.get(address)));
        } catch (IOException e) {
            System.out.println("Файла не существует, введите корректный адрес");
        }

        return address;
    }

    public static String EncrCharToString(String address,int keyShifr) {
        String stringFile = EncryptionCaesar.convertingToString(address);
        String str = stringFile.toLowerCase();
        char[] charArray = new char[stringFile.length()];
        for (int i = 0; i < stringFile.length(); i++) {
           charArray[i] = EncryptionCaesar.shift(str.charAt(i), keyShifr);
        }
        String charString = new String(charArray);
        return charString;
    }

    public static void newFileForShifr (String encryptedString,String addressFile) {

            try {
                Files.writeString(Path.of(addressFile), encryptedString);
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
    }

    public static char shift ( char symbol, int key){
            if (alhab.indexOf(symbol) != -1) {
                return alhab.charAt((alhab.indexOf(symbol) + key) % alhab.length());
            } else
                return symbol;
        }

    }

