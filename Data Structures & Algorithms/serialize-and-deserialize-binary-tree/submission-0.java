/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recserialize(root, "");
    }

    private String recserialize(TreeNode root, String data) {
        if(root == null) {
            data += "null,";
        } else {
            data += data.valueOf(root.val) + ",";
            data = recserialize(root.left, data);
            data = recserialize(root.right, data);
        }
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return recdeserialize(list);
    }

    private TreeNode recdeserialize(List<String> list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = recdeserialize(list);
        node.right = recdeserialize(list);
        return node;
    }
}
