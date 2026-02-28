import java.util.*;
public class MockQues {
    public static void main(String[] args) {
        List<List<String>> logs = new ArrayList<>();

        logs.add(Arrays.asList("01-01-2023", "14:00", "ERROR", "failed"));
        logs.add(Arrays.asList("01-01-2023", "15:00", "INFO", "ok"));
        logs.add(Arrays.asList("01-01-2023", "01:30", "ERROR", "failed"));
        logs.add(Arrays.asList("02-01-2023", "09:00", "CRITICAL", "disk"));

        List<List<String>> result = extractErrorLogs(logs);

        for (List<String> log : result) {
            System.out.println(String.join(" ", log));
        }
    }
    public static List<List<String>> extractErrorLogs(List<List<String>> logs){
        List<List<String>> res=new ArrayList<>();
        for(List<String> log:logs) {
            String stat = log.get(2);
            if (stat.equals("ERROR") || stat.equals("CRITICAL")) {
                res.add(log);
            }
        }
        Collections.sort(res,(a,b)->{
            String A=helper(a);
            String B=helper(b);
            return helper(a).compareTo(helper(b));

        });
        return res;
    }
        private static String helper(List<String> log){
            String d[]=log.get(0).split("-");
            String date=d[2]+d[1]+d[0];
            String t=log.get(1).replace(":","");
            return date+t;
        }
    }

