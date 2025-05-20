package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理者関連機能の業務処理を行うサービス.
 */
@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報を挿入する.
     *
     * @param administrator 管理者情報
     */
    public void insert(Administrator administrator){
        //管理者リポジトリの挿入処理を実行
        administratorRepository.insert(administrator);
    }


    /**
     * ログイン処理をする.
     *
     * @param mailAddress
     * @param password
     * @return 管理者情報
     */
    public Administrator login(String mailAddress, String password){
        //検索した管理者を返却
        return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
    }
}
