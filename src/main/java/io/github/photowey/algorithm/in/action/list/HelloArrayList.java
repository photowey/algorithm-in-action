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

import java.io.Serializable;
import java.util.Arrays;

/**
 * {@code HelloArrayList}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public class HelloArrayList implements Serializable {

    private static final long serialVersionUID = 2799332671895008356L;

    private int[] array;
    private int capacity;
    private int size;
    private final int extendFactor;

    // ----------------------------------------------------------------

    public HelloArrayList() {
        this(16);
    }

    public HelloArrayList(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.extendFactor = 2;
    }

    // ----------------------------------------------------------------

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    // ----------------------------------------------------------------

    public void add(int value) {
        if (this.testExtendCapacityIfNecessary()) {
            this.extendCapacity();
        }

        this.array[size] = value;
        this.size++;
    }

    // ----------------------------------------------------------------

    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }

        return this.array[index];
    }

    // ----------------------------------------------------------------

    public void set(int index, int value) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }

        this.array[index] = value;
    }

    // ----------------------------------------------------------------

    public void insert(int index, int value) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }

        if (this.testExtendCapacityIfNecessary()) {
            this.extendCapacity();
        }

        for (int i = this.size - 1; i >= index; i--) {
            // i -> i + 1
            this.array[i + 1] = this.array[i];
        }

        this.array[index] = value;
        this.size++;
    }

    // ----------------------------------------------------------------

    public int remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }

        int target = this.array[index];

        for (int i = index; i < this.size - 1; i++) {
            // i <- i + 1
            this.array[i] = this.array[i + 1];
        }

        this.size--;

        return target;
    }

    // ----------------------------------------------------------------

    public int[] toArray() {
        int size = this.size();
        int[] copyArray = new int[size];

        for (int i = 0; i < size; i++) {
            copyArray[i] = this.get(i);
        }

        return copyArray;
    }

    // ----------------------------------------------------------------

    private boolean testExtendCapacityIfNecessary() {
        return this.size() == this.capacity();
    }

    // ----------------------------------------------------------------

    private void extendCapacity() {
        this.array = Arrays.copyOf(this.array, this.capacity() * this.extendFactor);
        this.capacity = this.array.length;
    }
}