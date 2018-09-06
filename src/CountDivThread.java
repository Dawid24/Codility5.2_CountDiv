public class CountDivThread implements Runnable {

    public int startThread;
    public int endThread;
    public int div;

    public CountDivThread(int startThread, int endThread, int div) {
        this.startThread = startThread;
        this.endThread = endThread;
        this.div = div;
    }

    @Override
    public void run() {
        for (int i = startThread; i < this.endThread; i++) {
            if (i % div == 0) {
                synchronized (CountDivUtils.class) {
                    CountDivUtils.CountDiv++;
                }
            }
        }
    }
}
