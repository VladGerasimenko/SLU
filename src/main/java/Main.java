import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] input = {{2,4,5,7,9},{3,5,8,9,10},{4,6,10,15,16},{5,7,11,14,13}};
        Matrix_Solver matrix_solver = new Matrix_Solver(input);
        System.out.println("Input data: ");
        matrix_solver.showInput();
        System.out.println(Arrays.toString(matrix_solver.getResult()));
    }
}
