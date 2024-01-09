import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Что нужно сделать?\nЗашифровать - 1\nДешифрование - 2\nРасшифровка brute force - 3");
        System.out.println("Ввдите число соответствующее вашему запросу:");
        int a = console.nextInt();
        if (a == 1) {

            System.out.println("Адрес файла для шифрования");
            boolean isRegularFileIn = false;
            String addressOriginal = null;
            while (!(isRegularFileIn)) {
                addressOriginal = console.next();
                if (Files.isRegularFile(Path.of(addressOriginal))) {
                    isRegularFileIn = true;
                } else {
                    System.err.println("Фаил не найдет, введите корректный путь к файлу");
                }
            }

            System.out.println("Введитесь адрес файла куда сохранить зашифрованный текст");
            boolean isRegularFileOut = false;
            String addressEncrStringOut = null;
            while (!isRegularFileOut) {
                addressEncrStringOut = console.next();
                if (Files.isRegularFile(Path.of(addressEncrStringOut))) {
                    isRegularFileOut = true;
                } else {
                    System.err.println("Фаил не найдет, введите корректный путь к файлу");
                }
            }
            System.out.println("Введите ключ");
            int keyShifr = Math.abs(console.nextInt());
            String charToStr = EncryptionCaesar.EncrCharToString(addressOriginal, keyShifr);
            System.out.println("Ваш результат: " + charToStr);
            EncryptionCaesar.newFileForShifr(charToStr, addressEncrStringOut);
        } else if (a == 2) {

            System.out.println("Введите адрес файла с зашифрованным тектом");
            boolean isRegularFileOut = false;
            String encrText = null;
            while (!isRegularFileOut) {
                encrText = console.next();
                if (Files.isRegularFile(Path.of(encrText))) {
                    isRegularFileOut = true;
                } else {
                    System.err.println("Фаил не найден, введите корректный путь к файлу");
                }
            }
            System.out.println("Введите адрес файла куда сохранить расшифрованный текст");
            boolean isRegularFileIn = false;
            String deCodeNewAddresFile = null;
            while (!isRegularFileIn) {
                deCodeNewAddresFile = console.next();
                if (Files.isRegularFile(Path.of(deCodeNewAddresFile))) {
                    isRegularFileIn = true;
                } else {
                    System.err.println("Фаил не найден, введите корректный путь к файлу");
                }
            }

            System.out.println("Введите ключ расшифровки");
            int keyShifr = Math.abs(console.nextInt());
            String decodString = Decoding.decodCharToString(encrText, keyShifr);
            System.out.println("Ваш результат: " + decodString);
            Decoding.newFileForDecodeText(decodString, deCodeNewAddresFile);
        } else if (a == 3) {
            System.out.println("Введите адрес файла с зашифрованным тектом");

            boolean isRegularFileIn = false;
            String encrText = null;
            while (!isRegularFileIn) {
                encrText = console.next();
                if (Files.isRegularFile(Path.of(encrText))) {
                    isRegularFileIn = true;
                } else {
                    System.err.println("Фаил не найден, введите корректный путь к файлу");

                }
            }
            System.out.println("Введите адрес файла куда сохранить расшифрованный текст");
            boolean isRegularFileOut = false;
            String decodeNewAddress = null;
            while (!isRegularFileOut){
                decodeNewAddress = console.next();
                if (Files.isRegularFile(Path.of(decodeNewAddress))){
                    isRegularFileOut = true;
                }else {
                    System.err.println("Фаил не найден, введите корректный путь к файлу");

                }
            }
            String filecode = EncryptionCaesar.convertingToString(encrText);
            String bruteForce = BruteForceDecod.decodeBruFor(filecode);
            System.out.println("Ваш результат: " + bruteForce);
            Decoding.newFileForDecodeText(bruteForce, decodeNewAddress);


        } else {
            System.err.println("Не корректо введен запрос, попробуйте заного\nПодсказка ведите 1-2-3");
        }
    }


}









