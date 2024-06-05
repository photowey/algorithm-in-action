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
package io.github.photowey.algorithm.in.action.recursion.fib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code FibTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/06
 */
class FibTest {

    @Test
    void testFib() {
        // 0, 1, 1, 2, 3, 5, 8, 13
        Assertions.assertEquals(0, this.fib(1));
        Assertions.assertEquals(1, this.fib(2));
        Assertions.assertEquals(1, this.fib(3));
        Assertions.assertEquals(2, this.fib(4));
        Assertions.assertEquals(3, this.fib(5));
        Assertions.assertEquals(5, this.fib(6));
        Assertions.assertEquals(8, this.fib(7));
        Assertions.assertEquals(13, this.fib(8));
    }

    // ----------------------------------------------------------------

    private int fib(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}