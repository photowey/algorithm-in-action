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
package io.github.photowey.algorithm.in.action.array;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**
 * {@code Array}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public final class Array {

    private Array() {}

    // ----------------------------------------------------------------

    public static int randomAccess(int[] nums) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        return access(nums, randomIndex);
    }

    public static int access(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }
        return nums[index];
    }

    // ----------------------------------------------------------------

    public static void insert(int[] nums, int num, int index) {
        if (index < 0 || index >= nums.length) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }

        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }

        nums[index] = num;
    }

    // ----------------------------------------------------------------

    public static void remove(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }

        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    // ----------------------------------------------------------------

    public static void traverse(int[] nums) {
        traverse(nums, false);
    }

    public static void traverse(int[] nums, boolean printEnabled) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }

        if (printEnabled) {
            System.out.println("Nums count:" + count);
        }
    }

    // ----------------------------------------------------------------

    public static void traverse2(int[] nums) {
        traverse2(nums, false);
    }

    public static void traverse2(int[] nums, boolean printEnabled) {
        int count = 0;

        for (int num : nums) {
            count += num;
        }

        if (printEnabled) {
            System.out.println("Nums count:" + count);
        }
    }

    // ----------------------------------------------------------------

    public static void traverse3(int[] nums, Consumer<Integer> fx) {
        for (int num : nums) {
            fx.accept(num);
        }
    }

    // ----------------------------------------------------------------

    public static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // ----------------------------------------------------------------

    public static int[] extend(int[] nums, int enlarge) {
        int[] res = new int[nums.length + enlarge];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }

        return res;
    }
}