package LinkListAndTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> temp = new ArrayList<>();

        all(temp, root, 0);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++){
            if(i % 2 == 1){
                Collections.reverse(temp.get(i));
                res.add(temp.get(i));
            }else{
                res.add(temp.get(i));
            }
        }

        return res;
    }

    public void all(List<List<Integer>> res, TreeNode root, int level){
        if(root == null){
            return;
        }

        for(int i = 0; i < level - res.size() + 1; i++){
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        all(res, root.left, level + 1);
        all(res, root.right, level + 1);
    }
}
