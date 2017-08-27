package fang.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 无序数组中第k大的数 {
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] <= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] > tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }

    public static void getLeastNumbers(int[] input, int[] output) {
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;//K

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        System.arraycopy(input, 0, output, 0, output.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        String s = in.nextLine();


        for (String sc : s.split(" ")) {
            list.add(Integer.parseInt(sc));
        }


        int k = in.nextInt();
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        int out[] = new int[k];
        if (k > arr.length) {
            throw new RuntimeException("");
        }
        getLeastNumbers(arr, out);
        System.out.println(out[k - 1]);
    }

}
