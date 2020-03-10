package codes.crazy.study16;

/**
 *守护线程：在后台运行的，如果前台线程全部死亡，后台线程会自动死亡
 *前台线程创建的线程默认是前台线程，后台线程创建的线程默认是后台线程。
 *
 *
 *
 *
 *
 */



public class DaemonThread extends Thread {
    //定义后台线程的线程执行体与普通线程没有区别
    @Override
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println(getName()+" "+i);
        }

    }

    public static void main(String[] args) {
        DaemonThread t=new DaemonThread();
        //将此线程设置为后台线程
        t.setDaemon(true);
        //启动后台线程
        t.start();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        //程序执行到此处结束
        //后台线程也随之结束

    }

}





/*
前台线程死亡后，JVM会通知后台线程死亡，但从它接受指令到做出响应，需要一定时间
setDaemon()必须在启动线程前完成。

 */

