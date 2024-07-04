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

/**
 * {@code ChainingHashMap}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/07/04
 */
public class ChainingHashMap extends AbstractMap {

    private int size;
    private int capacity;
    private double loadThreshold;
    private double extendRatio;

    private List<List<Entry>> buckets;

    public ChainingHashMap() {
        this.size = 0;
        this.capacity = 4;
        this.loadThreshold = 2 / 3D;
        this.extendRatio = 2;

        this.buckets = new ArrayList<>(this.capacity);

        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    // ----------------------------------------------------------------

    public void put(int key, String value) {
        if (this.loadFactor() > this.loadThreshold) {
            this.extend();
        }

        int index = this.hash(key);

        List<Entry> bucket = this.buckets.get(index);

        for (Entry entry : bucket) {
            if (entry.key() == key) {
                entry.value(value);
                return;
            }
        }

        Entry tail = new Entry(key, value);
        bucket.add(tail);

        this.size++;
    }

    // ----------------------------------------------------------------

    public String get(int key) {
        int index = this.hash(key);

        List<Entry> bucket = this.buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key() == key) {

                return entry.value();
            }
        }

        return null;
    }

    // ----------------------------------------------------------------

    public void remove(int key) {
        int index = this.hash(key);
        List<Entry> bucket = this.buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key() == key) {
                bucket.remove(entry);

                this.size--;

                break;
            }
        }
    }

    // ----------------------------------------------------------------

    private void extend() {
        List<List<Entry>> tmp = buckets;

        this.capacity *= this.extendRatio;
        this.buckets = new ArrayList<>(this.capacity);

        this.size = 0;

        for (List<Entry> entries : tmp) {
            for (Entry entry : entries) {
                this.put(entry.key(), entry.value());
            }
        }
    }

    // ----------------------------------------------------------------


    private void print() {
        for (List<Entry> bucket : this.buckets) {
            List<String> res = new ArrayList<>();
            for (Entry entry : bucket) {
                res.add(entry.key() + " -> " + entry.value());
            }

            System.out.println(res);
        }
    }

    // ----------------------------------------------------------------

    private int hash(int key) {
        return key % this.capacity;
    }

    private double loadFactor() {
        return (double) this.size / this.capacity;
    }
}