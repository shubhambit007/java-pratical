class Calculator {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        try {
            int addition = add(a, b);
            System.out.println("Addition Result: " + addition);

            int subtraction = subtract(a, b);
            System.out.println("Subtraction Result: " + subtraction);

            int  multiplication = multiply(a, b);
            System.out.println("Multiplication Result: " + multiplication);

            int  division = divide(a, b);
            System.out.println("Division Result: " + division);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int add(int a,int b) {
        return a+b;
    }

    public static int  subtract(int a,int b) {
        return a-b;
    }

    public static int  multiply(int a,int b) {
        return a*b ;
    }

    public static int  divide(int a,int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a/b;
    }
}

