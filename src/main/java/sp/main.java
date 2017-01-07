/**
 * Created by leo45042003 on 2017/1/5.
 */

package sp;

public class main {
    public static void main(String[] args) throws InterruptedException{
        Cubicle c = new Cubicle(2);
        Basket b = new Basket(1);

        int i=1;
        while(i<1000){
            new Swimmer("Thread"+i, c, b, getRandomTime(), getRandomTime()).start();

            Thread.currentThread().sleep(getWaitingTime(0.25));
            i++;
        }
    }

    public static int getRandomTime(){
        return (int)(Math.random()*10+1);
    }

    public static int getWaitingTime(double rateParameter){
        double result = -Math.log(1.0 - Math.random()) / rateParameter * 1;
        return (int)result;
    }
}
