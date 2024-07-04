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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * {@code ArrayHashMap}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/07/03
 */
public class ArrayHashMap extends AbstractMap {

    private final static int INIT_BUCKETS_SIZE = 100;
    private final List<Entry> buckets;
    private int size;

    public ArrayHashMap() {
        this(INIT_BUCKETS_SIZE);
    }

    public ArrayHashMap(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Invalid parameter capacity:[" + capacity + "]");
        }

        this.buckets = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            this.buckets.add(null);
        }

        this.size = 0;
    }

    // ----------------------------------------------------------------

    public void put(int key, String value) {
        Entry entry = new Entry(key, value);
        int index = this.hash(key);

        this.buckets.set(index, entry);

        this.size++;
    }

    // ----------------------------------------------------------------

    public String get(int key) {
        int index = this.hash(key);

        Entry entry = this.buckets.get(index);
        if (this.isNotEmpty(entry)) {
            return entry.value();
        }

        return null;
    }

    // ----------------------------------------------------------------

    public void remove(int key) {
        int index = this.hash(key);
        this.buckets.set(index, null);

        this.size--;
    }

    // ----------------------------------------------------------------

    public List<Entry> entryList() {
        List<Entry> entries = new ArrayList<>();

        for (Entry bucket : this.buckets) {
            if (this.isNotEmpty(bucket)) {
                entries.add(bucket);
            }
        }

        //this.buckets.stream().filter(this::isNotEmpty).collect(Collectors.toList());

        return entries;
    }

    // ----------------------------------------------------------------

    public List<Integer> keyList() {
        List<Integer> keys = new ArrayList<>();

        for (Entry bucket : this.buckets) {
            if (this.isNotEmpty(bucket)) {
                keys.add(bucket.key());
            }
        }

        return keys;
    }

    // ----------------------------------------------------------------

    public List<String> valueList() {
        List<String> values = new ArrayList<>();

        for (Entry bucket : this.buckets) {
            if (this.isNotEmpty(bucket)) {
                values.add(bucket.value());
            }
        }

        return values;
    }

    // ----------------------------------------------------------------

    public void print() {
        for (Entry bucket : this.buckets) {
            System.out.println(bucket.key() + " -> " + bucket.value());
        }
    }

    // ----------------------------------------------------------------

    private int hash(int key) {
        int index = key % INIT_BUCKETS_SIZE;
        // ...

        return index;
    }

    // ----------------------------------------------------------------

    public int size() {
        return size;
    }

    private void size(int size) {
        this.size = size;
    }

    // ----------------------------------------------------------------

    private <T> boolean isNotEmpty(T target) {
        return !this.isEmpty(target);
    }

    public <T> boolean isEmpty(T target) {
        return Objects.isNull(target);
    }
}