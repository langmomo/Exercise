package data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoTransactionItems {
    @JsonProperty("title")
    public String title;

    @JsonProperty("brand")
    public String brand;

    @JsonProperty("id")
    public String id;

    @JsonProperty("price")
    public String price;
}
