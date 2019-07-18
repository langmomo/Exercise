package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class GenerateSegments {
    public DemoDataGroup[] demoDataGroups = null;
    public int sumTransactions;
    public int userCount;
    public Set<DemoTransactionItems> transactionItemsSet;

    public GenerateSegments(){
         demoDataGroups = DemoConfig.getDemoInputData();

    }
    public void getTransactionSegment() throws IOException {
        if (demoDataGroups != null) {
            for (DemoDataGroup ddg : demoDataGroups) {
                for (DemoTag dt : ddg.tags) {
                    if (dt.transactionItemsSet != null) {
                        DemoTransactionItems[] demoTransactionItems = dt.transactionItemsSet.toArray(new DemoTransactionItems[dt.transactionItemsSet.size()]);
                        List<Map<String, String>> transactionSegments = new ArrayList<>();
                        List<Integer> distribution =  new ArrayList<>();
                        distribution = getDistribution(dt.transactionCount, dt.avgItemCount, distribution);
                        distribution.forEach(size -> {
                            Map<String, String> transaction = addTransaction(size, demoTransactionItems);
                            transactionSegments.add(transaction);
                        });
                        ObjectMapper om = new ObjectMapper();
                        final StringWriter sw = new StringWriter();
                        om.writeValue(sw, transactionSegments);
                        System.out.println(sw.toString());
                        break;


                    }
                }
            }


        }
    }

    public List<Integer> getDistribution(int transactionCount, double avg, List<Integer> distribution){
        //order number
        double orderCount = Math.round(transactionCount / avg);
        int sum = 0;
        int i=0;


        while(i<orderCount){
            System.out.println(transactionCount- sum);
            System.out.println(orderCount-i);
            avg = (transactionCount- sum)/(orderCount-i);
            double temp = Math.floor(avg);
            if(avg-temp > 0.5) {
                temp+=1;
            }
            sum += temp;
            i+=1;
            System.out.println(avg+ ":" + temp + ":" + sum);
            distribution.add((int)temp);

        }
        if(transactionCount != sum){
            System.out.println(sum + ": " + transactionCount+":"+distribution.size());
        }
        return distribution;

    }

    public Map<String, String> addTransaction(int size, DemoTransactionItems[] transactionItems) {
        Random r = new Random();
        int transactionItemsSize = transactionItems.length;
        Map<String, String> transactionSegment = new LinkedHashMap<>();
        transactionSegment.put("orderId", "Q440488800" + r.nextInt(1147483647) + 1000000000);
        for (int j = 1; j <= size; j++) {
            DemoTransactionItems demoTransactionItems = transactionItems[r.nextInt(transactionItemsSize)];
            transactionSegment.put("brand_" + j, demoTransactionItems.brand);
            transactionSegment.put("title_" + j, demoTransactionItems.title);
            transactionSegment.put("id_" + j, demoTransactionItems.id);
            transactionSegment.put("price_" + j, demoTransactionItems.price);
        }
        return transactionSegment;
    }

    public static void main(String[] args) throws IOException {
        GenerateSegments gs = new GenerateSegments();
        gs.getTransactionSegment();





    }

}
