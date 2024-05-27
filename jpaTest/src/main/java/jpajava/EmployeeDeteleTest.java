package jpajava;

import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDeteleTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            System.out.println("transaction started");
            Employee employee = em.find(Employee.class, "202403");
            em.remove(employee);
            System.out.println("before commit");
            tx.commit();
            System.out.println("after commit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }
    }
}
