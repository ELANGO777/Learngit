package DataProviders;

import org.testng.annotations.DataProvider;

public class CustomData {

    @DataProvider(name = "login")
    public Object[][] getLoginData(){
        return new Object[][]{{"admin","admin123"},{"admin","admin1"}};
    }

    @DataProvider(name = "productsearch")
    public Object[][] getProduct(){
        return new Object[][]{{"iphone"}};
    }
}
