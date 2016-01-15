package stackClasses;

/**
 * Created by TheFallen on 1/13/16.
 */
public class Mentee {

    private final String name;
    private final Mentor mentor;

    public Mentee(String name) {
        this.name = name;
        this.mentor = new Mentor("Thor");
    }

    public Mentee() {
        this.name = "name";
        this.mentor = null;
    }

    @Override
    public String toString() {
        return "stackClasses.Mentee{"+ name + "}";
    }
}
