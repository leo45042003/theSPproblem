package sp;

/**
 * Created by leo45042003 on 2017/1/5.
 */
public class Basket extends Resource {
    int totalNumber;
    int available;
    private final Object lock = new Object();

    public Basket(int n){
        this.totalNumber = n;
        this.available = n;
    }

    public synchronized void toWait(String name)throws InterruptedException{
        System.out.println(name + " try to take a Basket, now Basket: " + available);
        while(available<=0){
            System.out.println(name + " is going to wait for Basket.================");
            wait();
            System.out.println(name + " is waken up for Basket.================");
        }
        available--;
        System.out.println("******"+ name + " took a Basket, now Basket: " + available +"******");
    }

    public synchronized void signal(String name)throws InterruptedException{
        available++;
        notify();
        System.out.println("~~~~~~"+ name + " released a Basket, now Basket: " + available +"~~~~~~");
    }

}
