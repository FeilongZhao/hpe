package com.hpe.vo;

import java.util.Map;

import com.hpe.dao.UserDate;
import com.hpe.service.LoginInService;
import com.hpe.service.MaintenanceService;
import com.hpe.service.UpdatePasswordService;
import com.hpe.view.AccountView;
import com.hpe.view.MemorandumView;

public class PersonalVo {

    // private int index = 0;
    private AccountView accountView = null;
    private MaintenanceService service = null;
    private LoginInVo loginInVo = null;
    private LoginInService loginInService = null;
    private PersonalVo personalVo = null;
    private Map<String, String> password = null;
    private UpdatePasswordService updatePasswordService = null;
    private WallentVo wallentVo = null;
    private MainVo mainVo = null;
    private MemorandumVo memorandumVo = null;
    private GameVo gameVo = null;

    public void main(int i) {

        switch (i) {
        case 1:
            maintenance();
            break;

        case 2:
            updatePassword();
            break;
        case 3:

            wallent();
            break;
        case 4:
            memorandum();
            break;
        case 5:
            game();
            break;
        case 0:
            
            mainVo = new MainVo();
            mainVo.main();
            break;
        default:
            System.out.println("输入错误，请重新输入");
            loginInVo = new LoginInVo();
            loginInVo.personalMain(new LoginInService(), new PersonalVo(), UserDate.USERNAME, new AccountView());
            break;
        }

    }

    private void maintenance() {
        accountView = new AccountView();
        service = new MaintenanceService();
        loginInService = new LoginInService();
        service.main(accountView.maintenanceView());
        personalVo = new PersonalVo();
        loginInVo = new LoginInVo();

        System.out.println(UserDate.USERNAME);

        loginInVo.personalMain(loginInService, personalVo, UserDate.USERNAME, accountView);

    }

    private void updatePassword() {

        accountView = new AccountView();
        updatePasswordService = new UpdatePasswordService();
        password = accountView.updatePasswordView();
        loginInVo = new LoginInVo();
        loginInService = new LoginInService();
        personalVo = new PersonalVo();

        updatePasswordService.main(password.get("newPassword"), password.get("oldPassword"));

        loginInVo.personalMain(loginInService, personalVo, UserDate.USERNAME, accountView);
    }

    private void wallent() {

        wallentVo = new WallentVo();
        wallentVo.main();
    }
    
    private void memorandum() {
        
        memorandumVo = new MemorandumVo();
        memorandumVo.main();
     
    }
    
    private void game() {
        
        gameVo = new GameVo();
        gameVo.main();
    }
    
   

}
