package be.vdab.temperatuur.restclients;

import be.vdab.temperatuur.dto.Weather;

import java.math.BigDecimal;
import java.util.Optional;

public interface OWRestClient {
    Optional<BigDecimal> findByGemeente(String gemeente);
}
