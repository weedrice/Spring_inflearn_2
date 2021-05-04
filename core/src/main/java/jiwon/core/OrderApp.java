package jiwon.core;

import jiwon.core.member.Grade;
import jiwon.core.member.Member;
import jiwon.core.member.MemberService;
import jiwon.core.member.MemberServiceImpl;
import jiwon.core.order.Order;
import jiwon.core.order.OrderService;
import jiwon.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
