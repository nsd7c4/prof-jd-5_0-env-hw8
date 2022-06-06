package com.RashidG.profjd5_0envhw8;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//### Шаг 4
//
//Создать сервис EmployeeService, который хранит внутри поле с массивом сотрудников.
@Service
public class EmployeeService {
    private HashMap<String, Employee> book = new HashMap<String, Employee>();

    //5.1 Добавить сотрудника.
    public String addEmployee(String firstName, String lastName) throws ExistedEmployee {
        boolean full = true;
        String result = new String();
        Employee e = new Employee(firstName, lastName);
        if (book.containsKey(e.getFullName())) {
            throw new ExistedEmployee();
        } else {
            book.put(e.getFullName(),e);
            result = e.toString();
        }
//        for (int i = 0; i < book.size(); i++) {
//            if (book == null) {
//                full = false;
//                book[i] = e;
//                result = e.toString();
//                break;
//            } else {
//                if (e.equals(book[i])) {
//                    throw new ExistedEmployee();
//                }
//            }
//            if (full) {
//                throw new EmployeeBookIsFull();
//            }
//        }
        return result;
    }


    //5.2. Удалить сотрудника.
    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = "1";
        Employee e = new Employee(firstName, lastName);
        if (book.containsKey(e.getFullName())) {
            book.remove(e.getFullName());
            result = e.toString();
        }
//        for (int i = 0; i < book.size(); i++) {
//            if (book.get(i).equals(e)) {
//                book.remove(i);
//                result = book.get(i).toString();
//                break;
//            }
//        }
        if (result == "1") {
            throw  new EmployeeNotFound();
        }
//        for (int i = 0; i < book.length; i++) {
//            if (book[i] != null) {
//                if (book[i].equals(e)) {
//                    book[i] = null;
//                    result = e.toString();
//                    break;
//                }
//            } else {
//                throw new EmployeeNotFound();
//            }
//        }
        return result;
    }

    //5.3. Найти сотрудника.
    public String findEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = "2";
        Employee e = new Employee(firstName, lastName);
        if (book.containsKey(e.getFullName())) {
            result = e.toString();
        }
//        for (int i = 0; i < book.size(); i++) {
//            if (book.get(i).equals(e)) {
//                result = book.get(i).toString();
//                break;
//            }
//        }
//        for (int i = 0; i < book.length; i++) {
//            if (book[i] != null) {
//                if (book[i].equals(e)) {
//                    result = e.toString();
//                    break;
//                }
//            } else {
//                throw new EmployeeNotFound();
//            }
//        }
        if (result == "2") {
            throw new EmployeeNotFound();
        }
        return result;
    }

    public String allEmployee() {
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < book.length; i++) {
//            result.append(book[i] + "\n");
//        }
        String result = book.toString();
        return result.toString();
    }
}
