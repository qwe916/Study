package com.example.spring.jpa.proxy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class ProxyTest {
    @PersistenceUnit
    private EntityManagerFactory emf;

    private EntityManager entityManager1;
    private EntityManager entityManager2;

    @BeforeEach
    void setUp() {
        entityManager1 = emf.createEntityManager();
        entityManager2 = emf.createEntityManager();
    }

    @Test
    @DisplayName("프록시 객체")
    void proxy_instance() {
        //given
        Member member = saveMember();
        //when
        EntityManager entityManager2 = emf.createEntityManager();
        Member foundMember = entityManager2.find(Member.class, member.getId());

        boolean isLoaded = emf.getPersistenceUnitUtil().isLoaded(foundMember.getTeam());
        //then
        assertThat(isLoaded).isTrue();
    }

    @Test
    @DisplayName("즉시 로딩")
    void eager_loading() {
        //given
        Member member = saveMember();
        //when
        Member foundMember = entityManager2.find(Member.class, member.getId());

        foundMember.getTeam();
    }

    @Test
    @DisplayName("지연 로딩")
    void lazy_loading() {
        //given
        Order order = saveOrder();
        //when
        Order foundOrder = entityManager2.find(Order.class, order.getId());
        //then
        assertThat(foundOrder.getOrderItems().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("고아 객체")
    void orphan_instance() {
        //given
        Order order = saveOrder();

        Order foundOrder = entityManager2.find(Order.class, order.getId());
        OrderItem orderItem = foundOrder.getOrderItems().get(0);
        //when
        deleteOrder(foundOrder);
        //then
        assertThat(entityManager2.find(OrderItem.class, orderItem.getId())).isNull();
    }

    private void deleteOrder(Order foundOrder) {
        entityManager2.getTransaction().begin();
        entityManager2.remove(foundOrder);
        entityManager2.getTransaction().commit();
    }

    private Order saveOrder() {
        EntityTransaction transaction = entityManager2.getTransaction();
        transaction.begin();

        Order order = new Order();

        OrderItem orderItem1 = new OrderItem("orderItem1");
        OrderItem orderItem2 = new OrderItem("orderItem2");

        order.getOrderItems().add(orderItem1);
        order.getOrderItems().add(orderItem2);

        entityManager2.persist(order);

        transaction.commit();
        entityManager2.clear();

        return order;
    }

    private Member saveMember() {
        EntityTransaction transaction = entityManager1.getTransaction();
        transaction.begin();

        Team team = new Team("TeamName");
        Member member = new Member(team);

        entityManager1.persist(member);

        transaction.commit();

        return member;
    }
}