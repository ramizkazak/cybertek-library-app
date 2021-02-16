package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {



    @Before
    public void setUpScenario(){
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @After
    public void tearDownScenario(){
        Driver.closeDriver();
    }
}
