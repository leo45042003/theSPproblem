package sp;

/**
 * Created by leo45042003 on 2017/1/5.
 */
public class Swimmer extends Thread{
    String name;
    int dressUpTime;
    int swimmingTime;
    Cubicle cubicle;
    Basket basket;

    public Swimmer(String name, Cubicle c, Basket b, int dressUp, int swimming){
        this.name = name;
        this.cubicle = c;
        this.basket = b;
        this.dressUpTime = dressUp;
        this.swimmingTime = swimming;
    }

    public void dressUp(int time){
        for(int i=0; i<time; i+=2){
            System.out.println(name + " is dressing up.");
        }
    }
    public void swimming(int time){
        for(int i=0; i<time; i+=2){
            System.out.println(name + " is swimming.");
        }
    }

    //override Thread.run()
    public void run(){
        try{
            System.out.println("Swimmer " + name + " entered.");
            cubicle.toWait(name, true);

            dressUp(dressUpTime);
            basket.toWait(name);

            cubicle.signal(name, true);

            swimming(swimmingTime);

            cubicle.toWait(name, false);
            basket.signal(name);

            dressUp(dressUpTime);

            cubicle.signal(name, false);
            System.out.println("Swimmer " + name + " left.");
        }
        catch (Exception e){System.out.println(e);}
    }

}
