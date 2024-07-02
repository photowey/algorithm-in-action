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
package io.github.photowey.algorithm.in.action.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code ArrayHashMapTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/07/03
 */
class ArrayHashMapTest {

    @Test
    void testInit() {
        ArrayHashMap ctx = new ArrayHashMap();

        Assertions.assertEquals(0, ctx.size());
    }

    @Test
    void testPut() {
        ArrayHashMap ctx = new ArrayHashMap();
        ctx.put(12836, "h");
        ctx.put(15937, "e");
        ctx.put(16750, "l");
        ctx.put(13276, "l");
        ctx.put(10583, "o");

        Assertions.assertEquals(5, ctx.size());
    }

    @Test
    void testGet() {
        ArrayHashMap ctx = new ArrayHashMap();
        ctx.put(12836, "h");
        ctx.put(15937, "e");
        ctx.put(16750, "l");
        ctx.put(13276, "l");
        ctx.put(10583, "o");

        Assertions.assertEquals(5, ctx.size());

        String v_15937 = ctx.get(15937);
        Assertions.assertEquals("e", v_15937);
    }

    @Test
    void testRemove() {
        ArrayHashMap ctx = new ArrayHashMap();
        ctx.put(12836, "h");
        ctx.put(15937, "e");
        ctx.put(16750, "l");
        ctx.put(13276, "l");
        ctx.put(10583, "o");

        Assertions.assertEquals(5, ctx.size());

        String v_15937 = ctx.get(15937);
        Assertions.assertEquals("e", v_15937);

        ctx.remove(10583);
        Assertions.assertEquals(4, ctx.size());
        String v_10583 = ctx.get(10583);
        Assertions.assertNull(v_10583);
    }

    @Test
    void testEntryList() {
        ArrayHashMap ctx = new ArrayHashMap();
        ctx.put(12836, "h");
        ctx.put(15937, "e");
        ctx.put(16750, "l");
        ctx.put(13276, "L");
        ctx.put(10583, "o");

        Assertions.assertEquals(5, ctx.size());

        List<AbstractMap.Entry> entries = ctx.entryList();
        Assertions.assertEquals(5, entries.size());

        List<Integer> keys = entries.stream().map(AbstractMap.Entry::key).collect(Collectors.toList());
        List<String> values = entries.stream().map(AbstractMap.Entry::value).collect(Collectors.toList());

        Assertions.assertTrue(keys.contains(12836));
        Assertions.assertTrue(keys.contains(15937));
        Assertions.assertTrue(keys.contains(16750));
        Assertions.assertTrue(keys.contains(13276));
        Assertions.assertTrue(keys.contains(10583));

        Assertions.assertTrue(values.contains("h"));
        Assertions.assertTrue(values.contains("e"));
        Assertions.assertTrue(values.contains("l"));
        Assertions.assertTrue(values.contains("L"));
        Assertions.assertTrue(values.contains("o"));
    }

    @Test
    void testKeyList() {
        ArrayHashMap ctx = new ArrayHashMap();
        ctx.put(12836, "h");
        ctx.put(15937, "e");
        ctx.put(16750, "l");
        ctx.put(13276, "L");
        ctx.put(10583, "o");

        Assertions.assertEquals(5, ctx.size());

        List<Integer> keys = ctx.keyList();
        Assertions.assertEquals(5, keys.size());

        Assertions.assertTrue(keys.contains(12836));
        Assertions.assertTrue(keys.contains(15937));
        Assertions.assertTrue(keys.contains(16750));
        Assertions.assertTrue(keys.contains(13276));
        Assertions.assertTrue(keys.contains(10583));
    }

    @Test
    void testValueList() {
        ArrayHashMap ctx = new ArrayHashMap();
        ctx.put(12836, "h");
        ctx.put(15937, "e");
        ctx.put(16750, "l");
        ctx.put(13276, "L");
        ctx.put(10583, "o");

        Assertions.assertEquals(5, ctx.size());

        List<String> values = ctx.valueList();
        Assertions.assertEquals(5, values.size());

        Assertions.assertTrue(values.contains("h"));
        Assertions.assertTrue(values.contains("e"));
        Assertions.assertTrue(values.contains("l"));
        Assertions.assertTrue(values.contains("L"));
        Assertions.assertTrue(values.contains("o"));
    }
}