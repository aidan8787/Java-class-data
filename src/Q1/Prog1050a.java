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
            System.out.println("Sales to African nations: "+computeCount(records, 0, "Africa"));
            var newrecords=delete(records, 0, 4, "Africa", "L");
            newrecords=delete(newrecords, 1, "Kuwait");
            newrecords=delete(newrecords, 2, "Ofice Supplies");
            newrecords=limit(newrecords,1,"Uganda",2,"Cosmetics",100);
            System.out.println("Profit lost in the African Trade War: "+moneyFormat.format(profitLost(records,newrecords)));
        }
    }
    //Region,Country,Item Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit
    public static int computeCount(List<SaleRecord> records,int fileindex,String value){
        int count=0;
        for(var record: records)
        {
            if(record.fields[fileindex].contains(value)){
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
     public static List<SaleRecord> delete(List<SaleRecord> records,int findex,int findex2,String value1,String value2){
        var newrecord= new ArrayList<SaleRecord>();
        for(var record : records ){
        if(record.fields[findex].contains(value1)&&record.fields[findex2].equalsIgnoreCase(value2)){
         
        }else{
            newrecord.add(record);
        }
      }
      return newrecord;
     }
      public static List<SaleRecord> delete(List<SaleRecord> records,int findex,String value1){
        var newrecord= new ArrayList<SaleRecord>();
        for(var record : records ){
        if(record.fields[findex].contains(value1)){
         
        }else{
            newrecord.add(record);
        }
      }
      return newrecord;
     }
     public static double profitLost(List<SaleRecord> records,List<SaleRecord>newrecords){
        double profitLost=0;
        double profit=0;
        double profit2=0;
        for(var record:records)
        {
            profit+=record.getProfit();
        }
        for(var newrecord:newrecords)
        {
            profit2+=newrecord.getProfit();
        }
        profitLost=Math.abs(profit-profit2);
        return profitLost;
     }
    public static List<SaleRecord> limit(List<SaleRecord> records,int findex,String value1,int findex2,String value2,double lim){
        var newrecord= new ArrayList<SaleRecord>();
        var limit=lim;
        var desire=0.0;
        var priceper=0.0;
        var costper=0.0;
        for(var record : records ){
        if(record.fields[findex].contains(value1)&&record.fields[findex2].contains(value2)){
         desire=Double.parseDouble(record.fields[8]);
         priceper=Double.parseDouble(record.fields[9]);
        costper=Double.parseDouble(record.fields[10]);
         if(desire>limit)
         {
            record.fields[8]=String.valueOf(limit);
            record.fields[11]=String.valueOf(limit*priceper);
            record.fields[12]=String.valueOf(limit*costper);
            record.fields[13]=String.valueOf(Math.abs((limit*priceper)-(limit*costper)));
            if(limit>0)
            {
              newrecord.add(record);  
            }
            limit=limit-desire;
         }
        }else{
            newrecord.add(record);
        }
      }
      return newrecord;
     }
}
/*
Sales to Europe: 129286
Cereal bought by Cambodia: 1164596
Total profit on meat: $11,933,838,488.00
High priority sales percentage: 24.9974% 
Fruits profit lost in 2012: $67,345,418.37
High priority sales shipped >3 days late: 115166
Country with the highest profit on personal care items: Iceland
Region that bought the most snacks: Sub-Saharan Africa
Sales to African nations: 192442
Profit lost in the African Trade War: $32,279,673,402.08
 */