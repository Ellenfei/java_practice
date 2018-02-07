package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ellen on 2017/3/25.
 * backtracking
 * @
 * @return ArrayList<List<></>></>
 */
public class permutation {
    public static void main(String[] args) {
        int[] nums = {3,1,1};
        System.out.print(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums==null || nums.length==0) return result;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(result,nums,list,visited);
        return result;
    }

    public static void dfs(ArrayList<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited) {
        if (list.size()==nums.length) {
            res.add(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (visited[i] || (i!=0 && nums[i]==nums[i-1] && !visited[i-1]) ) continue;

            visited[i] = true;
            list.add(nums[i]);
            dfs(res, nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
