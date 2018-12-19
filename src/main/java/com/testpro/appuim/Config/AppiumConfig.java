package com.testpro.appuim.Config;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "desiredcapabilities")
@Getter
@Setter
public class AppiumConfig {
    private String url;
    private String deviceName;
    private String automationName;
    private String platformName;
    private String platformVersion;
    private String appPackage;
    private String appActivity;
    private String udid;

    @Bean
    public DesiredCapabilities getdesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("udid", udid);
        return capabilities;
    }
}

