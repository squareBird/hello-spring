package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
DI는 3가지 방법이 있음
1. 필드주입 : 변경이 힘들어서 비추
2. 생성자 주입
3. setter 주입 : 누군가가 memberService를 호출했을때 public이어야함 public하게 노출이 됨 중간에 잘못바꿀경우 문제가 생김
*/

@Controller
public class MemberController {

    /*@Autowired private MemberService memberService;*/

/*
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
*/

    private final MemberService memberService;

    // 생성자를 통해서 들어오는 방법법
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
