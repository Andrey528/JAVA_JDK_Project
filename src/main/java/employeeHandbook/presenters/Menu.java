package employeeHandbook.presenters;

import employeeHandbook.conrollers.EmployeeController;

public class Menu {
    EmployeeController ec = new EmployeeController();
    private ConsoleView cv = new ConsoleView();

    public void run() {
        while (true) {
            switch (cv.inputAction()) {
                case 1 -> ec.addEmployee();
                case 2 -> ec.findEmployeeByExperience();
                case 3 -> ec.findPhonesByName();
                case 4 -> ec.findEmployeeByIDNumber();
                case 5 -> ec.addPhone();
                case 0 -> System.exit(0);
            }
        }
    }
}
