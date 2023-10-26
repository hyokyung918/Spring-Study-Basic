package rosa.practice.order;

import rosa.practice.discount.DiscountPolicy;
import rosa.practice.discount.FixDiscountPolicy;
import rosa.practice.member.Member;
import rosa.practice.member.MemberRepository;
import rosa.practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
