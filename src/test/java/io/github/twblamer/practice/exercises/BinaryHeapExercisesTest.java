package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class BinaryHeapExercisesTest {
    private Supplier<String> dump(BinaryHeapExercises heap) {
        return () -> String.format("heap=%s", heap.toString());
    }

    @Test
    public void test() {
        var heap = new BinaryHeapExercises();
        var dumpMethod = dump(heap);

        assertEquals(0, heap.size());
        assertThrows(NoSuchElementException.class, () -> {
            heap.peek();
        });
        assertThrows(NoSuchElementException.class, () -> {
            heap.poll();
        });

        heap.add(42);
        assertEquals(1, heap.size());

        var value = heap.poll();
        assertEquals(42, value);
        assertEquals(0, heap.size());

        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        assertEquals(4, heap.size(), dumpMethod);

        assertEquals(1, heap.poll(), dumpMethod);
        assertEquals(3, heap.poll(), dumpMethod);
        assertEquals(5, heap.poll(), dumpMethod);
        assertEquals(7, heap.poll(), dumpMethod);
        assertEquals(0, heap.size());
    }

    @Test
    public void testBuild() {
        int[] randomArray = { 23, 7, 42, 15, 31, 4, 11, 38, 5, 19, 8, 33, 50, 2, 14, 46, 27, 10, 6, 17 };
        int[] expected = new int[] { 2, 4, 5, 6, 7, 8, 10, 11, 14, 15, 17, 19, 23, 27, 31, 33, 38, 42, 46, 50 };

        BinaryHeapExercises heap = BinaryHeapExercises.fromArray(randomArray);

        var actual = new int[heap.size()];

        for (int i = 0; heap.size() > 0; i++) {
            actual[i] = heap.poll();
        }

        assertArrayEquals(expected, actual);
    }
}
