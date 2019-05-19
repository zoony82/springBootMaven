package app.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest// 슬라이싱 테스트 : 리파지터리 관련된 것들만 빈들로 만들어서 테스트 하는 것(인메모리 데이터베이스가 반드시 필요하다)
// 하지만 @SpringBootTest 로 하면 설정파일 확인해서, 모든 빈들을 등록해서 테스트 한다.(인터그레이션 테스트)
// @SpringBootTest -> 사용하는 dbms정보가 나온다. 하지만 속도가 느리다는 단점이 있다. 테스트용 db도 필요해서 매우 피곤하다.
// 슬라이싱 테스트가 더 안전하고 편안하다.
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test // 먼저 비어있는것으로 테스트 : 빈들은 잘 등록되는지, 테스트 app는 잘 실행되는지 확인 가능
    public void di(){ }
    /* 아래 부분 확인 가능
    Hibernate: drop table account if exists
    Hibernate: drop sequence if exists hibernate_sequence
    Hibernate: create sequence hibernate_sequence start with 1 increment by 1
    Hibernate: create table account (id bigint not null, password varchar(255), username varchar(255), primary key (id))
     */
    @Test // 보통 슬라이싱 테스트에선 h2를 사용하며, 그 정보를 한번 확인해보자.
    public void di2() throws Exception{
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
    }
    /*
    jdbc:h2:mem:f650eac6-681d-4624-bd93-3c11f9e7e8c5
    H2 JDBC Driver
    SA
     */

    @Test
    public void di3() throws SQLException{
        Account account = new Account();
        account.setUsername("junhee");
        account.setPassword("aaaa");

        Account newAccount = accountRepository.save(account);

        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());

        System.out.println(existingAccount);
    }

}