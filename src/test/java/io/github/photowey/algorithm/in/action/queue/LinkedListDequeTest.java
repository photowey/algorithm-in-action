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
 * {@code LinkedListDequeTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/29
 */
class LinkedListDequeTest {

    @Test
    void testInit() {
        LinkedListDeque deque = new LinkedListDeque();

        Assertions.assertEquals(0, deque.size());
        Assertions.assertTrue(deque.isEmpty());
        Assertions.assertFalse(deque.isNotEmpty());
    }

    @Test
    void testPush() {
        LinkedListDeque deque = new LinkedListDeque();

        // 2
        deque.pushLast(2);
        // 2 <- -> 5
        deque.pushLast(5);
        // 2 <- -> 5 <- -> 4
        deque.pushLast(4);
        // 3 <- -> 2 <- -> 5 <- -> 4
        deque.pushFirst(3);
        // 1 <- -> 3 <- -> 2 <- -> 5 <- -> 4
        deque.pushFirst(1);

        Assertions.assertEquals(5, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertTrue(deque.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, deque.toArray());
    }

    @Test
    void testPop() {
        LinkedListDeque deque = new LinkedListDeque();

        // 2
        deque.pushLast(2);
        // 2 <- -> 5
        deque.pushLast(5);
        // 2 <- -> 5 <- -> 4
        deque.pushLast(4);
        // 3 <- -> 2 <- -> 5 <- -> 4
        deque.pushFirst(3);
        // 1 <- -> 3 <- -> 2 <- -> 5 <- -> 4
        deque.pushFirst(1);

        Assertions.assertEquals(5, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertTrue(deque.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, deque.toArray());

        // 3 <- -> 2 <- -> 5 <- -> 4
        int first = deque.popFirst();
        Assertions.assertEquals(1, first);
        Assertions.assertArrayEquals(new int[]{3, 2, 5, 4}, deque.toArray());

        // 3 <- -> 2 <- -> 5
        int last = deque.popLast();
        Assertions.assertEquals(4, last);
        Assertions.assertArrayEquals(new int[]{3, 2, 5}, deque.toArray());
    }

    @Test
    void testPeek() {
        LinkedListDeque deque = new LinkedListDeque();

        // 2
        deque.pushLast(2);
        // 2 <- -> 5
        deque.pushLast(5);
        // 2 <- -> 5 <- -> 4
        deque.pushLast(4);
        // 3 <- -> 2 <- -> 5 <- -> 4
        deque.pushFirst(3);
        // 1 <- -> 3 <- -> 2 <- -> 5 <- -> 4
        deque.pushFirst(1);

        Assertions.assertEquals(5, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertTrue(deque.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, deque.toArray());

        int first = deque.peekFirst();
        Assertions.assertEquals(1, first);
        int last = deque.peekLast();
        Assertions.assertEquals(4, last);
    }
}