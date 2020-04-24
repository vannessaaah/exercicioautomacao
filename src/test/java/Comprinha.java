import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.PersistentMBean;
import java.math.BigDecimal;
import java.util.List;

public class Comprinha {
    @Test
    public void compras() throws Exception {
        String email = "vanessa.goncalves5@gft.com";
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // serve para instância afim de chamar o navegador
        driver.get("http://automationpractice.com/index.php"); // chamando o endereço do site
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")).click();
        Thread.sleep(4000);
        //String valor = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).getText().trim().replace("$", "").replace(" ", "");


        List<WebElement> itens = driver.findElements(By.xpath("//div[@class='layer_cart_row']/span"));

        String valor = itens.get(2).getText().trim();


        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click(); //XPATHCAMINHODOXML
        if( !driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText().equals("1"))
            throw new Exception("Não foi adicionado item no carrinho");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Vanessa");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Gonçalves");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[11]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[30]")).click();
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Rua Diadema, 98");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Cajamar");
        driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[11]")).click();
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("+55 11 9 9999 9999");
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("+55 11 9 9999 9999");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();

        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();

        //valor = "$18.51";
        if(!valor.equals(driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText().trim()))
            throw new Exception("O preço está diferente!");

        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();

        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();

        driver.close();
    }
}
