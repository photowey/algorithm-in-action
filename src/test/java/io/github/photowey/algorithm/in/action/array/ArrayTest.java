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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code ArrayTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
class ArrayTest {

    @Test
    void testRandomAccess() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int num = Array.randomAccess(nums);

        Assertions.assertTrue(num > 0 && num < 11);
    }

    @Test
    void testAccess() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int num0 = Array.access(nums, 0);
        int num9 = Array.access(nums, 9);

        Assertions.assertEquals(1, num0);
        Assertions.assertEquals(10, num9);
    }

    @Test
    void testAccess_bad_index() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Array.access(nums, -1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Array.access(nums, 10);
        });
    }

    @Test
    void testInsert() {
        int[] nums = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, -1};

        Array.insert(nums, 6, 5);

        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, nums);
        Assertions.assertEquals(6, Array.access(nums, 5));
    }

    @Test
    void testInsert_bad_index() {
        int[] nums = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, -1};

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Array.insert(nums, 6, -1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Array.insert(nums, 6, 11);
        });
    }

    @Test
    void testRemove() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Array.remove(nums, 5);

        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 10}, nums);
        Assertions.assertEquals(7, Array.access(nums, 5));
        Assertions.assertEquals(9, Array.access(nums, 7));
        Assertions.assertEquals(10, Array.access(nums, 8));
        Assertions.assertEquals(10, Array.access(nums, 9));
    }

    @Test
    void testRemove_bad_index() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Array.remove(nums, -1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Array.remove(nums, 11);
        });
    }

    @Test
    void testTraverse() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Array.traverse(nums);
    }

    @Test
    void testTraverse2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Array.traverse2(nums);
    }

    @Test
    void testTraverse3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Array.traverse3(nums, (num) -> {
            System.out.println("Num:" + num);
        });
    }

    @Test
    void testFind() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = 6;
        int targetNotExists = 9527;
        int index = Array.find(nums, target);
        int indexNotExists = Array.find(nums, targetNotExists);

        Assertions.assertEquals(5, index);
        Assertions.assertEquals(-1, indexNotExists);
    }

    @Test
    void testExtend() {
        int[] nums = {1, 2, 3, 4, 5};

        int[] res = Array.extend(nums, 5);

        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0}, res);
    }

}