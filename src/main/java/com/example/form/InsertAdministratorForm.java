package com.example.form;

/**
 * 管理者を挿入するときに使用するFormクラス.
 */
public class InsertAdministratorForm {
    /** 名前 */
    private String name;

    /** メールアドレス */
    private String mailAddress;

    /** パスワード */
    private String password;



    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "InsertAdministratorForm{" +
                "name='" + name + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
