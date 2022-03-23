package com.react.book.domain;

//단위 테스트 (db관련된 bean이 IoC에 등록되면 됨)

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) //가짜 db로 테스트, Replace.None : 실제 db로 테스트
@DataJpaTest //Repository들을 다 IoC로 등록함
public class BookRepositoryUnitTest {

    private BookRepository bookRepository;
}
