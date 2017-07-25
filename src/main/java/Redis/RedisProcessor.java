package Redis;
import Utils.PropertiesUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.util.Properties;

/**
 * Created by liangyuyi on 2017/7/25.
 */
public class RedisProcessor {
    private static String ADDR;//redis id
    private static int PORT;//端口
    private static String AUTH;//访问权限密码

    // 可用连接实例的最大数目，默认值为8；
    // 如果赋值为-1，则表示不限制；如果jedisPool已经分配了maxActive个jedis实例，则此时jedisPool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 2048;
    // 控制一个jedisPool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 500;
    // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static long MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    /**
     * 单例
     */
    public static class RedisMgrSingleton {
        /**
         * redis连接池
         **/
        private static JedisPool jedisPool;
    }

    static {
        Properties prop = PropertiesUtils.loadProperties(new File("Netty/src/main/resources/config/config.properties"));
        ADDR = prop.getProperty("redis.addr");
        PORT = Integer.valueOf(prop.getProperty("redis.port"));
        AUTH = prop.getProperty("redis.auth", null);
        if (RedisMgrSingleton.jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            RedisMgrSingleton.jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        }
    }

    public JedisPool jedisPool() {
        return RedisMgrSingleton.jedisPool;
    }
}
