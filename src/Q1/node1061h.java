package Q1;
public class node1061h {
    public String data;
    public node1061h mynext;
    public node1061h(String x)
    {
        data=x;
    }
    public String getdata()
    {
        return data;
    }
    public void setdata(String x)
    {
        data=x;
    }
    public String toString(){
        return ""+data;
    }
}