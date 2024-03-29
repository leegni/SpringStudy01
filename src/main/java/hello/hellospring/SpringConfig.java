package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    private DataSource dataSource;
    private EntityManager em;
    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository){
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }



    @Bean
    public MemberService memberService(){
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

/*    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/
/*    @Bean
    public MemberRepository memberRepository(){
        //return new JpaMemberRepository(em);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JdbcMemberRepository(dataSource);
        //return new MemoryMemberRepository();
    }*/
}
