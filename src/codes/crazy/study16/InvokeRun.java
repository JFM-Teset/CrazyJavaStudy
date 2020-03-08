package codes.crazy.study16;
//线程的新建和就绪状态


public class InvokeRun  extends  Thread {
    private  int i;
    @Override
    public void run(){
        //
        //
        //
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            //调用Thread的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+" " + i);
            if(i == 20){
                new InvokeRun().start();
                new InvokeRun().start();
            }
        }
    }
}
