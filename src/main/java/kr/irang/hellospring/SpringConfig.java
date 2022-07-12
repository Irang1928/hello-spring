package kr.irang.hellospring;

import kr.irang.hellospring.repository.MemberRepository;
import kr.irang.hellospring.repository.MemoryMemberRepository;
import kr.irang.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
