package Q1;
public class bank2 {
    public double amount;
    public double years;
    public double intrests;
    public bank2(double am,double year,double intrest){
        amount=am;
        years=year;
        intrests=intrest;
    }
    public double calc()
    {
        return amount/(1+years * intrests);
    }
}
