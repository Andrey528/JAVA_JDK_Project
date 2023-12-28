package employeeHandbook.models;

import java.util.List;
import java.util.ArrayList;

public class EmployeeRepo {
    private List<Employee> employees;

    public EmployeeRepo() {
        employees = new ArrayList<>();
    }

    public boolean add(Employee employee) {
        boolean flag = false;
        if (!employees.contains(employee)) {
            employees.add(employee);
            flag = true;
        }
        return flag;
    }

    public Employee getEmployee(int index) {
        return contains(index) ? employees.get(index) : null;
    }

    public boolean contains (int index) {
        return employees != null
                && employees.size() > index;
    }

    public int employeesLen() {
        return employees.size();
    }
}
