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
package io.github.photowey.algorithm.in.action.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code ArrayStackTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/24
 */
class ArrayStackTest {

    @Test
    void testInit() {
        ArrayStack stack = new ArrayStack();
        Assertions.assertEquals(0, stack.size());
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertFalse(stack.isNotEmpty());
    }

    @Test
    void testPush() {
        ArrayStack stack = new ArrayStack();

        // 4 -> 5 -> 2 -> 3 -> 1

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        Assertions.assertEquals(5, stack.size());
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertTrue(stack.isNotEmpty());

        Assertions.assertArrayEquals(new Integer[]{1, 3, 2, 5, 4}, stack.toArray());
    }

    @Test
    void testPeek() {
        ArrayStack stack = new ArrayStack();

        // 4 -> 5 -> 2 -> 3 -> 1

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        Assertions.assertEquals(4, stack.peek());
    }

    @Test
    void testPop() {
        ArrayStack stack = new ArrayStack();

        // 4 -> 5 -> 2 -> 3 -> 1

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(5, stack.peek());

        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertTrue(stack.isNotEmpty());

        Assertions.assertArrayEquals(new Integer[]{1, 3, 2, 5}, stack.toArray());
    }

}