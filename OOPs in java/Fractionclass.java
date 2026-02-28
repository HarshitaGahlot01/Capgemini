//class Frationclass{
//    public static int gcd(int num, int den){
//        int min=Math.min(num,den);
//        for(int i=min;i>=1;i--){
//            if(num%i==0 && den%i==0) return i;
//        }
//        return min;
//    }
//    static class Fra{
//    int num;
//    int den;
//    Fra(int num, int den){
//        this.num=num;
//        this.den=den;
//    }
//
//    public void simplify(){
//    int hcf=gcd(num,den);
//    num/=hcf;
//    den/=hcf;
//        }
//
//
//
//public static int add(Fra f, Fra f1) {
//        return f+f1;
//}
//
//
//    public static void main(String[] args) {
//        Fra f=new Fra(14,21);
//        Fra f1=new Fra(7,21);
//        Fra f3=add(f,f1);
//    f.simplify();
//        System.out.println(f.num+"/"+f.den);
//
//    }
////}
