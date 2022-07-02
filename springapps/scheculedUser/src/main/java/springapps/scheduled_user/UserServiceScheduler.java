package springapps.scheduled_user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
//later on we can disable on property if we have:
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class UserServiceScheduler {

    private final UserService userService;
    Logger log =  LoggerFactory.getLogger(UserServiceScheduler.class);

    public UserServiceScheduler(UserService userService) {
        this.userService = userService;
    }

    //    @Scheduled(fixedRate = 5000L) //starts the funtcion in every 5s, even if it is still running
    @Scheduled(fixedRateString = "${scheduling.fixedRate}") //string format is good, because you can use duration format
    // so every 10 Minutes = PT10M, hours = PT1H
    public void saveUserInEvery5Sec() {
        userService.save();
        System.out.println("User added at " + new Date());
    }


//    Be able to run recurring tasks asynchronously :
//same scheduling works only because of pool in yml

    // initialDelay --- after running app waits 6s then executes the function for the first time
//    @Scheduled(fixedDelay = 3000L) //  waits until it is finished, then waits 3s and starts
    @Scheduled(initialDelay = 6000L , fixedDelayString = "${scheduling.delay}")
    public void getUserInEvery5Sec() throws InterruptedException {
        List<User> users = userService.getAll();
        System.out.println("User list at " + new Date());
        System.out.println("Number of users: " + users.size());
        log.info("Users: {}", users);
        Thread.sleep(3000L); //function sleeps for 3s by every execution -- just to show how scheduled works
    }
    //    @Scheduled(cron = "15 * * * * *") //in every minute when it is minute:15s it is executed
    @Scheduled(cron = "${scheduling.cron}")
    public void getUserInEvery15Sec() {
        userService.deleteAll();
        List<User> users = userService.getAll();
        System.out.println("Number of users after delete: " + users.size());
        log.info("Users: {}", users);
    }
//cron =
//            "15 * * * * *"  in every minute when it is minute:15s it is executed, like 21:06:15
//            "*/15 * * * * *"  in every 15s it is executed, like 21:06:15, 21:06:30
//            "0 */5 * * * *"  in every 5 minutes it is executed, like 21:06:00, 21:11:00
//            "0 0 18 * * MON-FRI"  in every weekday at 18.00 it is  executed
//    crontab guru "*/5 * * * *"  no seconds  “At every 5th minute.”
}
