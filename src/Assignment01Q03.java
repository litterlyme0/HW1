public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int numOdd = 0;
        int first = 1;
        int second = 1;

        for (int i = 0; i < x; i++) {
            int current = i == 0 || i == 1 ? 1 : first + second;

            if (i >= 2) {
                first = second;
                second = current;
            }

            System.out.print(current);
            if (i < x - 1) {
                System.out.print(" ");
            }

            if (current % 2 != 0) {
                numOdd++;
            }
        }
        System.out.println();
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
