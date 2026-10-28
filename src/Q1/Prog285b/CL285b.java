package Q1.Prog285b;

public class CL285b implements Comparable<CL285b> {
    private int id;
    private int code;
    private double sales;
    private double com;
    private void calc(){
        if(id==5||id==8){
            if(sales>=5000)
            {
                com=(sales-5000)*
            }
        }
    }
    public CL285b(int id,int code,double sales){
        this.id=id;
        this.com=0;
        this.code=code;
        this.sales=sales;
        calc();
    }
    public String toString(){
        return String.format("%d\t%d\t\t$.2f\t$%.2f",id,code,sales,com);
    }
    public int compareTo(CL285b o){
        return id-o.id;
    }
}
