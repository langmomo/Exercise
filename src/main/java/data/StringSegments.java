package data;

import java.lang.reflect.Array;
import java.util.List;

public class StringSegments {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<DemoTransactionItems> getTransactionItemsList() {
        return transactionItemsList;
    }

    public void setTransactionItemsList(List<DemoTransactionItems> transactionItemsList) {
        this.transactionItemsList = transactionItemsList;
    }

    private List<DemoTransactionItems> transactionItemsList;
}
