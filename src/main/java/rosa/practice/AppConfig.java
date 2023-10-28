package rosa.practice;

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

    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
