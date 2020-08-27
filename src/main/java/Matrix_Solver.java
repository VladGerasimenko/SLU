
public class Matrix_Solver {

    private double[][] input;

    public Matrix_Solver(double[][] input){
        this.input = input;
    }

    public void showInput(){
        System.out.println();
        for(int i = 0; i<input.length;i++){
            for(int j=0; j<input[i].length; j++){
                if(j == input[i].length - 1){
                    System.out.println(" = " +  input[i][j]);
                } else if(j == input[i].length - 2) {
                    System.out.print("X" + j + "*" + input[i][j]);
                } else {
                    System.out.print("X" + j + "*" + input[i][j] + " + ");
                }
            }
            System.out.println();
        }
    }

    private double[][] solveSLU(double[][] arr){
        int count=1;
        for(int k =0; k<arr.length-1;k++) {
            for (int i = k; i < arr.length - 1; i++) {
                double c = arr[i+1][k] / arr[k][k];
                for (int j = k; j < arr[i].length; j++) {
                        arr[k][j] = (arr[k][j]) * c;
                        arr[i + 1][j] = arr[k][j] - arr[i + 1][j];
                        arr[k][j] = arr[k][j] / c;
                        System.out.println("Step: " + count);
                        count++;
                        showInput();
                    }
                }
        }

        return arr;
    }

    public String[] getResult() {
        double[][] matrix = solveSLU(input);
        String[] stringRes;
        if (matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] != 0 && matrix[matrix.length - 1][matrix[matrix.length - 1].length - 2] == 0) {
            stringRes = new String[1];
            stringRes[0] = "System has not solutions because: " + matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] + " is not equals 0";
            return stringRes;
        }
        else if(matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] == 0 && matrix[matrix.length - 1][matrix[matrix.length - 1].length - 2] == 0){
//            stringRes = new String[matrix[0].length*matrix.length-1];
            stringRes = new String[1];
            System.out.println();
            System.out.print("System has a set of solutions");
            for(int i = 0; i<matrix.length-1;i++){
                for(int j=0; j<matrix[i].length; j++){
                    if(j == matrix[i].length - 1){
                       stringRes[0] += " = " +  input[i][j];
                    } else if(j == matrix[i].length - 2) {
                        stringRes[0] += "X" + j + "*" + matrix[i][j];
                    } else {
                        if(i == 0 && j == 0){
                            stringRes[0] = "X" + j + "*" + matrix[i][j] + " + ";
                            continue;
                        }
                        stringRes[0] += "X" + j + "*" + matrix[i][j] + " + ";
                    }
                }
                stringRes[0] += "\n";
                System.out.println();
            }
            return stringRes;
        }
        else {
            stringRes = new String[matrix[0].length - 1];
            double[] doubleRes = new double[stringRes.length];
            for (int i = 0; i < matrix.length; i++) {
                if (i == 0) {
                    doubleRes[i] = matrix[matrix.length - 1 - i][matrix[matrix.length - 1 - i].length - 1] / matrix[matrix.length - 1 - i][matrix[matrix.length - 1].length - 2 - i];
                } else {
                    int count = i;
                    double buf = 0;
                    int k = 0;
                    while (count != 0) {
                        buf += doubleRes[count - 1] * matrix[matrix.length - 1 - i][matrix[matrix.length - 1 - i].length - 1 - i + k];
                        count--;
                        k++;
                    }
                    doubleRes[i] = (matrix[matrix.length - 1 - i][matrix[matrix.length - 1 - i].length - 1] - buf)
                            / matrix[matrix.length - 1 - i][matrix[matrix.length - 1].length - 2 - i];
                }
                stringRes[i] = "X" + (matrix.length - 1 - i) + " = " + doubleRes[i];
            }
            return stringRes;
        }
    }

}
