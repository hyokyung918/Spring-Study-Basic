package rosa.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rosa.practice.discount.DiscountPolicy;
import rosa.practice.discount.RateDiscountPolicy;
import rosa.practice.member.MemberRepository;
import rosa.practice.member.MemberService;
import rosa.practice.member.MemberServiceImpl;
import rosa.practice.member.MemoryMemberRepository;
import rosa.practice.order.OrderService;
import rosa.practice.order.OrderServiceImpl;



@Configuration
public class AppConfig {

//    @Autowired MemberRepository memberRepository;

    @Bean
    public MemberService memberService () {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
