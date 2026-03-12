package com.gal;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mysql.cj.jdbc.MysqlDataSource;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;

@Configuration
public class BeansConfig{

    @Bean
    StringBuilder getStringBuilder() {
        return new StringBuilder("bean from configuration");
    }

    @Bean
    @Primary
    Calc getCalc() {
        return new MyCalc();
    }

    @Bean(name = "calcNamesBean")
    Calc getCalc2() {
        return new MyCalc();
    }

    @Bean
    DataSource getDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/company_db");
        ds.setUser("root");
        ds.setPassword("pass");
        return ds;
    }
}
