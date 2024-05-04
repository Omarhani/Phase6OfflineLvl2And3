package t;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class T {

    ReadDataFromJson readDataFromJson;

    @Test
    public void t1() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().URL);
    }
    @Test
    public void t2() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().Login.ValidCredentials.Username);
        System.out.println(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
    }
    @Test
    public void t3() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidUsername.Username);
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidUsername.Password);
    }
    @Test
    public void t4() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidPassword.Username);
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidPassword.Password);
    }

    @DataProvider
    public Object[][] testDataForT5() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile().Login1;
    }
    @Test(dataProvider = "testDataForT5")
    public void t5(String username, String password){

        System.out.println(username);
        System.out.println(password);
    }
}
