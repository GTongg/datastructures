
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class MyReadFile {
    public static void main(String[] args) {
        try {
            int[] scores = new int [46];
            int i = 0;
            Scanner scan = new Scanner(new File("score.txt"));
            while (scan.hasNextInt()) {
                scores[i] = scan.nextInt();
                i++;
            }
            System.out.println(Arrays.toString(scores));
//        System.out.print("請輸入一行字串: ");
//        String line = scan.nextLine();
//        System.out.printf("你輸入的是: %s\n", line);
//        String[] words=line.split(" ");
//        System.out.println(Arrays.toString(words));
        } catch (FileNotFoundException ex) {
            System.err.printf("File reading error: %s\n", ex.getMessage());
        }
    }
}
