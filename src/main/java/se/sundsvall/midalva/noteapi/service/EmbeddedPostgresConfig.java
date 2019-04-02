package se.sundsvall.midalva.noteapi.service;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import com.opentable.db.postgres.embedded.PgBinaryResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.IOException;

import static java.lang.String.format;
@Profile("test")
@Configuration
public class EmbeddedPostgresConfig {

    @Value("${postgres.port:5433}")
    private int port;


    @Bean
    public DataSource dataSource(PgBinaryResolver pgBinaryResolver) throws IOException {
        EmbeddedPostgres pg = EmbeddedPostgres.builder()
                .setPgBinaryResolver(pgBinaryResolver)
                .setPort(port)
                .start();
        return pg.getPostgresDatabase();
    }


    @Bean
    public PgBinaryResolver getPgBinary() throws IOException {

        return (system, machineHardware) -> {
            ClassPathResource resource = new ClassPathResource(format("postgresql-%s-%s.txz", system, machineHardware));
            return resource.getInputStream();

        };
    }
}
