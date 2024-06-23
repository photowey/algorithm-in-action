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
package io.github.photowey.algorithm.in.action.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code HelloArrayListTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
class HelloArrayListTest {

    @Test
    void testInit() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals(8, list.capacity());
        Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, list.toArray());
    }

    @Test
    void testGet() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(3, list.get(1));
        Assertions.assertEquals(2, list.get(2));
        Assertions.assertEquals(5, list.get(3));
        Assertions.assertEquals(4, list.get(4));
    }

    @Test
    void testGet_bad_index() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });
    }

    @Test
    void testSet() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        list.set(0, 0);
        Assertions.assertArrayEquals(new int[]{0, 3, 2, 5, 4}, list.toArray());

        list.set(3, 7);
        Assertions.assertArrayEquals(new int[]{0, 3, 2, 7, 4}, list.toArray());

        list.set(4, 6);
        Assertions.assertArrayEquals(new int[]{0, 3, 2, 7, 6}, list.toArray());
    }

    @Test
    void testSet_bad_index() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(-1, 0);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(5, 6);
        });
    }

    @Test
    void testInsert() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        list.insert(0, 0);
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 2, 5, 4}, list.toArray());

        list.insert(3, 7);
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 7, 2, 5, 4}, list.toArray());

        list.insert(6, 6);
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 7, 2, 5, 6, 4}, list.toArray());
    }

    @Test
    void testInsert_bad_index() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(-1, 0);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(5, 6);
        });
    }

    @Test
    void testRemove() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        int remove0 = list.remove(0);
        Assertions.assertEquals(1, remove0);
        Assertions.assertArrayEquals(new int[]{3, 2, 5, 4}, list.toArray());

        int remove2 = list.remove(2);
        Assertions.assertEquals(5, remove2);
        Assertions.assertArrayEquals(new int[]{3, 2, 4}, list.toArray());

        int remove1 = list.remove(1);
        Assertions.assertEquals(2, remove1);
        Assertions.assertEquals(2, list.size());
        Assertions.assertArrayEquals(new int[]{3, 4}, list.toArray());
    }

    @Test
    void testRemove_bad_index() {
        HelloArrayList list = new HelloArrayList(8);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(5);
        });
    }
}