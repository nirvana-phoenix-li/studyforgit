package com.li.test;

public class SnakeArr {

    public void printSnakeArr(int row, int col) {
        for (int i = 1; i <= row; i++) {
            StringBuilder sb = new StringBuilder();
            int help=i;
            for (int j = 0; j < col; j++) {
                if (i==1){
                    if (j%2==0){
                        sb.append(help);
                        help=help+2*row-1;
                    }else {
                        sb.append(help);
                        help=help+1;
                    }
                    if (j!=col-1){
                        sb.append(",");
                    }
                }else {
                    if (j%2==0){
                        sb.append(help);
                        help=help+2*row;
                    }else {
                        int temp = 1 + (j+1)* row - i;
                        sb.append(temp);
                    }
                    if (j!=col-1){
                        sb.append(",");
                    }
                }

            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        SnakeArr snakeArr = new SnakeArr();
        int col = 5;
        snakeArr.printSnakeArr(25, 30);
    }

}
