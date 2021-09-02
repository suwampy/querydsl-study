package com.study.academy;

import com.study.domain.Academy;
import com.study.domain.AcademyRepository;
import com.study.domain.AcademyRepositorySupport;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
class BasicTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;

    @AfterEach
    public void tearDown() throws Exception {
        academyRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본_기능_확인() {
        //given
        String name = "jojoldu2";
        String address = "jojoldu2@gmail.com";
        academyRepository.save(new Academy(name, address));
        academyRepository.save(new Academy("name", "add"));
        academyRepository.save(new Academy("name2", "add2"));
        academyRepository.save(new Academy("name3", "add3"));

        //when
        List<Academy> result = academyRepositorySupport.findByName(name);

        //then
        System.out.println(result);
    }
}