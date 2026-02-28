public class Exception extends Throwable {
    public static void main(String[] args) {
        System.out.println("main start");
        int a =10;
        int b=0;
        int res=0;
//        try{
//             res=a/b;
//        } catch (ArithmeticException e){
//            System.out.println("can not divide by 0");
//        }
//        System.out.println(res);
//        System.out.println("main end");
        try{
            res=a/b;
        }
        catch (ArithmeticException e){
            System.out.println("amo");
        }
        finally {
            System.out.println("finalyy");
        }
        System.out.println(res);
        System.out.println("main end");

    }
}
