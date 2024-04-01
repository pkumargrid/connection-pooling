import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.time.LocalTime;

public class Main {
    private final static String url = "jdbc:postgresql://localhost:5432/prakumar";
    private final static String password = "prakumar";
    private final static String userName = "prakumar";

    private final static Object lock = new Object();
    public static void main(String[] args) throws SQLException, InterruptedException {
//        ConnectionPool connectionPool = BasicConnectionPool.getConnectionPool(url, userName, password);
//        MyThread[] myThreads = new MyThread[15];
//        for(int i = 0; i < myThreads.length; i++) {
//            myThreads[i] = new MyThread((BasicConnectionPool) connectionPool);
//        }
//        LocalTime start = LocalTime.now();
//        for(MyThread myThread : myThreads) {
//            myThread.start();
//        }
//        for(MyThread myThread: myThreads) {
//            myThread.join();
//        }
//        long seconds = LocalTime.now().toSecondOfDay() - start.toSecondOfDay();
//        System.out.println(seconds);
//        connectionPool.shutdown();


          BuiltInConnectionPool builtInConnectionPool = new BuiltInConnectionPool(new ComboPooledDataSource());
          builtInConnectionPool.init(url);
          MyThreadModified[] myThreadModifiers = new MyThreadModified[15];
          for(int i = 0; i < myThreadModifiers.length; i++) {
              myThreadModifiers[i] = new MyThreadModified(builtInConnectionPool);
          }
          LocalTime localTime = LocalTime.now();
          for(MyThreadModified myThreadModified: myThreadModifiers) {
              myThreadModified.start();
          }
          for(MyThreadModified myThreadModified : myThreadModifiers) {
              myThreadModified.join();
          }
          System.out.println(LocalTime.now().toSecondOfDay() - localTime.toSecondOfDay());
    }
}
