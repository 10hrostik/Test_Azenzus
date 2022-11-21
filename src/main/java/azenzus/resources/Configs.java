package azenzus.resources;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface Configs {
    Config config=readConfig();
    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile") ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile")):
                ConfigFactory.load("ConfigFile.conf");
    }
    String URL = readConfig().getString("url");
    String LOGIN = readConfig().getString("userParameter.demo.login");
    String PASSWORD = readConfig().getString("userParameter.demo.password");
}
