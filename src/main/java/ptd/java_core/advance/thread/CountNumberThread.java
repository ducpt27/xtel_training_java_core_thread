package ptd.java_core.advance.thread;

public class CountNumberThread extends Thread {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            count++;
            if (count > 100) {
                count = 0;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
