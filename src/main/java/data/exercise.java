package data;

public class exercise {
    public static void main(String[] args){
        int max = 0;
        Status[] result = new Status[6];
        int num = 0;
        int[] a = {6,2,4,1,3,5};
        for(int i=0; i<6;  i++){
            //result[a[i]-1] = true;
            if(a[i] == 1){
                if(result[0] != null){
                    result[0].val = true;
                }else{
                    Status s = new Status(true);
                    result[0] = s;
                }
                num+=1;

            }
            else if(result[a[i]-2] != null && result[a[i]-2].val == true && a[i]>=max){
                if(result[a[i]-1] != null){
                    result[a[i]-1].val = true;
                }else{
                    Status s = new Status(true);
                    result[a[i]-1] = s;
                }

//                result[a[i]-1] = s;
                num +=1;
            }else{
                if(result[a[i]-2] == null){
                    result[a[i]-2] = new Status(false);
                }
                result[a[i]-1] = result[a[i]-2];
            max = a[i];}


            }
        System.out.println(num);
    }

}
class Status {
    boolean val = false;

    public Status(boolean value) {
        val = value;
    }
}

