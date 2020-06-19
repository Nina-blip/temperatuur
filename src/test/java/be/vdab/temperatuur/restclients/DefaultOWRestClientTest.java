package be.vdab.temperatuur.restclients;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DefaultOWRestClientTest {
    private final DefaultOWRestClient client;

    public DefaultOWRestClientTest(DefaultOWRestClient client) {
        this.client = client;
    }

    @Test
    void vindCorrecteTemperatuur() {
        assertThat(client.findByGemeente("Mol").get()).isBetween(BigDecimal.valueOf(-60), BigDecimal.valueOf(60));
    }
}