package com.react.book.web;

//통합 테스트 (모든 bean들을 똑같이 IoC에 올리고 테스트 하는 것
//SpringBootTest.WebEnvironment.MOCK //실제 톰캣을 올리는게 아니라 다른 톰캣으로 테스트
//SpringBootTest.WebEnvironment.RANDOM_PORT 실제 톰캣으로 테스트
//@Transactional 각각의 테스트 함수가 종료될 때마다 트랜잭션을 rollback 해주는 어노테이션
//@AutoConfigureMockMvc MockMvc를 IoC에 등록

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BookControllerIntergreTest {

    @Autowired
    private MockMvc mockMvc;

}
