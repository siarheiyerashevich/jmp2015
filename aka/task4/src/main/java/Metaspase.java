import javassist.ClassPool;

/**
 * Created by TheFallen on 1/12/16.
 */
public class Metaspase {

    static ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) throws Exception{
        for (int i = 0; ; i++) {
            Class clas = classPool.makeClass("mentee.demo.Generated" + i).toClass();
        }
    }
}

