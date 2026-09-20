public class bank {
    public double principle;
    public double years;
    public double intrests;
    public bank(double prince,double year,double intrest){
        principle=prince;
        years=year;
        intrests=intrest;
    }
    public double calc()
    {
        return principle*(1+years * intrests);
    }
}
