package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Problem Description

Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.
 */

public class CombinationSum {

    ArrayList<ArrayList<Integer>> result;
    int k = 0;
    Set<ArrayList<Integer>> uniqueSet = new HashSet<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result = new ArrayList<ArrayList<Integer>>();
        k = 0;
        Collections.sort(A);
        ArrayList<Integer> uniqueSet = new ArrayList<Integer>();
        for (int p = 0; p < A.size(); p++) {

            if (p == 0 || A.get(p) != A.get(p - 1)) {
                uniqueSet.add(A.get(p));
            }

        }
        calculateCombinationSum(uniqueSet, new Stack<Integer>(), 0, 0, B);

        System.out.println("Results : ");
        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> A, int B) {

        result = new ArrayList<ArrayList<Integer>>();
        k = 0;
        Collections.sort(A);
        calculateCombinationSum2(A, new Stack<Integer>(), 0, 0, B);

        System.out.println("Results : ");
        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        return result;
    }


    void calculateCombinationSum(ArrayList<Integer> src, Stack<Integer> combination, int currentIndex, int currentSum, int upperLimit) {

        if (currentSum > upperLimit) {
            return;
        }

        if (currentSum == upperLimit) {
            result.add(k, convertArrayListToIntArray(combination.toArray()));
            k++;
            return;
        }

        for (int i = currentIndex; i < src.size(); i++) {
            int pushValue = src.get(i);
            currentSum += pushValue;
            combination.push(pushValue);
            calculateCombinationSum(src, combination, i, currentSum, upperLimit);
            combination.pop();
            currentSum -= pushValue;

        }

    }

    void calculateCombinationSum2(ArrayList<Integer> src, Stack<Integer> combination, int currentIndex, int currentSum, int upperLimit) {

        if (currentSum > upperLimit) {
            return;
        }

        if (currentSum == upperLimit) {
            ArrayList<Integer> arr = convertArrayListToIntArray(combination.toArray());
            if (uniqueSet.add(arr)) {
                result.add(k, arr);
                k++;
            }
        }

        for (int i = currentIndex; i < src.size(); i++) {
            int pushValue = src.get(i);
            currentSum += pushValue;
            combination.push(pushValue);
            calculateCombinationSum2(src, combination, i + 1, currentSum, upperLimit);
            combination.pop();
            currentSum -= pushValue;

        }

    }

    static ArrayList<Integer> convertArrayListToIntArray(Object[] arr) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.add(0, (Integer) arr[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        CombinationSum combinationSum = new CombinationSum();
        ArrayList<Integer> inp = new ArrayList<>();
        inp.add(2);
        inp.add(3);
        inp.add(6);
        inp.add(7);

        ArrayList<Integer> inp1 = new ArrayList<>();
        inp1.add(2);
        inp1.add(1);
        inp1.add(3);

        ArrayList<Integer> inp2 = new ArrayList<>();
        inp2.add(10);
        inp2.add(1);
        inp2.add(2);
        inp2.add(7);
        inp2.add(6);
        inp2.add(1);
        inp2.add(5);


        //combinationSum.combinationSum(inp, 7);
        combinationSum.combinationSum2(inp1, 3);
        combinationSum.combinationSum2(inp2, 8);
    }
}
