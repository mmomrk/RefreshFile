import java.io.IOException;

import static jdk.nashorn.internal.runtime.ScriptingFunctions.exec;



public class Main
{

    public static void main(String[] args)
    {

        System.out.println("Hello World!");

        DealTask task = new DealTask();
        DealURL dUrl = new DealURL();
        DealFilesystem dfs = new DealFilesystem();

        String processName = "notepad.exe";

        try
        {
            if (task.isProcessRunning(processName))
            {

                task.killProcess(processName);
                System.out.println("Process killed");
            } else
            {
                System.out.println("Process not found, not killed");
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        dUrl.download();

        if (dfs.compare())
        {
            dfs.backup();
            dfs.replace();
        }



        try
        {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
