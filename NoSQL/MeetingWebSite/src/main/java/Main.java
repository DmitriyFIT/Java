import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("localhost", 6379);

        MeetingSite site = new MeetingSite(jedis);
        site.start();
    }
}
