package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private EmployeeService employeeService; /** injectie **/

    public EmployeeController(EmployeeService employeeService) {  /** constructor**/
        this.employeeService = employeeService;
    }

    /** creem  o metoda/controller de get **/
    @GetMapping("/")  /** = localhost:8080 **/
    public String viewHomePage(Model model){  /**dam ca parametru interfata Model din Spring **/
        List<Employee> employeeList = employeeService.getAllEmployees();  /** luam datele din DB si creem o lista de Employees **/
        model.addAttribute("employees employeeList");  /** folosim metoda addAtribute din model **/
        return "hello";  /** returnam fisierul hello din folderul templates **/
    }

    @GetMapping("/showNewEmployeeFrom")
    public String showNewEmployeeFrom(Model model){
      Employee employee = new Employee() ;
      model.addAttribute("employee",employee);
      return "new_employee";
    }

    /** creem  o metoda/controller de post ce va salva in DB informatiile introduse in formularul din pagina html **/
@PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
    /**  "employee" ul din @ModelAttribute("employee") este cel din
     * new_employee / <form action="#" th:action="@{/saveEmployee}"  th:object="${employee}" method="post">
     *     si este foasrte important sa aiba exact aceasi denumire**/
     employeeService.saveEmployee(employee);
     return "redirect:/";
}

@GetMapping("showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id")Long id, Model model){
    Employee employee = employeeService.getEmployeeById(id);
    model.addAttribute("employee", employee);
    return "update_employee";
}

}
























