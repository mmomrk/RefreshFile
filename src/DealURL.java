import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



/**
 * Created by mrk on 10/16/2015.
 */
public class DealURL
{
    String downloadURL = "https://www.dropbox.com/s/6xhrygwpjq2czjx/text.txt?dl=1";

    public DealURL()
    {

    }

    public void  download()
    {
//        FileUtils.copyURLToFile();    //where do I get apache if idea does not know?

        try
        {
            URL website = new URL(downloadURL);
            Files.copy(website.openStream(), Paths.get("/testEudg/new.txt") , StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
