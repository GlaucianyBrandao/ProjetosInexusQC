package steps;

import io.cucumber.java.Before;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testeCarrinhoSteps {

    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String senha = "secret_sauce";
    String login = "standard_user";
    String product;
    String expected = "https://www.saucedemo.com/inventory.html";
    String stepOne;
    String stepExpected = "https://www.saucedemo.com/checkout-step-one.html";


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Dado("que o usuario esta na pagina Your Cart")
    public void que_o_usuario_esta_na_pagina_your_cart() {
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Quando("clica em Continue Shopping")
    public void clica_em_continue_shopping() {
        driver.findElement(By.id("continue-shopping")).click();
    }

    @Então("deve ser direcionado a pagina inicial")
    public void deve_ser_direcionado_a_pagina_inicial() {
        product = driver.getCurrentUrl();
        Assert.assertEquals(expected, product);
        System.out.println();
    }

    @Quando("clica em Checkout")
    public void clica_em_checkout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Então("deve ser direcionado para a pagina Check out Step one")
    public void deve_ser_direcionado_para_a_pagina_check_out_step_one() {
        stepOne = driver.getCurrentUrl();
        Assert.assertEquals(stepOne, stepExpected);

    }

    @After
    public void encerra(){
        driver.quit();
    }



}
