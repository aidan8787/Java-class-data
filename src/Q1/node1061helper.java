package Q1;

public class node1061helper {
    public node1061h myroot;
  public node1061helper(node1061h root)
  {
    myroot=root;
  }
  public void add(String data){
   node1061h n=new node1061h(data);
   node1061h temp=myroot;
   if(myroot==null)
   {
    myroot=temp;
   }
   while(temp.mynext!=null){
    String str=temp.getdata();
    if(str.compareTo(data)<0)
    {
     temp=temp.mynext;
    }else{
     node1061h hold=temp.mynext;
     temp.mynext=n;
     n.mynext=hold;
    }
   }
   temp.mynext=n;
  }
 public void delete(String data)
 {
   node1061h n=new node1061h(data);
   node1061h temp=myroot;
   if(myroot==null)
   {
    myroot=temp;
   }
   while(temp.mynext!=null){
    String str=temp.getdata();
    if(str.compareTo(data)==0)
    {
    if(temp.mynext.mynext!=null)
    {
     temp.mynext=temp.mynext.mynext;
    }else{
     node1061h hold=temp.mynext;
     temp.mynext=n;
     n.mynext=hold;
    }
  }
}
 }
  public String Print()
  {
    String str="";
     node1061h temp=myroot;
     str+=temp.toString()+" ";
    while(temp.mynext!=null){
    temp=temp.mynext;
    str+=temp.toString()+" ";
   }
    return str;
  }
}