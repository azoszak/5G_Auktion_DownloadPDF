import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadPDF extends TestBase{

    HomePage HomePage;

    @BeforeMethod
    public void setUp() {
        //TestBase.initialization();
        //driver.get(prop.getProperty("urlDownloadPDF"));
        TestBase.InitPDFDownload();
        //TestBase.InitforDownload();


        //*[@id="content"]/div/p/a
         HomePage = new HomePage();
    }

    @Test()
    public void download_PDF() {
        // Überprüfe ob der Download beendet worden ist.
        String such = "//*[@id='content']/div/p/a";
        String url_tmp = "https://www.bundesnetzagentur.de/SharedDocs/Downloads/DE/Sachgebiete/Telekommunikation/Unternehmen_Institutionen/Frequenzen/OffentlicheNetze/Mobilfunk/DrahtloserNetzzugang/Mobilfunk2020/20180905_OeffentlicheAnhoerungStellungnahmen.zip";


        if(Utils.linkExists(url_tmp)){
            //driver.get(url);
            System.out.println("Nase");
            System.out.printf(" Finde HREF Text %s \n ", driver.findElement(By.xpath(such)).getText());
            System.out.printf(" Finde HREF TagName %s \n ", driver.findElement(By.xpath(such)).getAttribute("href"));

            WebElement e2 =driver.findElement(By.xpath(such));
            e2.click();

        }
        // check if the file has been succesfully downloaded'
        System.out.println("Download Check has to be implemeted");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();

    }
}

