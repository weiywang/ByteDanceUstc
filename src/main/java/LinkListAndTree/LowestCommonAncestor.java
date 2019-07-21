package LinkListAndTree;

import java.util.LinkedList;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = new LinkedList<>();
        LinkedList<TreeNode> pathQ = new LinkedList<>();

        findNodePath(pathP, root, p);
        findNodePath(pathQ, root, q);

        TreeNode last = null;
        while(!pathP.isEmpty() && !pathQ.isEmpty()){
            TreeNode pi = pathP.pollFirst();
            TreeNode qi = pathQ.pollFirst();

            if(pi == qi){
                last = qi;
            }else{
                break;
            }
        }

        return last;
    }

    public void findNodePath(LinkedList<TreeNode> path, TreeNode root, TreeNode target){
        if(root == null){
            return;
        }

        if(!path.isEmpty() && path.getLast().val == target.val){
            return;
        }

        path.add(root);

        findNodePath(path, root.left, target);

        if(!path.isEmpty() && path.getLast().val == target.val){
            return;
        }

        findNodePath(path, root.right, target);

        if(!path.isEmpty() && path.getLast().val != target.val){
            path.removeLast();
        }
    }
}
