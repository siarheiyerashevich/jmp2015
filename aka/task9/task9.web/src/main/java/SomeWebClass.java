/**
 * Created by TheFallen on 2/25/16.
 */
public class SomeWebClass {

    private String text;

    public SomeWebClass() {
        SomeService someService = new SomeServiceImpl();
        this.text = someService.getSomeText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
