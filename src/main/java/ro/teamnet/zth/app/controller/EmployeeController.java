package ro.teamnet.zth.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.service.EmployeeService;
import ro.teamnet.zth.app.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by Irina on 06.05.2015.
 */
@Controller
@RequestMapping(value = "/employees")

public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET,value = "{idEmployee}")
    public @ResponseBody Employee getOneEmployee(@PathVariable(value="idEmployee") String idEmployee) {
        EmployeeService employeeService=new EmployeeServiceImpl();
        return employeeService.findOneEmployee(Integer.parseInt(idEmployee));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "{idEmployee}")
    public @ResponseBody String deleteOneEmployee(@PathVariable(value="idEmployee") String idEmployee) {
        EmployeeService employeeService=new EmployeeServiceImpl();
        employeeService.deleteEmployee(Integer.parseInt(idEmployee));
        return "Sters!";
    }



    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmployees() {

       /*Employee e=new Employee();
        e.setId(11);
        e.setFirstName("Bobby");
        Employee e2=new Employee();
        e2.setId(15);
        e2.setFirstName("Ana");
        List<Employee> list=new ArrayList<>();
        list.add(e);
        list.add(e2);

        return list;
        */
        EmployeeService employeeService=new EmployeeServiceImpl();
        return employeeService.findAllEmployees();


    }
}
