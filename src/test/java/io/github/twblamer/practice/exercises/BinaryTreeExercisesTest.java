package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

import io.github.twblamer.practice.util.Util;
import io.github.twblamer.practice.util.BinaryTreeNode.TraversalOrder;

public class BinaryTreeExercisesTest {
        @Test
        public void testBfs() {
                BinaryTreeExercises root = new BinaryTreeExercises(1,
                                new BinaryTreeExercises(2,
                                                new BinaryTreeExercises(4),
                                                new BinaryTreeExercises(5)),
                                new BinaryTreeExercises(3,
                                                new BinaryTreeExercises(6),
                                                new BinaryTreeExercises(7)));

                var expected = List.of(1, 2, 3, 4, 5, 6, 7);
                var actual = Util.iteratorToList(root.bfs());

                assertEquals(expected, actual);
        }

        @Test
        public void testBinarySearch() {
                BinaryTreeExercises root = new BinaryTreeExercises(4,
                                new BinaryTreeExercises(2,
                                                new BinaryTreeExercises(1),
                                                new BinaryTreeExercises(3)),
                                new BinaryTreeExercises(6,
                                                new BinaryTreeExercises(5),
                                                new BinaryTreeExercises(7)));

                assertTrue(root.binarySearch(4));
                assertTrue(root.binarySearch(2));
                assertTrue(root.binarySearch(6));
                assertTrue(root.binarySearch(1));
                assertTrue(root.binarySearch(3));
                assertTrue(root.binarySearch(5));
                assertTrue(root.binarySearch(7));
                assertFalse(root.binarySearch(0));
                assertFalse(root.binarySearch(8));
        }

        @Test
        public void testFromArray() {
                int[] a = { 1, 2, 3, 4, 5, 6, 7 };
                BinaryTreeExercises root = BinaryTreeExercises.fromArray(a);

                var expected = List.of(1, 2, 3, 4, 5, 6, 7);
                var actual = Util.iteratorToList(root.dfs(TraversalOrder.INORDER));

                assertEquals(expected, actual);
        }

        @Test
        private void testInorderDfs(boolean iterative) {
                BinaryTreeExercises root = new BinaryTreeExercises(1,
                                new BinaryTreeExercises(2,
                                                new BinaryTreeExercises(4),
                                                new BinaryTreeExercises(5)),
                                new BinaryTreeExercises(3,
                                                new BinaryTreeExercises(6),
                                                new BinaryTreeExercises(7)));

                var expected = List.of(4, 2, 5, 1, 6, 3, 7);
                var actual = Util.iteratorToList(root.dfs(TraversalOrder.INORDER));

                assertEquals(expected, actual);
        }

        @Test
        public void testInvert() {
                BinaryTreeExercises root = new BinaryTreeExercises(1);
                root.left = new BinaryTreeExercises(2);

                root.invert();
                assertEquals(root.value, 1);
                assertEquals(root.right.value, 2);
                assertNull(root.left);

                root = new BinaryTreeExercises(4,
                                new BinaryTreeExercises(2,
                                                new BinaryTreeExercises(1),
                                                new BinaryTreeExercises(3)),
                                new BinaryTreeExercises(6,
                                                new BinaryTreeExercises(5),
                                                new BinaryTreeExercises(7)));

                assertEquals(Util.iteratorToList(root.dfs(TraversalOrder.INORDER)),
                                List.of(1, 2, 3, 4, 5, 6, 7));

                root.invert();

                assertEquals(Util.iteratorToList(root.dfs(TraversalOrder.INORDER)),
                                List.of(7, 6, 5, 4, 3, 2, 1));
        }

        @Test
        public void testPostorderDfsHelper() {
                BinaryTreeExercises root = new BinaryTreeExercises(1,
                                new BinaryTreeExercises(2,
                                                new BinaryTreeExercises(4),
                                                new BinaryTreeExercises(5)),
                                new BinaryTreeExercises(3,
                                                new BinaryTreeExercises(6),
                                                new BinaryTreeExercises(7)));

                var expected = List.of(4, 5, 2, 6, 7, 3, 1);
                var actual = Util.iteratorToList(root.dfs(TraversalOrder.POSTORDER));

                assertEquals(expected, actual);
        }

        @Test
        public void testPreorderDfs() {
                BinaryTreeExercises root = new BinaryTreeExercises(1,
                                new BinaryTreeExercises(2,
                                                new BinaryTreeExercises(4),
                                                new BinaryTreeExercises(5)),
                                new BinaryTreeExercises(3,
                                                new BinaryTreeExercises(6),
                                                new BinaryTreeExercises(7)));

                var expected = List.of(1, 2, 4, 5, 3, 6, 7);
                var actual = Util.iteratorToList(root.dfs(TraversalOrder.PREORDER));

                assertEquals(expected, actual);
        }
}
