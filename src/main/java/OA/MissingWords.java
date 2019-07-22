package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingWords {
    static List<String> missingWords(String s, String t) {
        String[] sarray = s.split(" ");
        String[] tarray = t.split(" ");

        List<String> list = new ArrayList<>(Arrays.asList(tarray));
        List<String> re = new ArrayList<>();

        for(int i=0; i<sarray.length; i++){
            if(list.contains(sarray[i])){
                list.remove(sarray[i]);
            }else{
                re.add(sarray[i]);
            }
        }
        return re;
    }

    public static void main(String[] args){
        String s="A likes dog B likes dog and C likes dog";
        String t="likes likes";
        List<String> re = missingWords(s, t);
        System.out.println(String.join(",", re));
    }
}
