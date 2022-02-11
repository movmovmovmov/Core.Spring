package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServicetest {

MemberService memberService;

@BeforeEach //각 테스트 실행 전 무조건 실행 2개 있으면 2개 실행
public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();

}

    @Test
    void join(){
        //given 이런게 주어졌을때
        Member member = new Member(1L,"memberA", Grade.VIP);


        //when 이때
        memberService.join(member);
        Member findMember = memberService.findMember(1L); //찾아서

        //then 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);



    }
}
