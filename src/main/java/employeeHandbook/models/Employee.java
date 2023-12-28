package employeeHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Employee {
    private Integer idNumber;
    private ArrayList<String> phonesNumber;
    private String name;
    private Integer experience;

    public boolean addPhone(String phoneNumber) {
        boolean flag = false;
        if (!phonesNumber.contains(phoneNumber)) {
            phonesNumber.add(phoneNumber);
            flag = true;
        }
        return flag;
    }
}
