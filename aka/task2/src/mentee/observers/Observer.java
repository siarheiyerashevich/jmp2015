package mentee.observers;

import mentee.Subject;

/**
 * Created by TheFallen on 08.12.15.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
