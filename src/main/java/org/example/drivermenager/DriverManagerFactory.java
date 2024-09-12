package org.example.drivermenager;

import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;
        switch (type) {
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}


