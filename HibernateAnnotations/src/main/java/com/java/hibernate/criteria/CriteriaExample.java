//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;
//import java.util.List;
//
//public class CriteriaExample {
//    public static void main(String[] args) {
//        // Step 1: Configure Hibernate
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
//        Session session = factory.openSession();
//
//        try {
//            Transaction tx = session.beginTransaction();
//
//            // Step 2: Create Criteria
//            Criteria criteria = session.createCriteria(Student.class);
//            
//            // Step 3: Add Restrictions (WHERE age > 18)
//            criteria.add(Restrictions.gt("age", 18));
//
//            // Step 4: Execute Query
//            List<Student> students = criteria.list();
//
//            // Step 5: Print Results
//            for (Student s : students) {
//                System.out.println(s.getName() + " - " + s.getAge());
//            }
//
//            tx.commit();
//        } finally {
//            session.close();
//            factory.close();
//        }
//    }
//}
