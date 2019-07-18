public class t1 {

    public static void main(String[] args) {
        int result = 0;
        int[] a = {2, 2};
        int i=0;
        int start = -1;
        int end = 1;
        while (i<a.length) {
            if(end<a.length && a[i] == a[end]){
                end+=1;
                continue;
            }
            if((start<0)|| end>=a.length || (a[i]<a[end] && a[i]<a[start]) || (a[i]>a[end] && a[i]>a[start]) ){
                result +=1;
            }

            start=i;
            i=end;
            end = i+1;
        }
        System.out.println(result);
    }

}
