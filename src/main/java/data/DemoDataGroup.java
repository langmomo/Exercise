package data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoDataGroup {
    @JsonProperty("tags")
    public Set<DemoTag> tags;

    @JsonProperty("segment_partner")
    public String segPartner;

    @JsonProperty("user_count")
    public int userCount;


}
