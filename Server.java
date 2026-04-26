import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(
                    "SimpleAdapter", "default -p 5678"
            );

            adapter.add(new PrinterI(), Util.stringToIdentity("SimplePrinter"));
            adapter.activate();

            System.out.println("Servidor Java rodando na porta 5678...");
            communicator.waitForShutdown();

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}