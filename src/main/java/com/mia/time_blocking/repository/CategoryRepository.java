package com.mia.time_blocking.repository;

import com.mia.time_blocking.entity.Category;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class CategoryRepository {
    private final EntityManager em;

    public List<Category> findAll(Long userId) {
        return em.createQuery("select c from Category c inner join c.User u where u.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }
    /** 단순 조회 **/
    public Category find(Long id) {
        return em.find(Category.class, id);
    }



}
