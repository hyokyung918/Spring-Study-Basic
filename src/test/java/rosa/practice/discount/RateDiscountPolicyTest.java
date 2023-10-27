package rosa.practice.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rosa.practice.member.Grade;
import rosa.practice.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy DiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 되어야 합니다.")
    void vip_o () {
        // given
        Member member = new Member(1L, "MemberVIP", Grade.VIP);

        // when
        int discount = DiscountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 합니다.")
    void vip_x () {
        // given
        Member member = new Member(1L, "MemberBasic", Grade.BASIC);

        // when
        int discount = DiscountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}