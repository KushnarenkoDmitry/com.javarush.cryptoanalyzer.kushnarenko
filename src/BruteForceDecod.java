import java.util.Scanner;

public class BruteForceDecod {
    private static String alhab = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public BruteForceDecod(){}

    public static String decodeBruFor(String address) {
        String stringFile = EncryptionCaesar.convertingToString(address);
        String str = address.toLowerCase();

        for (int i = 0; i < 33; i++) {
            char[] charArray = new char[str.length()];
            for (int j = 0; j <str.length(); j++) {
                charArray[j] = Decoding.decode(str.charAt(j), i);
            }
            String charArrayToString = new String(charArray);
            System.out.println(i + 1 + " Вариант: " + charArrayToString);
            System.out.println("Этот вариант подошел?\nЕсли да нажмите 1\nЕсли нет нажмите 2");
            Scanner concole = new Scanner(System.in);
            int yesNo = concole.nextInt();
            if (yesNo == 1){
                return new String(charArray);
            }
        }return "vse";

    }

    public static void main(String[] args) {
        String s = "фхнжйч сйтд мужшч пшэтехйтпу иснчхно фйчхужнь!";


        String decode = decodeBruFor(s);
        System.out.println(decode);
        Decoding.newFileForDecodeText(decode,"C:\\Users\\Toshiba\\Desktop\\new.txt");

    }
}
