import java.time.ZonedDateTime;

/**
 * @author liao 2021/9/27
 */
public class TimeTest {
    public static void main(String[] args) {
        //2021-09-27T10:13:34.444+08:00[Asia/Shanghai]
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);
    }
}
