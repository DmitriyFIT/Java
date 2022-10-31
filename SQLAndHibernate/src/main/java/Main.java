import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hqlIdPurchase = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseList = session.createQuery(hqlIdPurchase).getResultList();
        ArrayList<Integer> idConnect = new ArrayList<>();

        for (PurchaseList purchase : purchaseList) {
            Query criteria = session.createQuery("FROM " + Student.class.getSimpleName() + " WHERE name = :nameStudent ");
            List<Student> students = criteria.setParameter("nameStudent", purchase.getKeyPL().getStudentName()).getResultList();
            idConnect.add(students.get(0).getId());

            criteria = session.createQuery("FROM " + Course.class.getSimpleName() + " WHERE name = :nameCourse ");
            List<Course> courses = criteria.setParameter("nameCourse", purchase.getKeyPL().getCourseName()).getResultList();
            idConnect.add(courses.get(0).getId());

            int studentId = 0;
            int courseId = 1;
            if (idConnect.size() == 2) {
                Transaction transaction = session.beginTransaction();
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setKeyLPL(idConnect.get(studentId), idConnect.get(courseId));
                session.saveOrUpdate(linkedPurchaseList);
                session.flush();
                transaction.commit();
                idConnect.clear();
            }
        }
        sessionFactory.close();
        registry.close();

/*
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

        query.select(root).where(builder.greaterThan(root.<Integer>get("price"), 100000))
                .orderBy(builder.desc(root.get("price")));
        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();

        for (Course course : courseList) {
            System.out.println(course.getName() + " - " + course.getPrice());
        }

        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
        List<Course> courseList1 = session.createQuery(hql).getResultList();
        for (Course course : courseList1) {
            System.out.println(course.getName() + " - " + course.getPrice());
        }
 */
/*
          Transaction transaction = session.beginTransaction();

        Subscription subscription = session.get(Subscription.class, new Key(1, 2));
        System.out.println(subscription.getCourse().getId() + " - " + subscription.getCourse().getName()
                            + " - " + subscription.getCourse().getStudents());

        PurchaseList purchaselist = session.get(PurchaseList.class, new KeyPL("Шведов Юрий", "Figma"));
        System.out.println(purchaselist.getPrice() + " - " + purchaselist.getStudentName());

        transaction.commit();

        sessionFactory.close();
*/
    }
}
