import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 1);
        System.out.println(course.getName() + " - count of students - " + course.getStudentCount());

        Session sessionTeachers = sessionFactory.openSession();
        Teacher teacher = sessionTeachers.get(Teacher.class, 1);
        System.out.println(teacher.getName() + " - " + teacher.getAge() + " - " + teacher.getSalary());

        sessionFactory.close();

/*
        List<Student> studentList = course.getStudents();
        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        Subscription subscription = session.get(Subscription.class, new Key(91, 45));
        System.out.println(subscription.getCourseId() + " - " + subscription.getSubscriptionDate());
*/

/*
        Transaction transaction = session.beginTransaction();
        Course course3 = session.get(Course.class, 47);
        session.delete(course3);
        transaction.commit();
 */

/*
        Transaction transaction = session.beginTransaction();
        Course course2 = session.get(Course.class, 47);
        course2.setName("NEW new course");
        session.save(course2);
        transaction.commit();
 */

/*
        Transaction transaction = session.beginTransaction();

        Course course1 = new Course();
        course1.setName("New course");
        course1.setType(CourseType.MANAGEMENT);
        course1.setTeacherId(4);
        session.save(course1);

        transaction.commit();
 */
    }
}
