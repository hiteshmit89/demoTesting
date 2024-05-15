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
            case "QA3" -> ConfigManager.getInstance().loadAdditionalProperties("QA3.properties");
            case "QA2" -> ConfigManager.getInstance().loadAdditionalProperties("QA2.properties");
            default -> ConfigManager.getInstance().loadAdditionalProperties("QA1.properties");
        }
    }

    @Before(order = 0)
    public void scenarioSetup(Scenario scenario) {
        this.scenario = scenario;
        logger.info("\u001B[32m" + "########starting thread: " + Thread.currentThread().getName() + " at " + Time.valueOf(LocalTime.now()) + "\u001B[0m");
        logger.info("\u001B[32m" + "###############Running test############# " + scenario.getName() + "\u001B[0m");
        try {
            DriverManager.getInstance().loadDriver(ConfigManager.getInstance().getProperty("browser"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Before("not @PatientPortal")
    public void navigateToPbnUrl() {
        DriverManager.getInstance().navigateToURL(ConfigManager.getInstance().getProperty("URL"));
    }

    @Before("@PatientPortal")
    public void navigateToPatientPortalUrl() {
        DriverManager.getInstance().navigateToURL(ConfigManager.getInstance().getProperty("PatientPortalURL"));
    }

    @After
    public void scenarioReport() {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().Driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }

        /*if (!ConfigManager.getInstance().getProperty("browser").equals("firefox")) {
            DriverManager.getInstance().closeDriver();
        }

        DriverManager.getInstance().quitDriver();
        DriverManager.getInstance().killSession();*/
    }

    @AfterAll
    public static void looseDriverManager() {
        DriverManager.getInstance().remove();
    }
}
