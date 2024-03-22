import java.util.Scanner;

public class FactorialExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("팩토리얼 산출 값을 입력하세요");
        int fact = sc.nextInt();

        Factorial d = new Factorial();

        System.out.println(d.calFac(fact));

    }
}

class Factorial {

    int calFac(int n) {
        if (n > 0)
            return n * calFac(n - 1);
        else
            return 1;
    }
}
