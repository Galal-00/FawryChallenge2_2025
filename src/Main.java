public class Main {
    public static void main(String[] args) {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";

        for (int i = 0; i < Testing.tests.length; i++){
            System.out.printf(YELLOW + "Running Testcase %d:" + RESET + "%n", i + 1);
            try {
                Testing.tests[i].run();
                System.out.printf(GREEN + "Test %d passed." + RESET + "%n", i + 1);
            }
            catch (Exception e){
                System.out.printf(RED + "Test %d failed: %s" + RESET + "%n", i + 1, e.getMessage());
            }
            System.out.println("==============================");
        }
    }
}