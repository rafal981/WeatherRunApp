import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledMailSender {

        public static void main(String [] args) {
            // Tworzenie harmonogramu
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            // Ustawienie harmonogramu na wysłanie maila codziennie o 6 rano
            scheduler.scheduleAtFixedRate(MailSender::sendMail, calculateInitialDelay(), 24 * 60 * 60, TimeUnit.SECONDS); // 24 * 60 * 60 sekund = 24 godziny

        }

        // Obliczenie opóźnienia początkowego do wysłania maila o 6 rano
        private static long calculateInitialDelay() {
            LocalTime now = LocalTime.now();
            LocalTime sendTime = LocalTime.of(6, 0); // Godzina wysłania maila
            long initialDelay = sendTime.toSecondOfDay() - now.toSecondOfDay();
            if (initialDelay < 0) {
                initialDelay += 24 * 60 * 60; // Jeśli jest po 6 rano, ustaw opóźnienie na następny dzień
            }
            return initialDelay;
        }
}
