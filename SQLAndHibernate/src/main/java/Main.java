import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Subscription subscription = session.get(Subscription.class, new Key(1, 2));
        System.out.println(subscription.getCourse().getId() + " - " + subscription.getCourse().getName()
                            + " - " + subscription.getCourse().getStudents());

        Purchaselist purchaselist = session.get(Purchaselist.class, new KeyPL("Шведов Юрий", "Figma"));
        System.out.println(purchaselist.getPrice());

        transaction.commit();
        sessionFactory.close();
    }
}
