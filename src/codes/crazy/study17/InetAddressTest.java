package codes.crazy.study17;

import java.net.InetAddress;


/**
 * getByName(String s)：获得一个InetAddress 类的对象，该对象中含有主机的IP地址和域名，该对象用如下格式表示它包含的信息：www.sina.com.cn/202.108.37.40；
 * String getHostName()：获取InetAddress对象的域名；
 * String getHostAddress()：获取InetAddress对象的IP地址；
 * getLocalHost()：获得一个InetAddress对象，该对象含有本地机的域名和IP地址。
 *
 * InetAddress代表一个IP地址对象，是网络通信的基础
 */

public class InetAddressTest {
    public static void main(String[] args) throws  Exception{
        //根据主机名来获取相应的InetAddress实例
        InetAddress ip=InetAddress.getByName("www.baidu.com");
        //判断是否可达
        System.out.println("百度是否可达："+ip.isReachable(2000));
        //获取该InetAddress实例的IP字符串
        System.out.println(ip.getHostAddress());
        //根据原始IP地址获取对应的InetAddress实例
        InetAddress local=InetAddress.getByAddress(new byte[]{127,0,0,1} );

        System.out.println("本机是否可达:"+local.isReachable(2000));
        //获取该InetAddress实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());

    }
}
