import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(course_name)/MAX(MONTH(subscription_date)) AS coeff_sales FROM PurchaseList WHERE subscription_date BETWEEN '2018-01-01' AND '2018-12-31' GROUP BY course_name");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("course_name") + " - " + resultSet.getString("coeff_sales"));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
