/*
 * Copyright © 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.photowey.algorithm.in.action.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code ArrayDequeTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/29
 */
class ArrayDequeTest {

    @Test
    void testInit() {
        ArrayDeque deque = new ArrayDeque(5);

        Assertions.assertEquals(0, deque.size());
        Assertions.assertTrue(deque.isEmpty());
        Assertions.assertFalse(deque.isNotEmpty());
    }

    @Test
    void testPush() {
        ArrayDeque deque = new ArrayDeque(5);
        deque.pushLast(2);
        deque.pushLast(5);
        deque.pushLast(4);
        deque.pushFirst(3);
        deque.pushFirst(1);

        Assertions.assertEquals(5, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertTrue(deque.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, deque.toArray());
    }

    @Test
    void testPop() {
        ArrayDeque deque = new ArrayDeque(5);

        // [0, 0, 0, 0, 0]

        // [2, 0, 0, 0, 0]
        // front = 0
        // size = 1
        deque.pushLast(2);
        // [2, 5, 0, 0, 0]
        // front = 0
        // size = 2
        deque.pushLast(5);
        // [2, 5, 0, 0, 0]
        // front = 0
        // size = 3
        deque.pushLast(4);
        // [2, 5, 4, 0, 3]
        // front = 4
        // size = 4
        deque.pushFirst(3);
        // [2, 5, 4, 1, 3]
        // front = 3
        // size = 5
        deque.pushFirst(1);

        Assertions.assertEquals(5, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertTrue(deque.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, deque.toArray());

        int first = deque.popFirst();
        Assertions.assertEquals(1, first);
        Assertions.assertArrayEquals(new int[]{3, 2, 5, 4}, deque.toArray());

        int last = deque.popLast();
        Assertions.assertEquals(4, last);
        Assertions.assertArrayEquals(new int[]{3, 2, 5}, deque.toArray());
    }

    @Test
    void testPeek() {
        ArrayDeque deque = new ArrayDeque(5);

        deque.pushLast(2);
        deque.pushLast(5);
        deque.pushLast(4);
        deque.pushFirst(3);
        deque.pushFirst(1);

        Assertions.assertEquals(5, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertTrue(deque.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, deque.toArray());

        int first = deque.peekFirst();
        Assertions.assertEquals(1, first);

        int last = deque.popLast();
        Assertions.assertEquals(4, last);
    }

    @Test
    void testPop_empty() {
        ArrayDeque deque = new ArrayDeque(5);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            deque.popFirst();
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            deque.popLast();
        });
    }

    @Test
    void testPeek_empty() {
        ArrayDeque deque = new ArrayDeque(5);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            deque.peekFirst();
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            deque.peekLast();
        });
    }
}