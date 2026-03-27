import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> row -> values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0, 0}); // node, row, col

        while (!queue.isEmpty()) {

            Object[] arr = queue.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null)
                queue.add(new Object[]{node.left, row + 1, col - 1});

            if (node.right != null)
                queue.add(new Object[]{node.right, row + 1, col + 1});
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            result.add(list);
        }

        return result;
    }
}