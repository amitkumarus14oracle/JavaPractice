package lambdaAndStreams;

public class LambdaWithRunnable {
    public static void main(String[] args) {
        Thread t;

        // below declarations creates new annonymous class
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running another Thread");
            }
        });
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running another Thread");
            }
        });
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running another Thread");
            }
        });
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running another Thread");
            }
        });

        //below declarations doesn't creates new annonymous class
        //uses invokeDynamic
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
        t = new Thread(()-> System.out.println("running another thread"));
    }
}
