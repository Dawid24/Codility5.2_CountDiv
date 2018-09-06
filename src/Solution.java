import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Solution {

    public static int divK(int A, int B, int K) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new CountDivThread(A, (B - A) / 2 + A, K), 0, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new CountDivThread((B - A) / 2 + A, B + 1, K), 0, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        if (scheduledExecutorService.isShutdown()) {
            return CountDivUtils.CountDiv;
        } else return - 1;
    }
}
