import org.junit.Test;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-08 12:09
 **/
public class Test01 {
    @Test
    public void test1() {
        int[] arr = {3, 5, 8, 2, 1, 9, 0, 6, 7, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+" ,");
        }
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left > right)// 此为递归的结束条件，
            return;
        int middle = getMiddle(arr, left, right);// 此步最为关键
        quickSort(arr, 0, middle - 1);
        quickSort(arr, middle + 1, right);

    }

    private int getMiddle(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left != right) {
            // 右指针左移
            while (right > left && arr[right] >= temp)
                right--;
            // 左指针右移
            arr[left] = arr[right];// 将右边给左边
            while (right > left && arr[left] <= temp)
                left++;
            arr[right] = arr[left]; // 将左边给右边。
        }
        arr[left] = temp;
        return left;
    }
}
