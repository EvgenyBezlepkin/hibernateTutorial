package demo.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "demo")
// активирует возможности Spring бесшовной транзакции через @Transactional
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    // описывает подключение к базе данных
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    // свойства hibernate
    // http://hibernate-refdoc.3141.ru/ch3.Configuration
    private Properties hibernateProperties() {
        Properties properties = new Properties();

//        берет свойства из @PropertySource(value = "classpath:db.properties")

        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

//        задает свойства в методе

        properties.put("hibernate.hbm2ddl.auto", "update");
        // количество операций обновления, которые дб сгруппированы в пакет
        properties.put("hibernate.jdbc.batch_size", 10);
        // количество записецй из результирующего набора
        properties.put("hibernate.jdbc.fetch_size", 50);
        // глубина внешних соединений
        properties.put("hibernate.jdbc.fetch_depth", 3);
        return properties;
    }

    // фабрика сеансов, выдает объекты, реализующие интрефейс Session
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("demo");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    // диспетчер транзакций
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
