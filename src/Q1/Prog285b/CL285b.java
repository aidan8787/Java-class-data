package Q1.Prog285b;

public class CL285b implements Comparable<CL285b> {
    private int id;
    private int code;
    private double sales;
    private double com=0;
    private void calc(){
        double sale=sales;
        if(code==5||code==8){
            if(sales>=5000)
            {
                com+=(sale-5000)*.085;
                com+=5000*.075;
            }else{
            com+=sales*.075;
            }
        }else{
        if(code==17){
            if(sales>=3500)
            {
                com+=(sale-3500)*.12;
                com+=3500*.095;
            }else{
            com+=sales*.12;
            }
            }else{
        com=0;
        }
        }
    }
    public CL285b(int i,int c,double sale){
        id=i;
        com=0;
        code=c;
        sales=sale;
        calc();
    }
    public String toString(){
        return String.format("%d\t%d\t$%.2f\t\t$%.2f",id,code,sales,com);
    }
    public int compareTo(CL285b o){
        return id-o.id;
    }
}