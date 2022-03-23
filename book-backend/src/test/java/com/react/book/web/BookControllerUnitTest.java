package com.react.book.web;

//단위 테스트 (Controller 관련 로직만 띄우기)

import com.react.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@WebMvcTest
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //IoC 환경에 bean등록됨
    private BookService bookService;

    public void save_test() {
        log.info("===================save_test() 시작=========================");
    }
}
