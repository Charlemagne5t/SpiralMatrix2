package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    @Test
    public void generateMatrixTest(){
        int[][] answer = {
                            {1,2,3},
                            {8,9,4},
                            {7,6,5}};
        Assert.assertEquals(answer, new Solution().generateMatrix(3));
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fill(matrix);
        return  matrix;

    }
    public void fill( int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int mLength = matrix[0].length;
        int mHeight = matrix.length;
        recursive(matrix, 0, 0, mLength, mHeight, 1);
    }
    private void recursive(int[][] matrix, int i, int j, int mLength, int mHeight, int count) {
        if(count > matrix.length * matrix.length) return;
        int counter = mLength;
        for (; counter > 0; j++, counter--) {
            matrix[i][j] = count++;
        }
        j--;
        i++;
        --mHeight;
        if(count > matrix.length * matrix.length) return;
        counter = mHeight;
        for (; counter > 0; i++, counter--) {
            matrix[i][j] = count++;
        }
        i--;
        j--;
        --mLength;
        if(count > matrix.length * matrix.length) return;
        counter = mLength;
        for (; counter > 0 ; j--, counter--) {
            matrix[i][j] = count++;
        }
        j++;
        i--;
        --mHeight;
        if(count > matrix.length * matrix.length) return;
        counter = mHeight;

        for (; counter > 0 ; i--, counter--) {
            matrix[i][j] = count++;
        }
        i++;
        j++;
        --mLength;
        if(count > matrix.length * matrix.length) return;
        recursive(matrix, i, j, mLength, mHeight, count);
    }
}