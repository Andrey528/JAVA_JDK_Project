package developerRoles;

import java.util.ArrayList;

public class DeveloperWorker {
    private final ArrayList<Developer> developers = new ArrayList<>();
    public void developerWorker() {

        developers.add(new Frontender());
        developers.add(new Backender());
        developers.add(new Fullstacker());
        developers.add(new Frontender());

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i) instanceof Frontender) {
                (developers.get(i)).developGUI();
            }
        }
    }
}
