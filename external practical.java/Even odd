public class EvenOddSync {
    static class Printer {
        private int num = 1;
        private final int limit = 15;
        private boolean oddTurn = true;

        synchronized void printOdd() {
            while (num <= limit) {
                while (!oddTurn) {
                    try { wait(); } catch (Exception e) {}
                }
                if (num <= limit) System.out.println(num++);
                oddTurn = false;
                notify();
            }
        }

        synchronized void printEven() {
            while (num <= limit) {
                while (oddTurn) {
                    try { wait(); } catch (Exception e) {}
                }
                if (num <= limit) System.out.println(num++);
                oddTurn = true;
                notify();
            }
        }
    }

    static class OddThread extends Thread {
        Printer p;
        OddThread(Printer p) { this.p = p; }
        public void run() { p.printOdd(); }
    }

    static class EvenThread extends Thread {
        Printer p;
        EvenThread(Printer p) { this.p = p; }
        public void run() { p.printEven(); }
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        new OddThread(p).start();
        new EvenThread(p).start();
    }
}
