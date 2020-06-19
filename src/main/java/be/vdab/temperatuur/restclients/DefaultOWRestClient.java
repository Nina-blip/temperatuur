package be.vdab.temperatuur.restclients;

import be.vdab.temperatuur.dto.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class DefaultOWRestClient implements OWRestClient {
    private final WebClient client;
    private final String weerURI;

    public DefaultOWRestClient(WebClient.Builder builder, @Value("${weerURI}") String weerURI) {
        this.client = builder.build();
        this.weerURI = weerURI;
    }

    @Override
    public Optional<BigDecimal> findByGemeente(String gemeente) {
        try {
            return Optional.of(client.get().uri(weerURI, uriBuilder
                    -> uriBuilder.build(gemeente)).retrieve().bodyToMono(Weather.class).block().getMain().getTemp());
        } catch (WebClientResponseException ex) {
            return Optional.empty();
        }
    }
}
