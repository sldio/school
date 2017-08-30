package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    private static SessionFactory sessionFactory = getSessionFactory();

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/humans");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        System.out.println("db properties set");
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

    @Bean(name = "transactionManager")
    private static HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    private static SessionFactory getSessionFactory()
    {

        DataSource dataSource = getDatasourceConfiguration();
        LocalSessionFactoryBean localSessionFactoryBean = generateSessionFactoryBean(new String[] { "repositories" },
                dataSource, properties);
        SessionFactory sessionFactory = localSessionFactoryBean.getObject();

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return sessionFactory;
    }

    private static DataSource getDatasourceConfiguration()
    {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/humans");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    private static LocalSessionFactoryBean generateSessionFactoryBean(String[] basePackage, DataSource dataSource,
                                                                      Properties hibernateProperties)
    {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(basePackage);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);

        return localSessionFactoryBean;
    }

    private static Properties getApplicationProperties()
    {
        Properties properties = new Properties();
        try
        {
            InputStream stream = new FileInputStream("src\\main\\resources\\hibernate.properties");
            properties.load(stream);
            System.out.println("properies loaded");
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
