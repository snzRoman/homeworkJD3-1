import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {

        List<String> directories = Arrays.asList("E://Games/src",
                "E://Games/res",
                "E://Games/savegames",
                "E://Games/temp",
                "E://Games/src/main",
                "E://Games/src/test",
                "E://Games/res/drawables",
                "E://Games/res/vectors",
                "E://Games/res/icons");

        List<String> files = Arrays.asList("E://Games/src/main/Main.java",
                "E://Games/src/main/Utils.java",
                "E://Games/temp/Temp.txt");

        for (String dirName : directories) {
            File dir = new File(dirName);
            logFile(dir.mkdir(), dir.getName(), dir.isDirectory());
        }

        for (String fileName : files) {
            File file = new File(fileName);
            try {
                logFile(file.createNewFile(), file.getName(), file.isDirectory());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file = new File("E://Games/temp/temp.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(stringBuilder.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void logFile(boolean creating, String name, boolean isDirectory){
        if (creating){
            if (isDirectory) stringBuilder.append("Directory " + name + " has been created. \n");
            else stringBuilder.append("File " + name + " has been created. \n");
        }else{
            if (isDirectory) stringBuilder.append("Directory " + name + " has not been created. \n");
            else stringBuilder.append("File " + name + " has not been created. \n");
        }
    }
}
