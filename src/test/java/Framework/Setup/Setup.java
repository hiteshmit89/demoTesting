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
import java.util.logging.Logger;

public class Setup {
    private Scenario scenario;
    private static final Logger logger = Logger.getLogger("PBN");

    @BeforeAll
    public static void resolvePropertiesFile() {
        switch (ConfigManager.getInstance().getProperty("Environment").toUpperCase()) {
            case "TEST" -> ConfigManager.getInstance().loadAdditionalProperties("Test.properties");
            case "ACCEPTANCE" -> ConfigManager.getInstance().loadAdditionalProperties("Acceptance.properties");
            default -> ConfigManager.getInstance().loadAdditionalProperties("Delivery.properties");
        }
    }

    @Before
    public void scenarioSetup(Scenario scenario) {
        this.scenario = scenario;
        logger.info("\u001B[32m" + "########starting thread: " + Thread.currentThread().getName() + " at " + Time.valueOf(LocalTime.now()) + "\u001B[0m");
        logger.info("\u001B[32m" + "###############Running test############# " + scenario.getName() + "\u001B[0m");
        try {
            DriverManager.getInstance().loadDriver(ConfigManager.getInstance().getProperty("browser"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DriverManager.getInstance().navigateToURL(ConfigManager.getInstance().getProperty("URL"));
    }

    @After
    public void scenarioReport() {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().Driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }

        if (!ConfigManager.getInstance().getProperty("browser").equals("firefox")) {
            DriverManager.getInstance().closeDriver();
        }

        DriverManager.getInstance().quitDriver();
        DriverManager.getInstance().killSession();
    }

    @AfterAll
    public static void looseDriverManager() {
        DriverManager.getInstance().remove();
    }
}
