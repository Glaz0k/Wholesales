package com.kravchenko.wholesales.configuration;

import com.kravchenko.wholesales.entity.Entry;
import com.kravchenko.wholesales.entity.Good;
import com.kravchenko.wholesales.entity.Sale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
@EnableJdbcRepositories("com.kravchenko.wholesales.repository")
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public BeforeConvertCallback< Good > beforeConvertCallbackGood() {
        return (good) -> {
            if (good.getId() == null) {
                good.setId(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
            }
            return good;
        };
    }

    @Bean
    public BeforeConvertCallback< Sale > beforeConvertCallbackSale() {
        return (sale) -> {
            if (sale.getId() == null) {
                sale.setId(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
            }
            sale.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
            return sale;
        };
    }

    @Bean
    public BeforeConvertCallback< Entry > beforeConvertCallbackEntry() {
        return (entry) -> {
            if (entry.getId() == null) {
                entry.setId(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
            }
            return entry;
        };
    }

}
