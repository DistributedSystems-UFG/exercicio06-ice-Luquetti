import com.zeroc.Ice.Current;

public class PrinterI implements Demo.Printer {

    @Override
    public String printString(String s, Current current) {
        System.out.println("printString: " + s);
        return "Printed: " + s;
    }

    @Override
    public String toUpperCase(String s, Current current) {
        System.out.println("toUpperCase: " + s);
        return s.toUpperCase();
    }

    @Override
    public int countWords(String s, Current current) {
        System.out.println("countWords: " + s);
        return s.trim().isEmpty() ? 0 : s.trim().split("\\s+").length;
    }
}