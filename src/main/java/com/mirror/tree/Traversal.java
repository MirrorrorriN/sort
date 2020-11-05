package com.mirror.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mirrordingjing @ 2020/8/13
 */
public class Traversal {

    public List<Integer> preOrder(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = head;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                res.add(cur.val);
                s.add(cur);
                cur = cur.left;
            }
            if (!s.empty()) {
                cur = s.pop();
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> inOrder(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = head;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }
            if (!s.empty()) {
                cur = s.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> postOrder(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = head;
        TreeNode prev = null;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }
            if (!s.empty()) {
                cur = s.pop();
                if (cur.right == null || cur.right == prev) {
                    res.add(cur.val);
                    prev=cur;
                    cur=null;
                } else {
                    s.add(cur);
                    cur = cur.right;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(0);
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        TreeNode s4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);
        TreeNode s6 = new TreeNode(6);
        head.left = s1;
        head.right = s2;
        s1.left = s3;
        s1.right = s4;
        s2.right = s5;
        s5.left = s6;
        Traversal traversal = new Traversal();
        List<Integer> res = traversal.postOrder(head);
        for (Integer num : res) {
            System.out.println(num);
        }
    }
}
