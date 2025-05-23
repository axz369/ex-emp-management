package com.example.controller;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 従業員関連機能の処理の制御を行うコントローラ.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧を出力する.
     *
     * @param model リクエストパラメータ
     * @return 従業員一覧画面
     */
    @GetMapping("/showList")
    public String showList(Model model){
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }


    /**
     * 従業員の詳細を取得する.
     *
     * @param id 従業員id
     * @param model リクエストパラメータ
     * @param form 従業員のフォーム
     * @return 従業員の詳細画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form){
        int employeeId = Integer.parseInt(id);
        Employee employee = employeeService.showDetail(employeeId);

        model.addAttribute("employee", employee);

        return "employee/detail";
    }

    /**
     * 従業員詳細(扶養人数人数のみ)を更新する.
     *
     * @param form 従業員を更新するフォーム
     * @return 従業員一覧画面
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form){
        //更新対象の従業員を取得
        int employeeId = Integer.parseInt(form.getId());
        Employee employee = employeeService.showDetail(employeeId);

        //扶養人数の情報をセット
        int dependentsCount = Integer.parseInt(form.getDependentsCount());
        employee.setDependentsCount(dependentsCount);

        //更新
        employeeService.update(employee);

        return "redirect:/employee/showList";
    }
}
