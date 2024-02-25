import java.util.Arrays;

class randomprime {
    public static void main(String[] args) {
        int[] number = new int[10000];
        int count = 0;

        for (int i = 0; i < number.length; i++) {
            int nanotime = (int) (System.nanoTime() % 9999) + 1;
            number[i] = nanotime;
        }

        for (int i = 0; i < number.length; i++) {
            int flag = 0; 

            if (number[i] == 0 || number[i] == 1) {
                flag = 1; 
            }

            for (int j = 2; j <= number[i] / 2; j++) {
                if (number[i] % j == 0) {
                    flag = 1; 
                    break;
                }
            }

            if (flag == 0) {
                System.out.println(number[i]);
                count++;
            }
        }

        System.out.println("Total prime number is: " + count);
    }
}
