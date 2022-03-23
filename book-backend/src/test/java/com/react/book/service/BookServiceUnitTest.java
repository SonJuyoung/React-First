package com.react.book.service;

import com.react.book.domain.BookRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//단위 테스트
//BoardRepository => 가짜 객체로 만들 수 있음 @Mock
//

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTest {

    @InjectMocks //해당 파일에 @Mock로 등록된 모든 것을 주입받는다
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;
}
