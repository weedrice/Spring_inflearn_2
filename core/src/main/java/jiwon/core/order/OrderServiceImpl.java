package jiwon.core.order;

import jiwon.core.discount.DiscountPolicy;
import jiwon.core.discount.FixDiscountPolicy;
import jiwon.core.member.Member;
import jiwon.core.member.MemberRepository;
import jiwon.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
