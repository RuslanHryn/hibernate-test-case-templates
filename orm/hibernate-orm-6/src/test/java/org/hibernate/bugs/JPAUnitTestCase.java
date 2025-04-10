package org.hibernate.bugs;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
    }

    @AfterEach
    void destroy() {
        entityManagerFactory.close();
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    void hhh123Test2() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityTwo entityTwo = new EntityTwo();
        entityTwo.setRef("ref2");

        entityManager.persist(entityTwo);

        EntityOne entityOne = new EntityOne();
        entityOne.setRef("ref1");
        entityOne.setEntityTwo(entityTwo);
        entityTwo.setEntityOne(entityOne);

        entityManager.persist(entityOne);

        entityManager.flush();
        entityManager.clear();

        List<EntityTwo> result = entityManager.createQuery("select entityTwo\n"
                        + "from EntityTwo entityTwo\n", EntityTwo.class)
                .getResultList();

        Assertions.assertEquals(1, result.size());

        entityManager.close();
    }

    @Test
    void hhh123Test3() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityTwo entityTwo = new EntityTwo();
        entityTwo.setRef("ref2");

        entityManager.persist(entityTwo);

        EntityOne entityOne = new EntityOne();
        entityOne.setRef("ref1");
        entityOne.setEntityTwo(entityTwo);
        entityTwo.setEntityOne(entityOne);

        entityManager.persist(entityOne);

        entityManager.flush();
        entityManager.detach(entityOne);
        entityManager.detach(entityTwo);

        List<EntityTwo> result = entityManager.createQuery("select entityTwo\n"
                        + "from EntityTwo entityTwo\n", EntityTwo.class)
                .getResultList();

        Assertions.assertEquals(1, result.size());

        entityManager.close();
    }

    @Test
    void hhh123Test() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityTwo entityTwo = new EntityTwo();
        entityTwo.setRef("ref2");

        entityManager.persist(entityTwo);

        EntityOne entityOne = new EntityOne();
        entityOne.setRef("ref1");
        entityOne.setEntityTwo(entityTwo);
        entityTwo.setEntityOne(entityOne);

        entityManager.persist(entityOne);

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        entityManager2.getTransaction().begin();
        entityManager2.flush();

        List<EntityTwo> result = entityManager2.createQuery("select entityTwo\n"
                        + "from EntityTwo entityTwo\n", EntityTwo.class)
                .getResultList();

        Assertions.assertEquals(1, result.size());

        entityManager2.getTransaction().commit();
        entityManager2.close();
    }


}
