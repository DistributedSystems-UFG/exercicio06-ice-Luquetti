import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -h 98.90.53.6 -p 5678");
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            // Método original
            String response = printer.printString("Hello from Goiania!");
            System.out.println("Server responded: " + response);

            // Novos métodos
            String upper = printer.toUpperCase("sistemas distribuídos");
            System.out.println("toUpperCase: " + upper);

            int words = printer.countWords("quantas palavras tem essa frase");
            System.out.println("countWords: " + words);

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}