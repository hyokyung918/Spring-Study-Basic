package rosa.practice;

import rosa.practice.member.Grade;
import rosa.practice.member.Member;
import rosa.practice.member.MemberService;
import rosa.practice.member.MemberServiceImpl;
import rosa.practice.order.Order;
import rosa.practice.order.OrderService;
import rosa.practice.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("calculated price = " + order.calculatePrice());
    }
}
