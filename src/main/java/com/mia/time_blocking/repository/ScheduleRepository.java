package com.mia.time_blocking.repository;

import com.mia.time_blocking.dto.ScheduleUpdateRequest;
import com.mia.time_blocking.entity.Category;
import com.mia.time_blocking.entity.Schedule;
import com.mia.time_blocking.type.YesNo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {
    private final EntityManager em;

    /**
     * 스케줄 목록 조회 (오늘치)
     */
    public List<Schedule> findAllByToday(Long userId) {
        //카테고리와 스케줄 조인
        return em.createQuery("select s from Schedule s inner join s.category c inner join c.user u where u.id = :userId", Schedule.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    /**
     * 일정을 상세 조회합니다.
     * @param scheduleId
     * @return Schedule
     */
    public Schedule findOne(Long scheduleId) {
        return em.find(Schedule.class, scheduleId);
    }

    public Long add(Schedule schedule) {
        em.persist(schedule);
        return schedule.getId();
    }

    public void updateCompleteYn(Long id, YesNo completeYn) {
        Schedule findSchedule = Optional.ofNullable(em.find(Schedule.class, id))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 일정입니다."));
        findSchedule.setCompleteYn(completeYn);
    }

    public void update(ScheduleUpdateRequest updateRequest) {
        Schedule findSchedule = Optional.ofNullable(em.find(Schedule.class, updateRequest.id()))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 일정입니다."));
        findSchedule.setTitle(updateRequest.title());
        findSchedule.setBgngTime(updateRequest.bgngTime());
        findSchedule.setEndTime(updateRequest.endTime());
        findSchedule.setMemo(updateRequest.memo());
        Category category = Optional.ofNullable(em.find(Category.class, updateRequest.categoryId()))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
        findSchedule.setCategory(category);
        findSchedule.setPriority(updateRequest.priority());
    }

    public void delete(Long id) {
        Schedule findSchedule = Optional.ofNullable(em.find(Schedule.class, id))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 일정입니다."));
        findSchedule.setUseYn(YesNo.N);
    }

}
