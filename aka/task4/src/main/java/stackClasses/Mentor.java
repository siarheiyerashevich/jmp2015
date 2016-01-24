package stackClasses;

import stackClasses.Mentee;

/**
 * Created by TheFallen on 1/13/16.
 */
public class Mentor {

    private final String name;
    private final Mentee mentee;

    public Mentor(String name) {
        this.name = name;
        this.mentee = new Mentee("Superman");
    }

    @Override
    public String toString() {
        return "stackClasses.Mentor{"+ name + "}";
    }

}
