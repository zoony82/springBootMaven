package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    @Autowired //기본적으로 데이터 소스가 빈으로 등록이 되서, 가져다 사용하면 된다
    DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()){
            connection.getMetaData().getURL();
            connection.getMetaData().getUserName();

            Statement statement = connection.createStatement();
            String sql = "Create Table User(id integer not null,name varchar(255), PRIMARY KEY(Id))";
            statement.executeUpdate(sql);

//            connection.close();

            System.out.println(connection.getMetaData().getURL() + " : " + connection.getMetaData().getUserName());

        }





    }
}
