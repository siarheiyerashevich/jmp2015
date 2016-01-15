
import stackClasses.Mentor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by TheFallen on 1/12/16.
 */
// jvm params of start -XX:NewSize=3m -XX:MaxNewSize=3m -Xmx10m
public class StackOverflow {

    public static void main(String[] args) {
        Mentor firstMentor = new Mentor("The Best One");
        System.out.println(firstMentor);
    }
}
