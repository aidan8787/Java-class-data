public class cop {
    public double carspeed;
    public double speedlimit;
    public cop(double speed,double limit)
    {
       carspeed=speed;
       speedlimit=limit;
    }
    public double getfine(){
        double over=carspeed-speedlimit;
        if(over>0)
        {
        double fine= 20+(5*over);
        fine=((int)(fine*100+.5))/100.00;
        return fine;
        }
        return 0.00;
    }
}
