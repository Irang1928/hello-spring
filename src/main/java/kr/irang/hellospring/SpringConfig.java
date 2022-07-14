package kr.irang.hellospring;

import kr.irang.hellospring.repository.JdbcMemberRepository;
import kr.irang.hellospring.repository.JdbcTemplatesMemberRepository;
import kr.irang.hellospring.repository.JpaMemberRepository;
import kr.irang.hellospring.repository.MemberRepository;
import kr.irang.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplatesMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
