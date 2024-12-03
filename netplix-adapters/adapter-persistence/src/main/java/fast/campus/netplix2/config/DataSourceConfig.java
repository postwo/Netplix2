package fast.campus.netplix2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")//내가 만든 application.yml 파일에 spring.datasource.hikari를 가지고 온다는 뜻이다.
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
