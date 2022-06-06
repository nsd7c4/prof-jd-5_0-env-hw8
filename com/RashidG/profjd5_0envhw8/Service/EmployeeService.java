package com.RashidG.profjd5_0envhw8.Service;

import com.RashidG.profjd5_0envhw8.data.Employee;
import com.RashidG.profjd5_0envhw8.exceptions.EmployeeNotFound;
import com.RashidG.profjd5_0envhw8.exceptions.ExistedEmployee;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class EmployeeService {
    private HashMap<String, Employee> book = new HashMap<String, Employee>();

    public String addEmployee(String firstName, String lastName) throws ExistedEmployee {
        boolean full = true;
        String result = new String();
        Employee e = new Employee(firstName, lastName);
        if (book.containsKey(e.getFullName())) {
            throw new ExistedEmployee();
        } else {
            book.put(e.getFullName(), e);
            result = e.toString();
        }

        return result;
    }


    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = "1";
        Employee e = new Employee(firstName, lastName);
        if (book.containsKey(e.getFullName())) {
            book.remove(e.getFullName());
            result = e.toString();
        }


        if (result == "1") {
            throw new EmployeeNotFound();
        }


        return result;
    }


    public String findEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = "2";
        Employee e = new Employee(firstName, lastName);
        if (book.containsKey(e.getFullName())) {
            result = e.toString();
        }


        if (result == "2") {
            throw new EmployeeNotFound();
        }
        return result;
    }

    public String allEmployee() {


        String result = book.toString();
        return result.toString();
    }
}
