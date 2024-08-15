package config;
/*  gaajiCode
    99
    08/08/2024
    */

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "repo")
@EnableTransactionManagement
//@PropertySource("classpath:hibernates.properties")
public class JPAConfig {
//
//    @Autowired
//    Environment env;
//
//
//
//    @Bean
//   public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter ja){
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setJpaVendorAdapter(ja);
//        bean.setDataSource(ds);//connection
//        bean.setPackagesToScan(env.getRequiredProperty("entity.pakage.name"));
//        return bean;
//    }
//
//    @Bean
//    public  DataSource dataSource(){
//        DriverManagerDataSource dm = new DriverManagerDataSource();
//        dm.setUrl(env.getRequiredProperty("my.app.url"));
//        dm.setUsername(env.getRequiredProperty("my.app.username"));
//        dm.setPassword(env.getRequiredProperty("my.app.password"));
//        dm.setDriverClassName(env.getRequiredProperty("my.app.driverclassname"));
//        return dm;
//
//    }
//
//
//
//
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter(){
//        HibernateJpaVendorAdapter vendor=new HibernateJpaVendorAdapter();
//        vendor.setDatabasePlatform(env.getRequiredProperty("my.app.dialect"));
//        vendor.setDatabase(Database.MYSQL);
//        vendor.setShowSql(true);
//        vendor.setGenerateDdl(true);
//        return vendor;
//
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        return new JpaTransactionManager(emf);
//    }


}
