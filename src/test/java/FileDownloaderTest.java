import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileDownloaderTest extends TestBase {

    HomePage HomePage;


    @BeforeMethod
    public void setUp() {

        TestBase.InitPDFDownload();
        HomePage = new HomePage();

    }
    @AfterMethod()
    public void tearDown() {
        //FileDownloader.deleteDownloads();
    }

    @Test()
    public void testFileDownload() throws IOException, InterruptedException {
        String url;
        FileDownloader downloader = new FileDownloader();


        //driver.get("http://code-fever.de");
        driver.get("https://www.bundesnetzagentur.de/SharedDocs/Downloads/DE/Sachgebiete/Telekommunikation/Unternehmen_Institutionen/Frequenzen/OffentlicheNetze/Mobilfunk/DrahtloserNetzzugang/Mobilfunk2020/20180905_OeffentlicheAnhoerungStellungnahmen.zip");
        //final String absolutePath = downloader.download(driver, "http://code-fever.de/files/codefever/favicon.ico",
        //        "codefever_favicon.ico");

        url = "https://www.bundesnetzagentur.de/SharedDocs/Downloads/DE/Sachgebiete/Telekommunikation/Unternehmen_Institutionen/Frequenzen/OffentlicheNetze/Mobilfunk/DrahtloserNetzzugang/Mobilfunk2020/20180905_OeffentlicheAnhoerungStellungnahmen.zip;jsessionid=9584BCDF2102686AD58BC6B532614D02?__blob=publicationFile&v=2";
        final String absolutePath = downloader.download(driver,url, "20180905_OeffentlicheAnhoerungStellungnahmen.zip");

        File file = FileUtils.getFile(absolutePath);
        Assert.assertTrue(file.exists());

    }

}
