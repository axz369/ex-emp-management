package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理者のサービスクラス.
 */
@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報を挿入する.
     * @param administrator 管理者情報
     */
    public void insert(Administrator administrator){
        //管理者リポジトリの挿入処理を実行
        administratorRepository.insert(administrator);
    }
}
