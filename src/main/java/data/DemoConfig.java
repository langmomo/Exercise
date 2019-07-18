package data;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;


public class DemoConfig {

//    public Set<DemoDataGroup> demoDataGroupSet;
    protected static DemoDataGroup[] parseLine(String line) {
        DemoDataGroup[] demo = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(line);
            demo = mapper.readValue(line, DemoDataGroup[].class);
            //jsonInput, new TypeReference<List<MyClass>>(){}
            System.out.println(demo[0].userCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return demo;
    }

    public static DemoDataGroup[] getDemoInputData(){
        BufferedReader br = null;
        FileReader fr = null;
        String path = System.getProperty("user.dir") + "/../platform/pixel-backend/src/test/resources/files/demo.json";
        System.out.println(path);
        StringBuilder sb = new StringBuilder();
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                sb.append(sCurrentLine.trim());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DemoConfig.parseLine(sb.toString());
    }

    public static void main(String[] args){
        getDemoInputData();
    }

//    public static void main(String[] args) {
//        BufferedReader br = null;
//        FileReader fr = null;
//        String path = System.getProperty("user.dir") + "/../platform/pixel-backend/src/test/resources/files/demo.json";
//        System.out.println(path);
//        StringBuilder sb = new StringBuilder();
//        try {
//            fr = new FileReader(path);
//            br = new BufferedReader(fr);
//
//            String sCurrentLine;
//
//            while ((sCurrentLine = br.readLine()) != null) {
//
//                sb.append(sCurrentLine.trim());
//            }
//            //System.out.println(sb.toString());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        DemoConfig.parseLine(sb.toString());
//    }

}
