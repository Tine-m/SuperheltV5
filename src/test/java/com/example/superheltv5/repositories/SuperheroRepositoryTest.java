package com.example.superheltv5.repositories;

import com.example.superheltv5.models.Superhero;
import com.example.superheltv5.services.SuperheroException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SuperheroRepositoryTest {

    @Autowired
    private SuperheroRepository repository;

    @BeforeEach
    //@Sql({"superhero.sql"}) // bliver ikke kaldt
    public void beforeMethod() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "root");
            Statement st = connection.createStatement();
            // start transaction
            connection.setAutoCommit(false);
            // create
            st.addBatch("DROP DATABASE IF EXISTS SUPERHERO;");
            st.addBatch("CREATE DATABASE IF NOT EXISTS SUPERHERO;");
            st.addBatch("USE SUPERHERO;");
            st.addBatch("CREATE TABLE SUPERHERO(HERO_ID INTEGER NOT NULL AUTO_INCREMENT,\n" +
                    "HERO_NAME VARCHAR(50) NOT NULL,\n" +
                    "REAL_NAME VARCHAR(50) NOT NULL,\n" +
                    "CREATION_YEAR INT,\n" +
                    "PRIMARY KEY (HERO_ID),\n" +
                    "UNIQUE INDEX (HERO_NAME));");
            st.addBatch("INSERT into SUPERHERO (hero_name, real_name, creation_year)" +
                    "VALUES('Spider-man', 'Peter Parker', 1962)," +
                    "('Batman', 'Bruce Wayne', 1939)," +
                    "('Doctor Strange', 'Dr Stephen Strange', 1963);");
            int[] updateCounts = st.executeBatch();
            System.out.println("No. batch stmt executions: " + updateCounts.length);
            // end transaction
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // connection.close();
        }
    }

    @Test
    //@Sql({"/superhero.sql"}) //virker ikke
    public void getAll() throws SuperheroException {
        List<Superhero> result = repository.getAll();
        System.out.println(result.size());
        assertTrue(!result.isEmpty());
    }
}