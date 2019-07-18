package data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoBrowsingPages {
    // title of product
    @JsonProperty("freeform")
    public String freeform;

    @JsonProperty("mfg_id")
    public int mfgId;

    @JsonProperty("device_id")
    public int deviceId;
}
