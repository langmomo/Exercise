package data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoTag {
    @JsonProperty("label")
    public String label;

    @JsonProperty("segment_source")
    public String segmentSource;

    @JsonProperty("type")
    public String type;

    @JsonProperty("transaction_count")
    public int transactionCount;

    @JsonProperty("average_item_count")
    public double avgItemCount;

    @JsonProperty("catalog_pct")
    public double catalogPct;

    @JsonProperty("browsing_pages")
    public Set<DemoBrowsingPages> browsingPagesSet;

    @JsonProperty("transaction_items")
    public Set<DemoTransactionItems> transactionItemsSet;

    @JsonProperty("impression_count")
    public int impressionCount;
}
