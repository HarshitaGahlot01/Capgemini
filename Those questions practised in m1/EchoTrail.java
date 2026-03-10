import java.util.*;

class Trail {

    private String trailId;
    private String name;
    private String region;
    private String difficulty;
    private int hikeCount;

    public Trail(){}

    public Trail(String trailId,String name,String region,String difficulty,int hikeCount){
        this.trailId = trailId;
        this.name = name;
        this.region = region;
        this.difficulty = difficulty;
        this.hikeCount = hikeCount;
    }

    public String getTrailId(){
        return trailId;
    }

    public String getName(){
        return name;
    }

    public String getRegion(){
        return region;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public int getHikeCount(){
        return hikeCount;
    }

    public void setHikeCount(int hikeCount){
        this.hikeCount = hikeCount;
    }
}


class Util {

    private List<Trail> trailList = new ArrayList<>();

    public void addTrailRecord(Trail trail){
        trailList.add(trail);
    }


    // Requirement 2
    public Trail getTrailById(String trailId){

        for(Trail t : trailList){
            if(t.getTrailId().equals(trailId)){
                return t;
            }
        }

        return null;
    }


    // Requirement 3
    public Set<Trail> getMostHikedTrails(){

        Set<Trail> s = new HashSet<>();

        int max = 0;

        for(Trail t : trailList){
            if(t.getHikeCount() > max){
                max = t.getHikeCount();
            }
        }

        for(Trail t : trailList){
            if(t.getHikeCount() == max){
                s.add(t);
            }
        }

        return s;
    }


    // Requirement 4
    public Map<String,Integer> getHikeCountByRegion(){

        Map<String,Integer> m = new HashMap<>();

        for(Trail t : trailList){

            if(m.containsKey(t.getRegion())){
                m.put(t.getRegion(), m.get(t.getRegion()) + t.getHikeCount());
            }
            else{
                m.put(t.getRegion(), t.getHikeCount());
            }
        }

        return m;
    }


    // Requirement 5
    public Map<String,List<Trail>> groupTrailsByDifficulty(){

        Map<String,List<Trail>> m = new HashMap<>();

        for(Trail t : trailList){

            String diff = t.getDifficulty();

            if(m.containsKey(diff)){
                m.get(diff).add(t);
            }
            else{
                List<Trail> list = new ArrayList<>();
                list.add(t);
                m.put(diff,list);
            }
        }

        return m;
    }


    // Requirement 6
    public boolean updateHikeCount(String trailId,int additionalHikes){

        for(Trail t : trailList){

            if(t.getTrailId().equals(trailId)){

                t.setHikeCount(t.getHikeCount() + additionalHikes);

                return true;
            }
        }

        return false;
    }


    // Requirement 7
    public List<Trail> filterTrails(String region,String difficulty){

        List<Trail> list = new ArrayList<>();

        for(Trail t : trailList){

            if(t.getRegion().equals(region) && t.getDifficulty().equals(difficulty)){
                list.add(t);
            }
        }

        return list;
    }


    // Requirement 8
    public Map<String,List<Trail>> getTopTrailsByRegion(int n){

        Map<String,List<Trail>> map = new HashMap<>();

        // group by region
        for(Trail t : trailList){

            String region = t.getRegion();

            if(map.containsKey(region)){
                map.get(region).add(t);
            }
            else{
                List<Trail> list = new ArrayList<>();
                list.add(t);
                map.put(region,list);
            }
        }

        // sort and take top N
        for(String region : map.keySet()){

            List<Trail> list = map.get(region);

            Collections.sort(list,(a,b)-> b.getHikeCount() - a.getHikeCount());

            if(list.size() > n){
                list = list.subList(0,n);
                map.put(region,list);
            }
        }

        return map;
    }


    // Requirement 9
    public Map<String,String> getDifficultyStats(){

        Map<String,String> result = new HashMap<>();

        Map<String,Integer> count = new HashMap<>();
        Map<String,Integer> total = new HashMap<>();

        for(Trail t : trailList){

            String diff = t.getDifficulty();

            if(count.containsKey(diff)){
                count.put(diff,count.get(diff)+1);
                total.put(diff,total.get(diff)+t.getHikeCount());
            }
            else{
                count.put(diff,1);
                total.put(diff,t.getHikeCount());
            }
        }

        for(String diff : count.keySet()){

            int c = count.get(diff);
            int tot = total.get(diff);
            int avg = tot / c;

            String summary = "count="+c+", totalHikes="+tot+", averageHikes="+avg;

            result.put(diff,summary);
        }

        return result;
    }
}


public class EchoTrail {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Util util = new Util();

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String input = sc.nextLine();

            String arr[] = input.split(":");

            Trail t = new Trail(
                    arr[0],
                    arr[1],
                    arr[2],
                    arr[3],
                    Integer.parseInt(arr[4])
            );

            util.addTrailRecord(t);
        }

        // Example: check trail
        String id = sc.nextLine();

        Trail tr = util.getTrailById(id);

        if(tr != null){

            System.out.println(
                    tr.getTrailId()+" | "+
                            tr.getName()+" | "+
                            tr.getRegion()+" | "+
                            tr.getDifficulty()+" | "+
                            tr.getHikeCount()+" hikes"
            );
        }
        else{
            System.out.println("Trail Id "+id+" not found");
        }

    }
}