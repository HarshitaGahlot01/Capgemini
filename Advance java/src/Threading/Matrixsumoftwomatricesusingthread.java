package Threading;
class Matrix{
   static int matrix1[][]={{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    static int matrix2[][]={{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    static int[][] res = new int[5][4];

    static class AddThread extends Thread {
        int row;

        AddThread(int row) {
            this.row = row;
        }

        public void run() {
            for(int j = 0; j < matrix1[0].length; j++) {
                res[row][j] = matrix2[row][j] + matrix2[row][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {

        AddThread t1 = new AddThread(0);
        AddThread t2 = new AddThread(1);
        AddThread t3 = new AddThread(2);
        AddThread t4 = new AddThread(3);
        AddThread t5 = new AddThread(4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Result Matrix:");
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix2[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}


public class Matrixsumoftwomatricesusingthread {
    public static void main(String[] args) {

    }
}
