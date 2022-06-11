package Second;

public class Second extends First {
    protected String a;

    public void methodInSecond() {
        System.out.println("Second");
        new First().methodInFirst();
    }
}
