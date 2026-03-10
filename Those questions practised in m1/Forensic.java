import java.util.*;
import java.sql.Date;
class ForensicReport{
    private Map<String,Date> reportMap=new HashMap<>();

    public Map<String, Date> getReportMap() {
        return reportMap;
    }

    public void setReportMap(Map<String, Date> reportMap) {
        this.reportMap = reportMap;
    }
    public void addReportDetails(String reportingOfficerName, Date reportFiledDate){
        reportMap.put(reportingOfficerName,reportFiledDate);
    }
    public List<String> getOfficersWhoFiledReportsOnDate(Date reportFiledDate) {
        List<String> res=new ArrayList<>();
        for(Map.Entry<String,Date> e:reportMap.entrySet()){
            if(e.getValue().equals(reportFiledDate)){
                res.add(e.getKey());
            }
        }
        return res;
    }

}
public class Forensic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ForensicReport fr = new ForensicReport();

        System.out.println("Enter number of reports to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the Forensic reports (Reporting Officer: Report Filed Date)");

        for(int i=0;i<n;i++){

            String input = sc.nextLine();

            String[] arr = input.split(":");

            String officer = arr[0];

            Date date = Date.valueOf(arr[1]);

            fr.addReportDetails(officer, date);
        }

        System.out.println("Enter the filed date to identify the reporting officers");

        Date searchDate = Date.valueOf(sc.nextLine());

        List<String> officers = fr.getOfficersWhoFiledReportsOnDate(searchDate);

        if(officers.isEmpty()){

            System.out.println("No reporting officer filed the report");

        }
        else{

            System.out.println("Reports filed on the "+searchDate+" are by");

            for(String name : officers){
                System.out.println(name);
            }

        }
    }
}
