package com.example.spring.jpa.entity;

import jakarta.persistence.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class StudentTest {
    @PersistenceUnit
    private EntityManagerFactory emf;

    private EntityManager entityManager;
    private EntityTransaction transaction;

    @BeforeEach
    void setUp() {
        entityManager = emf.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @AfterEach
    void tearDown() {
        transaction.commit();
        entityManager.close();
    }

    @Test
    @DisplayName("1차 캐시")
    void first_cache() {
        //given
        Student student = Student.builder()
                .age(10)
                .name("홍길동")
                .build();

        entityManager.persist(student);
        //when
        Student foundStudent = entityManager.find(Student.class, student.getId());
        //then
        assertThat(student).isEqualTo(foundStudent);
    }

    @Test
    @DisplayName("지연 쓰기")
    void lazy_write() {
        //given
        Student student1 = Student.builder()
                .age(10)
                .name("홍길동")
                .build();

        Student student2 = Student.builder()
                .age(10)
                .name("김춘추")
                .build();

        entityManager.persist(student1);
        entityManager.persist(student2);
        //when & then
        System.out.println("아직 쓰기 작업 안함");
    }

    @Test
    @DisplayName("변경 감지")
    void dirty_checking() {
        //given
        Student student = Student.builder()
                .age(10)
                .name("홍길동")
                .build();

        entityManager.persist(student);
        //when
        student.setName("이순신");
        //then
        assertThat(student.getName()).isEqualTo("이순신");
    }

    @Test
    @DisplayName("준영속")
    void detach() {
        //given
        Student student = Student.builder()
                .age(10)
                .name("홍길동")
                .build();

        entityManager.persist(student);
        //when
        entityManager.detach(student);
        //then
        assertThat(entityManager.contains(student)).isFalse();
    }

    @Test
    @DisplayName("영속송 컨텍스트 초기화")
    void clear() {
        //given
        Student student1 = Student.builder()
                .age(10)
                .name("홍길동")
                .build();

        Student student2 = Student.builder()
                .age(10)
                .name("김춘추")
                .build();

        entityManager.persist(student1);
        entityManager.persist(student2);
        //when
        entityManager.clear();
        //then
        assertThat(entityManager.contains(student1)).isFalse();
        assertThat(entityManager.contains(student2)).isFalse();
    }

    @Test
    @DisplayName("병합")
    void merge() {
        //given
        EntityManager entityManager2 = emf.createEntityManager();
        EntityTransaction entityManager2transaction = entityManager2.getTransaction();
        entityManager2transaction.begin();

        Student student = Student.builder()
                .age(10)
                .name("홍길동")
                .build();

        entityManager2.persist(student);

        entityManager2transaction.commit();
        entityManager2.close();

        student.setName("이순신");
        //when
        Student mergeStudent = entityManager.merge(student);
        //then
        assertThat(entityManager.contains(student)).isFalse();
        assertThat(entityManager.contains(mergeStudent)).isTrue();
    }
}