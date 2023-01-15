import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

import java.util.Date;
import java.util.List;

public class MeetingSite {

    private Jedis jedis;
    List<Tuple> result;

    public MeetingSite(Jedis jedis) {
        this.jedis = jedis;
    }

    public void start() throws InterruptedException {
        initialization();
        printInConsole();
    }

    private void initialization(){
        removeKey();
        for (int i = 1; i < 20; i++) {
            jedis.zadd("Users", new Date().getTime(), String.valueOf(i));
        }
        ScanResult<Tuple> users = jedis.zscan("Users", "0");
        result = users.getResult();
    }

    private void printInConsole() throws InterruptedException {
        for (Tuple user : result) {
            System.out.println("На главной странице показываем пользователя " + user.getElement());
            Thread.sleep(1000);
            if (Math.random() < 0.1) {
                paidShow();
            }
        }
        printInConsole();
    }

    private void paidShow() throws InterruptedException {
        int i = (int) (result.size() * Math.random());
        String user = result.get(i).getElement();
        System.out.println("Пользователь " + user + " оплатил платную услугу");
        System.out.println("На главной странице показываем пользователя " + user);
        Thread.sleep(1000);
    }

    private void removeKey() {
        jedis.del("Users");
    }
}
