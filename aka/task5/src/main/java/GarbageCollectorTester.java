import java.util.ArrayList;
import java.util.List;

// jvm params
// note: use java 1.7 version (1.8 is not complitable)
// 1) -XX:+UseSerialGC -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m
// 2) -XX:+UseParallelGC -Xms3m -Xmx12m -Xmn1m -XX:PermSize=40m -XX:MaxPermSize=40m
// 3) -XX:+UseParallelOldGC -Xms9m -Xmx18m -Xmn3m -XX:PermSize=40m -XX:MaxPermSize=40m
// 4) -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m
// 5) -XX:+UseG1GC -Xms4m -Xmx16m -Xmn2m -XX:PermSize=12m -XX:MaxPermSize=18m

class GarbageCollectorTester {
    public static void main(String[] args) {
        for (int i = 1; i >0 ; i++) {
            List<Integer> integerList = new ArrayList<>(i);
        }
    }
}