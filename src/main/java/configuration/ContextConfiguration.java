package configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 1 on 28.08.2017.
 */
@Configuration
public class ContextConfiguration
{
    private static final Properties properties = getApplicationProperties();

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();

        emFactory.setDataSource(dataSource());

        emFactory.setPersistenceUnitName("jpaData"); ////!!!?

        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        emFactory.setJpaProperties(properties);

        emFactory.setPackagesToScan("entity", "repositories"); //?
        return emFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private static Properties getApplicationProperties()
    {
        Properties properties = new Properties();
        try
        {
            InputStream stream = new FileInputStream("application.properties");
            properties.load(stream);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("no properties");
        }
        catch (IOException er)
        {
            System.out.println("error");
        }
        return properties;
    }
}
