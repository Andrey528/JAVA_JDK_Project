package developerRoles;

public interface FrontenderActions {
    void front();
    default void coffee() {
        System.out.println("Drink");
    };
}
