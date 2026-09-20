package Q1;
import java.io.*;
import java.util.*;
import java.text.*;
class SaleRecord{
    public String[] fields;

    public SaleRecord(String[] data){
        fields=data;
    }
        public double getProfit()
        {
         return Double.parseDouble(fields[13]);
        }
        public double getUnitsSold(){
         return Double.parseDouble(fields[8]);
        }
    
}
public class Prog1050a {
    
    public static List<SaleRecord> loadSaleData(String filepath)
    {
        var records=new ArrayList<SaleRecord>();
        try{
            var file=new Scanner(new File(filepath));
            file.nextLine();
            while(file.hasNextLine())
            {
                String line = file.nextLine();
                String[] data=line.split(",");
                records.add(new SaleRecord(data));


            }
            file.close();
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        return records;
    }
    public static void main(String[] args) {
        var records=loadSaleData("Langdat/Lang1050.csv");
        if(records!=null)
        {
            var moneyFormat= new DecimalFormat("$#,###.00");
            System.out.println("Sales to Europe: "+computeCount(records,0,"Europe"));
            System.out.println("Cereal bought by Cambodia: "+computeUnitsSold(records,1,"Cambodia",2,"Cereal"));
            System.out.println("Total profit on meat: "+moneyFormat.format(computeSum(records,2,"Meat")));
            System.out.println("High priority sales percentage: "+computePercentage(records,4,"H")+"% ");
            System.out.println("Fruits profit lost in 2012: "+moneyFormat.format(computeProfitLostIn2012(records,"Fruits")));
            System.out.println("High priority sales shipped >3 days late: " + computeHighPriorityLateSales(records));
            System.out.println("Country with the highest profit on personal care items: "+computeHighestProfit(records,2,"Personal Care"));
            System.out.println("Region that bought the most snacks: "+computeMaxByField(records,2,"Snacks",0));
        }
    }
    public static int computeCount(List<SaleRecord> records,int fileindex,String value){
        int count=0;
        for(var record: records)
        {
            if(record.fields[fileindex].equalsIgnoreCase(value)){
                count++;
            }
        }
        return count;
    }
       public static int computeCount(List<SaleRecord> records,int fileindex1,String value1,int findex2,String value2){
        int count=0;
        for(var record: records)
        {
            if(record.fields[fileindex1].equalsIgnoreCase(value1)&&record.fields[findex2].equalsIgnoreCase(value2)){
                count++;
            }
        }
        return count;
    }
    public static int computeUnitsSold(List<SaleRecord> records, int findex1,String value1, int findex2,String value2){
        int total=0;
        for(var record:records){
            if(record.fields[findex1].equalsIgnoreCase(value1) && record.fields[findex2].equalsIgnoreCase(value2))
            {
                total+=(int)record.getUnitsSold();
            }
        }
        return total;
    }
    public static double computeSum(List<SaleRecord> records, int findex,String value){
        double sum=0;
        for(var record:records)
        {
            if(record.fields[findex].equalsIgnoreCase(value))
            {
                sum+= record.getProfit();
            }
        }
        return sum;
    }
    public static double computePercentage(List<SaleRecord> records,int findex,String value){
        return ((double) computeCount(records,findex,value)/records.size())*100;
    }
    public static double computeProfitLostIn2012(List<SaleRecord> records,String itemtype)
    {
     double lostprofit=0;
     for(var record:records){
        if(record.fields[2].equalsIgnoreCase(itemtype)&&record.fields[5].endsWith("2012")){
            lostprofit+=record.getProfit();
        }
     }
     return lostprofit;
    }
    public static int computeHighPriorityLateSales(List<SaleRecord>records){
        int count=0;
        var dateFormat= new SimpleDateFormat("M/d/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        for(var record: records)
        {
            if(record.fields[4].equalsIgnoreCase("H")){
                try{
                   Date orderDate=dateFormat.parse(record.fields[5]);
                   Date shipDate=dateFormat.parse(record.fields[7]);
                   //Calculate the diffrence in order date and shipping date
                   long diffInMs=Math.abs(shipDate.getTime()-orderDate.getTime());//Milliseconds
                   long diffInDays=diffInMs/(1000*60*60*24);
                   if(diffInDays>3)
                   {
                    count++;
                   }
                }catch(ParseException e){
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
    public static String computeHighestProfit(List<SaleRecord> records,int findex,String itemtype){
        String highestCountry = "N/A";
        double highestProfit=0;
        for(var record : records){
            if(record.fields[findex].equalsIgnoreCase(itemtype)){
                double profit=record.getProfit();
                if(profit>highestProfit){
                    highestProfit=profit;
                    highestCountry=record.fields[1];
                }
            }
        }
        return highestCountry;
    }
     public static String computeMaxByField(List<SaleRecord> records,int findex,String itemtype,int resultfindex){
      String topRegion="N/A";
      int maxCount =0;
      var regions = new ArrayList<String>();
      // get all unique regions in the data set;
      for(var record: records){
        if(record.fields[findex].equalsIgnoreCase(itemtype)){
            String region=record.fields[resultfindex];
            if(!regions.contains(region))
            {
                regions.add(region);
            }
        }
      }
      // count occurences of each unique region
      for(var region: regions){
        int count=computeCount(records,findex,itemtype,resultfindex,region);
        if(count>maxCount){
            maxCount=count;
            topRegion=region;
        }
      }
      return topRegion;
     }
}
