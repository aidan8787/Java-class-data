 package Q1;
 import java.util.*;
 import java.io.*;
 class student{
    public String myname;
    public double  score1;
    public double score2;
    public double score3;
    public double score4;
    public double score5;
    public double avg;
    public  student(String name,double s1,double s2, double s3, double s4, double s5)
    {
     myname=name;
     score1=s1;
     score2=s2;
     score3=s3;
     score4=s4;
     score5=s5;
     avg=(s5+s4+s3+s2+s1)/5;
    }
    public double gettest1()
    {
        return score1;
    }
    public double gettest2()
    {
        return score2;
    }
    public double gettest3()
    {
        return score3;
    }
    public double gettest4()
    {
        return score4;
    }
    public double gettest5()
    {
        return score5;
    }
    public String getgrade()
    {
        if(avg>=90)
        {
            return "A";
        }else if(avg>=80){
            return "B"; 
        }else if(avg>=70){
            return"C";
        }else if(avg>=60)
        {
            return "D";
        }
        return "F";
    }
    public String toString(){
        return myname+"  "+score1+"  "+score2+"  "+score3+"  "+score4+"  "+score5+"  "+avg+"  "+getgrade();
    }
 }
 public class prog505b
 {
  public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog505b.dat"));
             ArrayList<student> stu= new ArrayList<student>();  
            while (file.hasNext()) {
              String name= file.next();
              name=name+" "+file.next();
              double s1=file.nextDouble();
              double s2=file.nextDouble();
              double s3=file.nextDouble();
              double s4=file.nextDouble();
              double s5=file.nextDouble();
              student s=new student(name, s1, s2, s3, s4, s5);
              stu.add(s);
            }
            file.close();
            int cnta=0;
            int cntb=0;
            int cntc=0;
            int cntd=0;
            int cntf=0;
            int cntscores=0;
            double score1=0.0;
            double score2=0.0;
            double score3=0.0;
            double score4=0.0;
            double score5=0.0;
            for(var s:stu){
                System.out.println(s.toString());
                if(s.getgrade().equals("A")){
                    cnta++;
                }else if(s.getgrade().equals("B")){
                    cntb++;
                }else if(s.getgrade().equals("C")){
                    cntc++;
                }else if(s.getgrade().equals("D")){
                    cntd++;
                }else if(s.getgrade().equals("F")){
                    cntf++;
                }
                cntscores++;
                score1+=s.gettest1();
                score2+=s.gettest2();
                score3+=s.gettest3();
                score4+=s.gettest4();
                score5+=s.gettest5();
            }
            System.out.print( "Test 1:         ");
            System.out.printf("%.2f",score1/cntscores);
            System.out.println("           A:   "+cnta);
            System.out.print( "Test 2:         ");
            System.out.printf("%.2f",score2/cntscores);
            System.out.println("           B:   "+cntb);
            System.out.print( "Test 3:         ");
            System.out.printf("%.2f",score3/cntscores);
            System.out.println("           C:   "+cntc);
            System.out.print( "Test 4:         ");
            System.out.printf("%.2f",score4/cntscores);
            System.out.println("           D:   "+cntd);
            System.out.print( "Test 5:         ");
            System.out.printf("%.2f",score5/cntscores);
            System.out.println("           F:   "+cntf);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
  }
 }
 /*
Sam Lilly  80.0  77.0  82.0  86.0  90.0  83.0  B
Fred Biggie  70.0  72.0  88.0  90.0  93.0  82.6  B
Sally Awesome  92.0  91.0  85.0  99.0  93.0  92.0  A
Test 1:         80.67           A:   1
Test 2:         80.00           B:   2
Test 3:         85.00           C:   0
Test 4:         91.67           D:   0
Test 5:         92.00           F:   0 
*/