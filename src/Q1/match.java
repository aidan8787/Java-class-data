package Q1;
public class match {
    public int myval;
    public int myid;
    public match(int id,int val)
    {
        myval=val;
        myid=id;
    }
    public int getval(){
        return myval;
    }
    public int getid(){
        return myid;
    }
    public String toString(){
        return myid+"       "+myval;
    }
}
