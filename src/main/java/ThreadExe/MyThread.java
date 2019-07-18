package ThreadExe;

public class MyThread extends Thread{

    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("current " + Thread.currentThread().getId() + " id:" + i);
        }
    }

    public static void main(String[] args){
        MyThread mythread = new MyThread();
        mythread.start();
        MyThread mythread2 = new MyThread();
        mythread2.start();

        for(int i=0; i<3; i++){

        }
    }


    class Business{

    }
}
