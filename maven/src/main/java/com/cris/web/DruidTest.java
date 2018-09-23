package com.cris.web;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class DruidTest {


    @Test
    public void testDataSource() throws Exception {

        String property = System.getProperty("user.dir");

///        System.out.println("property = " + property);

        File file = new File(property + "/datasource_config.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        try (Connection connection = dataSource.getConnection()) {
            String sql = "select * from orders";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int order_num = resultSet.getInt("order_num");
                System.out.println("order_num = " + order_num);
            }
        }

    }


    // 无法直接获取到配置文件
    @Test
    public void test1() {
        InputStream resourceAsStream = DruidTest.class.getClassLoader().getResourceAsStream("/datasource_config.properties");
        System.out.println("resourceAsStream = " + resourceAsStream);
    }
}
