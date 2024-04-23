
package pipeline; 

import java.util.ArrayList;
import java.util.Scanner;

public class Pipeline {

   
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        System.out.print("enter number of instruction: ");

        int count = 1;
        int rows = sc.nextInt();
        System.out.println("enter your table row by row: ");
        int twoD[][] = new int[rows][4];
        for (int i = 0; i < rows; i++) {
            System.out.println("your row " + (i + 1) + " :");
            for (int j = 0; j < 4; j++) {
                twoD[i][j] = sc.nextInt();
            }
        }
        System.out.println("      IF    ID   EX    WB   total ");
        int total;
        double totalSum = 0.0;
        for (int i = 0; i < rows; i++) {
            total = twoD[i][0] + twoD[i][1] + twoD[i][2] + twoD[i][3];
            totalSum += total;
            System.out.println("I" + count + "    " + twoD[i][0] + "     " + twoD[i][1] + "    " + twoD[i][2] + "     "
                    + twoD[i][3] + "     " + total);
            count++;
        }
        System.out.println("");

        ArrayList<Integer> IF = new ArrayList<>();
        ArrayList<Integer> ID = new ArrayList<>();
        ArrayList<Integer> EX = new ArrayList<>();
        ArrayList<Integer> WB = new ArrayList<>();

        //If count
        int count2 = 0;
        for (int j = 0; j < rows; j++) {
            count2++;
            for (int i = 0; i < twoD[j][0]; i++) {
                IF.add(count2);

            }

        }

        for (int z = 1; z <= twoD[0][0]; z++) {

            ID.add(0);
        }
        int count3 = 0;
        for (int j = 0; j < rows; j++) {
            count3++;
            for (int i = 0; i < twoD[j][1]; i++) {
               int k = ID.size();
                while (IF.size() > k) {
                    if (IF.get(k) <= count3) {
                        ID.add(0);
                        k = k + 1;
                    } else {
                        break;
                    }
                }
                ID.add(count3);
   }
        }
        for (int z = 1; z <= twoD[0][0] + twoD[0][1]; z++) {

            EX.add(0);
        }

        int count4 = 0;
        boolean f = false;
        for (int j = 0; j < rows; j++) {
            count4++;
            for (int i = 0; i < twoD[j][2]; i++) {
                int k = EX.size();
                while (ID.size() > k) {
                    if (ID.get(k) == count4) {
                        EX.add(0);
                        k++;
                    } else if (ID.get(k) == 0) {
                        for (int p = 0; p < k; p++) {
                            if (ID.get(p) == count4) {
                                f = true;
                            }
                        }
                        if (f) {
                            break;
                        } else {
                            EX.add(0);
                            k++;
                        }

                    } else {
                        break;
                    }
                }
  EX.add(count4);

            }

        }
        for (int z = 1; z <= twoD[0][0] + twoD[0][1] + twoD[0][2]; z++) {

            WB.add(0);
        }
        int count5 = 0;
        boolean found = false;
        for (int j = 0; j < rows; j++) {
            count5++;
            for (int i = 0; i < twoD[j][3]; i++) {
               int k = WB.size();
                while (EX.size() > k) {
                  if (EX.get(k) == count5) {
                        WB.add(0);
                        k++;
                    } else if (EX.get(k) == 0) {
                        for (int p = 0; p < k; p++) {
                         if ( EX.get(p)== count5) {
                                found = true;
                            }
                        }
                        if (found) {
                            break;
                        } else {
                            WB.add(0);
                            k++;
                        }

                    } else {
                        break;
                    }
 }
                WB.add(count5);

            }

        }

//print the arrayList
int count11=1;
System.out.print("  ");
for(int i=0;i<WB.size();i++){
System.out.print(" T"+count11);
count11++;

}
System.out.println();
        System.out.print("IF ");
        for (int i = 0; i < IF.size(); i++) {
            System.out.print("I" + IF.get(i) + " ");
        }
        System.out.println();
         System.out.print("ID ");
        for (int i = 0; i < ID.size(); i++) {
            if (ID.get(i) == 0) {
                System.out.print("   ");
            } else {
                System.out.print("I" + ID.get(i) + " ");
            }
        }
        System.out.println();
       System.out.print("EX ");
        for (int i = 0; i < EX.size(); i++) {
            if (EX.get(i) == 0) {
                System.out.print("   ");
            } else {
                System.out.print("I" + EX.get(i) + " ");
            }
        }
        System.out.println();
System.out.print("WB");
        for (int i = 0; i < WB.size(); i++) {
            if (WB.get(i) == 0) {
                System.out.print("   ");
            } else {
                System.out.print(" I" + WB.get(i) + " ");
   }
        }
         System.out.println();

        System.out.println("Total sum="+ totalSum);
        System.out.println("clock cycles="+ (WB.size()));
        double speed =totalSum/(WB.size());
        System.out.println("spped up="+ speed);
}

}    
    
    

