package hello.hellospring;
//자바 코드로 직접 스프링 빈 등록하기!

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {


    private final MemberRepository memberRepository;

    @Autowired //생성자 하나면 생략해도됨
    public springConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }



 /*   @Bean
    public MemberRepository memberRepository()
    {
        //return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }*/
}
