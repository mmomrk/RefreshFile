import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 * Created by mrk on 10/16/2015.
 */
public class DealFilesystem
{
    String pathBasicS = "/testEudg/";
    String newFileNameS = "new.txt";
    String oldFilePathS = "foldr/";
    String oldFileNameS = "old.txt";
    String backupFilePathS = "bakcup/";
    Path newFileP = Paths.get(pathBasicS + newFileNameS);
    Path oldFileP = Paths.get(pathBasicS + oldFilePathS + oldFileNameS);

    public FileTime getAttributes(Path path)
    {

        BasicFileAttributes attr = null;
        try
        {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("File " + path + " has next attrs:");
        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
        return attr.lastModifiedTime();
    }

    public void infoOnFiles()
    {
        getAttributes(newFileP);
        getAttributes(oldFileP);
    }

    public void backup()
    {

        CopyOption[] options = new CopyOption[]{ StandardCopyOption.COPY_ATTRIBUTES};

        DateFormat df = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
        Calendar calobj = Calendar.getInstance();
        String date = df.format(calobj.getTime());

        System.out.println("doing backup to " + date+".txt");

        Path backup = Paths.get(pathBasicS + backupFilePathS + date + ".txt");
        try
        {
            Files.copy(oldFileP, backup, options);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void replace()
    {
        CopyOption[] options = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES};
        System.out.println("Replacing old with new");
        try
        {
            Files.copy(newFileP, oldFileP, options);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public boolean compare()
    {


        if (getAttributes(newFileP).toString().equals(getAttributes(oldFileP).toString()) )  //not tested
        {
            System.out.println("Dates are different => Files are different");
            return true;
        } else
        {
            System.out.println("Files are the same. Not doing anything");
            return false;
        }
    }

}
