import stackClasses.Mentee;
import stackClasses.Mentor;

/**
 * Created by TheFallen on 1/12/16.
 */
// jvm params of start -XX:NewSize=3m -XX:MaxNewSize=3m -Xmx3m -Xss15m
public class HeapSpace {

    public static void main(String[] args) {
        Mentor firstMentor = new Mentor("The Best One");
        System.out.println(firstMentor);
    }
}
