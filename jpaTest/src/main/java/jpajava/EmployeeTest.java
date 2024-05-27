package jpajava;

import entity.EmpType;
import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            System.out.println("transaction begin");
            Employee employee =
                    new Employee("202404","won", "it", EmpType.B, "2024-05-24", 300L);
            System.out.println("비영속");
            System.out.println("before first cash");
            em.persist(employee);
            System.out.println("영속");
            System.out.println("after first cash");
            Employee employee1 = em.find(Employee.class, "202404");
            System.out.println("emp1, 1차 캐시 가져옴");
            System.out.println("before commit");
            tx.commit();
            System.out.println("commit completed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
            System.out.println("rollback completed");
        }

        em.close();
        emf.close();

    }
}
