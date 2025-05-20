package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 従業員関連機能の業務処理を行うサービス.
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    /**
     * 従業員情報を全件取得する.
     *
     * @return 取得した全従業員のリスト
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }


    /**
     * 従業員情報を取得する.
     *
     * @param id 従業員id
     * @return 従業員情報
     */
    public Employee showDetail(Integer id){
        return employeeRepository.findById(id);
    }
}
