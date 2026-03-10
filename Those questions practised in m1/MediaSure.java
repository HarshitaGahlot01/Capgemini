import java.util.*;
abstract class DiagnosticTest{
    protected String testId;
    protected String testDate;
    protected int testPriority;

    public int getTestPriority() {
        return testPriority;
    }

    public DiagnosticTest(String testId, String testDate, int testPriority){
        this.testId=testId;
        this.testDate=testDate;
        this.testPriority=testPriority;
    }

    public String getTestId() {
        return testId;
    }

    public String getTestDate() {
        return testDate;
    }
    public abstract String equipmentSelection();
        public abstract double calculateFinalBill();
    }
    class BloodTest extends DiagnosticTest{
    private int sampleCount;
    private String testCategory;
    private double costPerSample;
    BloodTest(String testId,String testDate,int testPriority,int sampleCount,String testCategory,double costPerSample){
        super(testId,testDate,testPriority);
        this.sampleCount=sampleCount;
        this.testCategory=testCategory;
        this.costPerSample=costPerSample;
    }
    public String getTestCategory() {
            return testCategory;
        }

        public int getSampleCount() {
            return sampleCount;
        }
        public String equipmentSelection(){
        if(sampleCount<5){
            return "Analyzer";
        } else if(sampleCount>10){
            return "HighThroughputSystem";
        } else {
            return "AutoAnalyzer";
        }
        }

        @Override
        public double calculateFinalBill() {
           double baseCost=sampleCount * costPerSample;
           if(testCategory.equals("Advanced")){
               baseCost=baseCost*1.35;
           }
           double equipmentCost=0;
           String eq=equipmentSelection();
           if(eq.equals("Analyzer")) equipmentCost=800;
           else if(eq.equals("AutoAnalyzer")) equipmentCost=1500;
           else equipmentCost=2800;
           double tax=baseCost*0.18;
           double discountPer=0;
           if(testPriority==5) discountPer=0.20;
           else if(testPriority>=3) discountPer=0.10;
           double discount=baseCost*discountPer;
           return (baseCost+equipmentCost+tax)-discount;
        }

    }
    class ImagingTest extends DiagnosticTest{
    private String scanType;
    private int scanDuration;
    private double ratePerMin;
    public ImagingTest(String testId, String testDate, int testPriority,
                       String scanType, int scanDuration, double ratePerMinute){
        super(testId,testDate,testPriority);
        this.scanType=scanType;
        this.scanDuration=scanDuration;
        this.ratePerMin=ratePerMinute;
    }
    public String getScanType(){
        return scanType;
    }
    public String equipmentSelection(){
        if(scanDuration<20){
            return "BasicScanner";
        } else if(scanDuration>45){
            return "UltraScanner";
        } else{
            return "AdvancedScanner";
        }
    }
    public double calculateFinalBill(){
        double baseCost = scanDuration * ratePerMin;
        if(scanType.equals("MRI")) baseCost *= 1.5;
        else if(scanType.equals("CT")) baseCost *= 1.3;
        else if(scanType.equals("XRAY")) baseCost *= 1.1;
        String eq = equipmentSelection();

        double equipmentCost = 0;

        if(eq.equals("BasicScanner")) equipmentCost = 1000;
        else if(eq.equals("AdvancedScanner")) equipmentCost = 2000;
        else equipmentCost = 3500;
        double tax = baseCost * 0.25;

        double discountPercentage = 0;

        if(testPriority == 5) discountPercentage = 0.20;
        else if(testPriority >= 3) discountPercentage = 0.10;

        double discount = baseCost * discountPercentage;

        return (baseCost + equipmentCost + tax) - discount;
    }
    }
    class Utility1 {
        public static boolean validateTestid(String testId) {
            String reg = "^MED[0-9]{3}[A-Z]$";
            return testId.matches(reg);
        }

        public static DiagnosticTest parseDetails(String input) {
            String p[] = input.split(":");
            String testId = p[0];
            String testDate = p[1];
            int testPriority = Integer.parseInt(p[2]);
            String type = p[3];
            if (type.equals("BloodTest")) {
                int sampleCount = Integer.parseInt(p[4]);
                String category = p[5];
                double cost = Double.parseDouble(p[6]);
                return new BloodTest(testId, testDate, testPriority,
                        sampleCount, category, cost);
            } else {
                String scanType = p[4];
                int duration = Integer.parseInt(p[5]);
                double rate = Double.parseDouble(p[6]);

                return new ImagingTest(testId, testDate, testPriority,
                        scanType, duration, rate);
            }
        }

        public static String findTestType(DiagnosticTest test) {

            if (test instanceof BloodTest)
                return "BloodTest";
            else
                return "ImagingTest";
        }
    }
            public class MediaSure {

                public static void main(String[] args){

                    Scanner sc=new Scanner(System.in);

                    String input=sc.nextLine();

                    String id=input.split(":")[0];

                    if(!Utility1.validateTestid(id)){

                        System.out.println("Test id "+id+" is invalid");
                        System.out.println("Please provide a valid record");
                        return;
                    }

                    DiagnosticTest test=Utility1.parseDetails(input);

                    System.out.println("Test id : "+test.getTestId());
                    System.out.println("Date of test : "+test.getTestDate());
                    System.out.println("Test priority : "+test.getTestPriority());

                    String type=Utility1.findTestType(test);

                    if(type.equals("BloodTest")){

                        BloodTest bt=(BloodTest)test;

                        System.out.println("Test category : "+bt.getTestCategory());
                        System.out.println("Equipment used : "+bt.equipmentSelection());
                    }
                    else{

                        ImagingTest it=(ImagingTest)test;

                        System.out.println("Scan type : "+it.getScanType());
                        System.out.println("Equipment used : "+it.equipmentSelection());
                    }

                    System.out.println("Final bill : "+test.calculateFinalBill());
                }
            }

