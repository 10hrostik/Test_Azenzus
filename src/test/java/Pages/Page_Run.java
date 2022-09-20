package Pages;

import Driver_Init.ChromeDriverInit;
import ReadConfigs.Configs;
import org.junit.Test;

public class Page_Run extends ChromeDriverInit {

    @Test
    public void Login(){
        String login= Configs.LOGIN;
        String password = Configs.PASSWORD;

        Login_Page test= new Login_Page();
        test.Auth(login,password);
    }
}
