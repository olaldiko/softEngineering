import java.util.Scanner;

/**
 * Created by gorkaolalde on 7/3/16.
 */
public class MyClass {
    public static void suma() {
        Scanner scanner = new Scanner(System.in);
        int primerSumando = scanner.nextInt();
        int segundoSumando = scanner.nextInt();
        System.out.print(primerSumando + segundoSumando);
    }
}