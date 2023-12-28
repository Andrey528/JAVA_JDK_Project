package developerRoles;

public class Fullstacker extends Developer implements BackenderActions, FrontenderActions {
    @Override
    public void back() {

    }

    @Override
    public void front() {

    }

    @Override
    public void developGUI() {
        System.out.println("FullStack GUI method");
    }
}
