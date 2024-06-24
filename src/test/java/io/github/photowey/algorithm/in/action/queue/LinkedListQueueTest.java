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
 * {@code LinkedListQueueTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/25
 */
class LinkedListQueueTest {

    @Test
    void testInit() {
        LinkedListQueue queue = new LinkedListQueue();

        Assertions.assertEquals(0, queue.size());
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertFalse(queue.isNotEmpty());
    }

    @Test
    void testPush() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);

        Assertions.assertEquals(5, queue.size());
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertTrue(queue.isNotEmpty());

        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, queue.toArray());
    }

    @Test
    void testPop() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);

        Assertions.assertEquals(1, queue.pop());
        Assertions.assertEquals(4, queue.size());
        Assertions.assertEquals(3, queue.peek());
    }

    @Test
    void testPeek() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);

        Assertions.assertEquals(1, queue.peek());
    }
}