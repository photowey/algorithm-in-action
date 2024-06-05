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
package io.github.photowey.algorithm.in.action.iteration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code IterationTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/06
 */
class IterationTest {

    @Test
    void testForLoop() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.forLoop(-1));

        Assertions.assertEquals(0, this.forLoop(0));
        Assertions.assertEquals(1, this.forLoop(1));
        Assertions.assertEquals(55, this.forLoop(10));
        Assertions.assertEquals(5050, this.forLoop(100));
    }

    @Test
    void testWhileLoop() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.whileLoop(-1));

        Assertions.assertEquals(0, this.whileLoop(0));
        Assertions.assertEquals(1, this.whileLoop(1));
        Assertions.assertEquals(55, this.whileLoop(10));
        Assertions.assertEquals(5050, this.whileLoop(100));
    }

    // ----------------------------------------------------------------

    /**
     * For Loop.
     *
     * <pre>
     * f(n) = 1 + 2 + 3 + ... + n
     * </pre>
     *
     * @param n N
     * @return SUM
     */
    private int forLoop(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be less than 0");
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }

        return res;
    }

    /**
     * While Loop.
     *
     * <pre>
     * f(n) = 1 + 2 + 3 + ... + n
     * </pre>
     *
     * @param n N
     * @return SUM
     */
    private int whileLoop(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be less than 0");
        }

        int res = 0;
        while (n >= 1) {
            res += n;
            n--;
        }

        return res;
    }
}