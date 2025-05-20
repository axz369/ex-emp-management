package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者のコントローラ.
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * 管理者の情報を登録する画面に遷移する.
     *
     * @param form 管理者情報を入力するためのフォーム
     * @return 管理者登録画面
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form){
        return "administrator/insert";
    }


    /**
     * 管理者情報を登録する.
     *
     * @param form 管理者情報を入力するフォーム
     * @return ログイン画面
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form){
        Administrator administrator = new Administrator();
        //formオブジェクトの中身をadministratorオブジェクトにコピー
        BeanUtils.copyProperties(form, administrator);


        System.out.println(form.getName());

        //登録処理
        administratorService.insert(administrator);

        return "redirect:/";
    }


    /**
     * ログイン画面に遷移する.
     *
     * @param form ログイン画面のフォーム
     * @return ログイン画面
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){
        return "administrator/login";
    }


    /**
     * フォームオブジェクトのメールアドレスとパスワードから管理者を取得しログインする.
     *
     * @param form ログインのフォームオブジェクト
     * @return 従業員一覧画面
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model){

        //メールとパスワードをもとに管理者を取得
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());

        if(administrator == null){
            model.addAttribute("loginFailureMessage", "メールアドレスまたはパスワードが不正です。");
            return "administrator/login";
        }

        //ログイン成功時、管理者名を格納し従業員一覧へ遷移
        session.setAttribute("administratorName", administrator.getName());
        return "redirect:employee/showList";
    }
}
