package playground1.experimentMAR17;


public class printMatrix {
    public static void main(String[] args) {
        int size = 5;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    System.out.print("*\t");
                } else if (i == size - j - 1) {
                    System.out.print("+\t");
                } else {
                    System.out.print(/*(i*size+j+1)+*/  "\t");
                }
            }
            System.out.println();
        }
    }

}
