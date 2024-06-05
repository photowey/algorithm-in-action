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
package io.github.photowey.algorithm.in.action.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code RecursionTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/06
 */
class RecursionTest {

    @Test
    void testRecur() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.recur(-1));

        Assertions.assertEquals(0, this.recur(0));
        Assertions.assertEquals(1, this.recur(1));
        Assertions.assertEquals(55, this.recur(10));
        Assertions.assertEquals(5050, this.recur(100));
    }

    @Test
    void testTailRecur() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.tailRecur(-1, 0));

        Assertions.assertEquals(0, this.tailRecur(0, 0));
        Assertions.assertEquals(1, this.tailRecur(1, 0));
        Assertions.assertEquals(55, this.tailRecur(10, 0));
        Assertions.assertEquals(5050, this.tailRecur(100, 0));
    }

    // ----------------------------------------------------------------

    /**
     * Recursion.
     *
     * <pre>
     * f(n) = 1 + 2 + 3 + ... + n
     * </pre>
     *
     * @param n N
     * @return SUM
     */
    private int recur(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be less than 0");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int res = this.recur(n - 1);
        return n + res;
    }

    /**
     * Tail Recursion.
     *
     * <pre>
     * f(n) = 1 + 2 + 3 + ... + n
     * </pre>
     *
     * @param n N
     * @return SUM
     */
    private int tailRecur(int n, int res) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be less than 0");
        }

        if (n == 0) {
            return res;
        }

        return this.tailRecur(n - 1, res + n);
    }
}