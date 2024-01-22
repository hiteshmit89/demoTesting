package Framework.Setup;

import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;
import java.sql.Time;
import java.time.LocalTime;

public class Setup {
    private Scenario scenario;

    @BeforeAll
    public static void resolvePropertiesFile(){
        switch (ConfigManager.getInstance().getProperty("Environment").toUpperCase()) {
            case "TEST" -> ConfigManager.getInstance().loadAdditionalProperties("Test.properties");
            case "ACCEPTANCE" -> ConfigManager.getInstance().loadAdditionalProperties("Acceptance.properties");
            default -> ConfigManager.getInstance().loadAdditionalProperties("Delivery.properties");
        }
    }

    @Before
    public void scenarioSetup(Scenario scenario){
        this.scenario = scenario;
        System.out.println("########starting thread: " + Thread.currentThread().getName() + " at " + Time.valueOf(LocalTime.now()));
        System.out.println("###############Running test############# "+scenario.getName());
        try {
            DriverManager.getInstance().loadDriver(ConfigManager.getInstance().getProperty("browser"));
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DriverManager.getInstance().navigateToURL(ConfigManager.getInstance().getProperty("URL"));
    }

    @After
    public void scenarioReport(){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().Driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }

        if (!ConfigManager.getInstance().getProperty("browser").equals("firefox")){
            DriverManager.getInstance().closeDriver();
        }

        DriverManager.getInstance().quitDriver();
        DriverManager.getInstance().killSession();
    }

    @AfterAll
    public static void looseDriverManager(){
        DriverManager.getInstance().remove();
    }
}
