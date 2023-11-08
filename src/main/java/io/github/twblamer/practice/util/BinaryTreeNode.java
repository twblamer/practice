package io.github.twblamer.practice.util;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Function;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.value = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public enum TraversalOrder {
        PREORDER,
        INORDER,
        POSTORDER,
    }

    //
    // Basic algorithms
    //
    public boolean binarySearch(int value) {
        if (this.value == value) {
            return true;
        }

        if (value < this.value) {
            if (this.left != null) {
                return this.left.binarySearch(value);
            }
        } else {
            if (this.right != null) {
                return this.right.binarySearch(value);
            }
        }
        return false;
    }

    public static BinaryTreeNode fromArray(int[] a) {
        return fromArrayHelper(a, BinaryTreeNode::new);
    }

    protected static BinaryTreeNode fromArrayHelper(int[] a, Function<Integer, BinaryTreeNode> nodeFactory) {
        class Local {
            private BinaryTreeNode create(int[] a, int start, int end) {
                if (start > end) {
                    return null;
                }

                var mid = start + (end - start) / 2;

                var node = nodeFactory.apply(a[mid]);
                node.left = create(a, start, mid - 1);
                node.right = create(a, mid + 1, end);

                return node;
            }
        }

        return new Local().create(a, 0, a.length - 1);
    }

    public void invert() {
        if (left != null) {
            left.invert();
        }

        if (right != null) {
            right.invert();
        }

        var tmp = right;
        right = left;
        left = tmp;
    }

    //
    // Iterators
    //
    public Iterator<Integer> bfs() {
        return new BreadthFirstIterator(this);
    }

    private class BreadthFirstIterator implements Iterator<Integer> {
        Queue<BinaryTreeNode> queue;

        public BreadthFirstIterator(BinaryTreeNode root) {
            this.queue = new LinkedList<BinaryTreeNode>();

            if (root != null) {
                queue.add(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            var current = queue.poll();

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }

            return current.value;
        }
    }

    public Iterator<Integer> dfs(TraversalOrder order) {
        switch (order) {
            case PREORDER:
                return new PreOrderIterator(this);
            case INORDER:
                return new InOrderIterator(this);
            case POSTORDER:
                return new PostOrderIterator(this);
            default:
                throw new IllegalArgumentException("Unsupported order: " + order);
        }
    }

    private abstract class DepthFirstIterator implements Iterator<Integer> {
        Deque<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    private class PreOrderIterator extends DepthFirstIterator {
        public PreOrderIterator(BinaryTreeNode root) {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            var current = stack.pop();
            pushNodes(current);
            return current.value;
        }

        void pushNodes(BinaryTreeNode node) {
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private class InOrderIterator extends DepthFirstIterator {
        public InOrderIterator(BinaryTreeNode root) {
            pushNodes(root);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            var current = stack.pop();
            pushNodes(current.right);
            return current.value;
        }

        void pushNodes(BinaryTreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    private class PostOrderIterator extends DepthFirstIterator {
        Deque<Boolean> visitedStack = new LinkedList<Boolean>();

        public PostOrderIterator(BinaryTreeNode root) {
            if (root != null) {
                pushNode(root, false);
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            while (true) {
                var current = stack.pop();
                var visited = visitedStack.pop();

                if (visited) {
                    return current.value;
                } else {
                    pushNode(current, true);

                    if (current.right != null) {
                        pushNode(current.right, false);
                    }
                    if (current.left != null) {
                        pushNode(current.left, false);
                    }
                }
            }
        }

        private void pushNode(BinaryTreeNode node, boolean visited) {
            stack.push(node);
            visitedStack.push(visited);
        }
    }
}
