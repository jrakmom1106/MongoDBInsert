import com.mongodb.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class KafkaMongoDBInsert {
    public static void main(String[] args) {


        Timer jobScheduler = new Timer();

        TimerTask task = new TimerTask() {

            Integer count = 0;
            Mongodb mongo = new Mongodb();

            @Override
            public void run() {
                String date = NowTimer();
                String rand = RandomString();

                count++;

                Map<String, Object> documentMap = new HashMap<String, Object>();
                documentMap.put("id", count);
                documentMap.put("time", date);
                documentMap.put("data", rand);

                //Insert Data03

                DBCollection collection = mongo.selectMongo();
                collection.insert(new BasicDBObject(documentMap));

                System.out.println("collection = " + documentMap);


            }
        };

        jobScheduler.scheduleAtFixedRate(task, 1000, 3000);


    }

    public static String NowTimer() {

        Date date = new Date();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime1 = sdf1.format(date);

        return nowTime1;
    }

    public static String RandomString() {

        String[] items = {"testdata1", "testdata2", "testdata3", "testdata4"};
        Random rand = new Random();
        String result = items[rand.nextInt(4)];


        return result;
    }

}
