package configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by 1 on 29.08.2017.
 */
@Configuration
@ComponentScan({"repositories"})
public class HibernateUtil
{
    public SessionFactory getSessionFactory()
    {

        Properties hibernateProperties = getHibernateProperties();
        DataSource dataSource = getDatasourceConfiguration();
        LocalSessionFactoryBean localSessionFactoryBean = generateSessionFactoryBean(new String[] { "repositories" },
                dataSource, hibernateProperties);
        SessionFactory sessionFactory = localSessionFactoryBean.getObject();

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return sessionFactory;
    }

    private DataSource getDatasourceConfiguration() {

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

    private static Properties getHibernateProperties()
    {

        Properties hibernateProperties = new Properties();
        try (InputStream inputStream = new FileInputStream("hibernate.properties");)
        {
            hibernateProperties.load(inputStream);
        } catch (IOException e)
        {
            System.out.println("no file");
        }

        return hibernateProperties;
    }

    public static void main(String ... args)
    {

    }
}
