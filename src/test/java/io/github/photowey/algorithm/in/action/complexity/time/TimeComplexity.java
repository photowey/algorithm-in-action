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
package io.github.photowey.algorithm.in.action.complexity.time;

import java.util.Arrays;
import java.util.Collections;

/**
 * {@code TimeComplexity}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/07
 */
class TimeComplexity {

    /**
     * O(1)
     */
    private int constant(int n) {
        int count = 0;

        int size = 100_000;
        for (int i = 0; i < size; i++) {
            count++;
        }

        return count;
    }

    // ----------------------------------------------------------------

    /**
     * O(n)
     */
    private int liner(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            count++;
        }

        return count;
    }

    /**
     * O(n)
     */
    private int arrayTraversal(int[] nums) {
        int count = 0;

        for (int num : nums) {
            count++;
        }

        return count;
    }

    // ----------------------------------------------------------------

    /**
     * O(n^2)
     */
    private int quadratic(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }

        return count;
    }

    /**
     * O(n^2)
     */
    private int bubbleSort(int[] nums) {
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count += 3;
                }
            }
        }

        return count;
    }

    // ----------------------------------------------------------------

    /**
     * O(2^n)
     */
    private int exponential(int n) {
        int count = 0;
        int base = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++) {
                count++;
            }

            base *= 2;
        }

        // count = 1 + 2 + 4 + 8 + ... + 2^(n-1) = 2^n - 1
        return count;
    }

    private int expRecur(int n) {
        if (n == 1) {
            return 1;
        }

        return this.expRecur(n - 1) + this.expRecur(n - 1) + 1;
    }

    // ----------------------------------------------------------------

    /**
     * O(log n)
     */
    private int logarithmic(int n) {
        int count = 0;
        while (n > 1) {
            n /= 2;
            count++;
        }

        return count;
    }

    /**
     * O(log n)
     */
    private int logRecur(int n) {
        if (n <= 1) {
            return 0;
        }

        return this.logRecur(n / 2) + 1;
    }

    // ----------------------------------------------------------------

    /**
     * O(n log n)
     */
    private int linerLogRecur(int n) {
        if (n <= 1) {
            return 1;
        }

        int count = this.linerLogRecur(n / 2) + this.linerLogRecur(n / 2);

        for (int i = 0; i < n; i++) {
            count++;
        }

        return count;
    }

    // ----------------------------------------------------------------

    /**
     * O(n!)
     */
    private int factorialRecur(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            count += this.factorialRecur(n - 1);
        }

        return count;
    }

    // ----------------------------------------------------------------

    private int[] randomNumbers(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(nums));

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
        }

        return res;
    }

    private int findOne(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    // ----------------------------------------------------------------
}