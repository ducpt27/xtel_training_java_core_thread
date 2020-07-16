package ptd.java_core.advance.thread.shutdown_hook;

public class TestShutdown {

    public static void main(String[] args) throws Exception {

        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shut down hook task completed..");
            }
        });

        System.out.println("Now main sleeping...");
        Thread.sleep(3000);
    }
}