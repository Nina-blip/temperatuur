package be.vdab.temperatuur.dto;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    private BigDecimal temp;
    @JsonProperty("feels_like")
    private BigDecimal gevoelsTemperatuur;
    @JsonProperty("temp_min")
    private BigDecimal tempMin;
    @JsonProperty("temp_max")
    private BigDecimal tempMax;

    public BigDecimal getTemp() {
        return temp;
    }

    public BigDecimal getGevoelsTemperatuur() {
        return gevoelsTemperatuur;
    }

    public BigDecimal getTempMin() {
        return tempMin;
    }

    public BigDecimal getTempMax() {
        return tempMax;
    }
}
