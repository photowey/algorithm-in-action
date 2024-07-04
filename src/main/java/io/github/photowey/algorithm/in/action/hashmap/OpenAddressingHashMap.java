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

/**
 * {@code OpenAddressingHashMap}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/07/04
 */
public class OpenAddressingHashMap extends AbstractMap {

    private int size;
    private int capacity;
    private double loadThreshold;
    private double extendRatio;
    private Entry[] buckets;

    private final Entry TOMBSTONE = new Entry(-1, "-1");

    public OpenAddressingHashMap() {
        this.size = 0;
        this.capacity = 4;
        this.loadThreshold = 2 / 3D;
        this.extendRatio = 3;
        this.buckets = new Entry[this.capacity];
    }

    // ----------------------------------------------------------------

    public void put(int key, String value) {
        if (this.loadFactor() > this.loadThreshold) {
            this.extend();
        }

        int index = this.findBucket(key);
        Entry entry = this.buckets[index];

        // Exists
        if (this.isOk(entry)) {
            this.buckets[index].value(value);

            return;
        }

        this.buckets[index] = new Entry(key, value);
        this.size++;
    }

    // ----------------------------------------------------------------

    public String get(int key) {
        int index = this.findBucket(key);
        Entry entry = this.buckets[index];
        if (this.isOk(entry)) {
            return entry.value();
        }

        return null;
    }

    // ----------------------------------------------------------------

    public void remove(int key) {
        int index = this.findBucket(key);
        Entry entry = this.buckets[index];
        if (this.isOk(entry)) {
            this.buckets[index] = TOMBSTONE;
            this.size--;
        }
    }

    // ----------------------------------------------------------------

    private int findBucket(int key) {
        int index = this.hash(key);

        // key = 19 -> 19/H
        // index = 3
        // -> D
        // firstTombstone == 5
        // 0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  | 11  | 12  | 13  | 14  | 15
        // A  |  B  |  C  |  D(35/D)_3  |  E_4  |  TMS_5  |  G_6  |  H_7(19/H)  |  TMS_8  |  J  |  K  |  L  |  TMS  |  N  |  O  |  P
        //                                           ↓                     ↓
        // A  |  B  |  C  |  D(35/v)_3  |  E_4  |  H_5(19/H)  |  G_6  |  TMS_7  |  TMS_8  |  J  |  K  |  L  |  TMS  |  N  |  O  |  P

        int firstTombstone = -1;

        while (this.buckets[index] != null) {
            if (this.buckets[index].key() == key) {
                if (firstTombstone != -1) {
                    this.buckets[firstTombstone] = this.buckets[index];
                    this.buckets[index] = TOMBSTONE;

                    return firstTombstone;
                }

                return index;
            }

            // First Tombstone
            if (firstTombstone == -1 && this.buckets[index] == TOMBSTONE) {
                firstTombstone = index;
            }

            // Move back
            index = (index + 1) % this.capacity;
        }

        return firstTombstone == -1 ? index : firstTombstone;
    }

    // ----------------------------------------------------------------

    private void extend() {
        Entry[] tmp = this.buckets;

        this.capacity *= this.extendRatio;
        this.buckets = new Entry[this.capacity];

        for (Entry entry : tmp) {
            if (this.isOk(entry)) {
                this.put(entry.key(), entry.value());
            }
        }
    }

    // ----------------------------------------------------------------

    private void print() {
        for (Entry entry : this.buckets) {
            if (entry == null) {
                System.out.println("__null__");
            } else if (entry == TOMBSTONE) {
                System.out.println("__TOMBSTONE__");
            } else {
                System.out.println(entry.key() + " -> " + entry.value());
            }
        }
    }

    // ----------------------------------------------------------------

    private boolean isOk(Entry entry) {
        return entry != null && entry != TOMBSTONE;
    }

    // ----------------------------------------------------------------

    private int hash(int key) {
        return key % this.capacity;
    }

    private double loadFactor() {
        return (double) this.size / this.capacity;
    }

}