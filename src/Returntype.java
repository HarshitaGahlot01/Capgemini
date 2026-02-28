public class Returntype {
    public static void main(String[] args) {
        String i[]=returnstring();
        for(int j=0;j<i.length;j++){
            System.out.println(i[j]);
        }
    }
    public static String [] returnstring(){
        String str[]={"hello", "blue"};
        return str;
    }
}
