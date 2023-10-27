package rosa.practice;

import rosa.practice.discount.DiscountPolicy;
import rosa.practice.discount.RateDiscountPolicy;
import rosa.practice.member.MemberRepository;
import rosa.practice.member.MemberService;
import rosa.practice.member.MemberServiceImpl;
import rosa.practice.member.MemoryMemberRepository;
import rosa.practice.order.OrderService;
import rosa.practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
