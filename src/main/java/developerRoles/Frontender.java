package developerRoles;

public class Frontender extends Developer implements FrontenderActions {
    @Override
    public void front() {
        System.out.println("Sleep");
    }

    @Override
    public void developGUI() {
        System.out.println("FrontEnder GUI method");
    }
}
