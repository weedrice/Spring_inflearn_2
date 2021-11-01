package jiwon.core;

import jiwon.core.discount.DiscountPolicy;
import jiwon.core.discount.FixDiscountPolicy;
import jiwon.core.discount.RateDiscountPolicy;
import jiwon.core.member.MemberService;
import jiwon.core.member.MemberServiceImpl;
import jiwon.core.member.MemoryMemberRepository;
import jiwon.core.order.OrderService;
import jiwon.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
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
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
