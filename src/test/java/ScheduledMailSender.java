import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledMailSender {

        public static void main(String [] args) {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            scheduler.scheduleAtFixedRate(MailSender::sendMail, calculateInitialDelay(), 24 * 60 * 60, TimeUnit.SECONDS);

        }

        private static long calculateInitialDelay() {
            LocalTime now = LocalTime.now();
            LocalTime sendTime = LocalTime.of(6, 0);
            long initialDelay = sendTime.toSecondOfDay() - now.toSecondOfDay();
            if (initialDelay < 0) {
                initialDelay += 24 * 60 * 60;
            }
            return initialDelay;
        }
}
