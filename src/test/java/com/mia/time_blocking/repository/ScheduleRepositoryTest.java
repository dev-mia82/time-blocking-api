package com.mia.time_blocking.repository;

import com.mia.time_blocking.entity.Category;
import com.mia.time_blocking.entity.Schedule;
import com.mia.time_blocking.entity.User;
import com.mia.time_blocking.type.Color;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ScheduleRepositoryTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private ScheduleRepository scheduleRepository;


    @Test
    void findAllByToday() {
        //given
        //사용자 생성
        User user = User.builder().loginId("test").name("테스트").email("test.com").password("test").build();
        em.persist(user);
        //카테고리 생성
        Category category = Category.builder().name("일상").color(Color.RED).user(user).build();
        em.persist(category);
        //스케줄 생성
        Schedule schedule = new Schedule();
        schedule.setTitle("공부하기");
        schedule.setBgngTime(LocalTime.of(16, 0));
        schedule.setEndTime(LocalTime.of(18,0));
        schedule.setMemo("공부하기 테스트 중입니다.");
        schedule.setCategory(category);
        scheduleRepository.add(schedule);

        //when
        List<Schedule> schedules = scheduleRepository.findAllByToday(user.getId());

        //then
        Assertions.assertThat(schedules.size()).isEqualTo(1);
        Assertions.assertThat(schedules.get(0)).isEqualTo(schedule);
    }
}