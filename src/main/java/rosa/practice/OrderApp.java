package rosa.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rosa.practice.member.Grade;
import rosa.practice.member.Member;
import rosa.practice.member.MemberService;
import rosa.practice.member.MemberServiceImpl;
import rosa.practice.order.Order;
import rosa.practice.order.OrderService;
import rosa.practice.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 30000);

        System.out.println("order = " + order);
        System.out.println("calculated price = " + order.calculatePrice());
    }
}
