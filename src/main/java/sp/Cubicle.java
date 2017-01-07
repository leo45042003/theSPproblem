package sp;

/**
 * Created by leo45042003 on 2017/1/5.
 */
public class Cubicle{
    int totalNumber;
    int available;
    int futureNeed;

    public Cubicle(int n){
        this.totalNumber = n;
        this.available = n;
    }

    public synchronized void toWait(String name, Boolean isArrival)throws InterruptedException{
        System.out.println(name + " try to take a Cubicle, now Cubicle: " + available+", future need: " + futureNeed);
        if(isArrival){
            while (available <= futureNeed || available <= 0){
                System.out.println(name + " is going to wait for Cubicle.================");
                wait();
                System.out.println(name + " is waken up for Cubicle.================");
            }
            futureNeed++;
            available--;
            System.out.println("******"+ name + " took a Cubicle, now Cubicle: " + available +", future need: " + futureNeed+"******");
        }
        //departure
        else{
            while(available <= 0){
                System.out.println(name + " is going to wait for Cubicle.================");
                wait();
                System.out.println(name + " is waken up.================");
            }
            available--;
            System.out.println("******"+ name + " took a Cubicle, now Cubicle: " + available +", future need: " + futureNeed+"******");
        }
//
//        if(isArrival && available>0){
//            while(available <= futureNeed){
//                System.out.println(name + " is going to wait for Cubicle.================");
//                wait();
//                System.out.println(name + " is waken up.================");
//            }
//            futureNeed++;
//            available--;
//            System.out.println("******"+ name + " took a Cubicle, now Cubicle: " + available +", future need: " + futureNeed+"******");
//        }else{
//            available--;
//            System.out.println("******"+ name + " took a Cubicle, now Cubicle: " + available +", future need: " + futureNeed+"******");
//        }
    }

    public synchronized void signal(String name, Boolean isArrival)throws InterruptedException{
        available++;
        if(!isArrival){futureNeed--;}
        System.out.println("~~~~~~"+ name + " released a Cubicle, now Cubicle: " + available +", future need: " + futureNeed+"~~~~~~");
        notify();
    }
}
