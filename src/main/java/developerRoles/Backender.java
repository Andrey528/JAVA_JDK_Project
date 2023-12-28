package developerRoles;

public class Backender extends Developer implements BackenderActions {
    @Override
    public void back() {
        System.out.println("BackEnd working");
    }

    @Override
    public void developGUI() {
        System.out.println("BackEnder GUI method");
    }
}
