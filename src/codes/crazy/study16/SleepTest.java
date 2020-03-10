package codes.crazy.study16;

import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepTest {
    public static void main(String[] args) throws  Exception{
        Date currentTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(int i=0;i<10;i++){
            System.out.println("当前时间:"+df.format(currentTime));
            currentTime=new Date();
            Thread.sleep(2000);
        }
    }
}
