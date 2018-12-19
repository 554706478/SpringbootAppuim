package com.testpro.appuim;

import com.testpro.appuim.Config.AppiumConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@SpringBootTest
public class appium extends AbstractTestNGSpringContextTests {


    private AndroidDriver<MobileElement> driver;
    @Autowired
    private AppiumConfig appiumConfig;
    @Autowired
    private DesiredCapabilities desiredCapabilities;

    @Test(priority = 0)
    public void loginbefore() throws MalformedURLException {
        driver = new AndroidDriver<>(new URL(appiumConfig.getUrl()), desiredCapabilities);
    }
    @Test(priority = 1)
    public void login() throws InterruptedException {
        MobileElement username = driver.findElement(By.id("com.gsafety.emergency:id/et_Username"));
        username.clear();
        username.sendKeys("hlf");
        MobileElement password = driver.findElement(By.id("com.gsafety.emergency:id/et_Password"));
        driver.navigate().back();
        password.clear();
        password.sendKeys("hlf123456");
        MobileElement loingbtn = driver.findElement(By.id("com.gsafety.emergency:id/btn_login"));
        driver.navigate().back();
        loingbtn.click();
    }

    // 点击报警列表
    @Test(priority = 2)
    public void initViewGroup() {
        MobileElement element = driver.findElement(By.id("com.gsafety.emergency:id/menu"));
        List<MobileElement> elements = element.findElements(By.className("android.view.ViewGroup"));
        elements.get(0).click();
    }

    //  点击第一个专项报警
    @Test(priority = 3)
    public void initBridge() {
        MobileElement element = driver.findElement(By.id("com.gsafety.emergency:id/recyclerView"));
        List<MobileElement> elements = element.findElements(By.className("android.widget.FrameLayout"));
        elements.get(0).click();
    }

    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(100000);
        driver.quit();
    }


}
