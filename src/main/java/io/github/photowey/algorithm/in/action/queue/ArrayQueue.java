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
package io.github.photowey.algorithm.in.action.queue;

/**
 * {@code ArrayQueue}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/24
 */
public class ArrayQueue {

    private final int[] haystack;
    private int front;
    private int size;

    // ----------------------------------------------------------------

    public ArrayQueue(int capacity) {
        this.haystack = new int[capacity];
        this.front = 0;
        this.size = 0;
    }

    // ----------------------------------------------------------------

    public int capacity() {
        return this.haystack.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    // ----------------------------------------------------------------

    public int push(int num) {
        if (this.size() == this.capacity()) {
            return -1;
        }

        int rear = (this.front() + this.size()) % this.capacity();
        this.haystack[rear] = num;
        this.size++;

        return 1;
    }

    // ----------------------------------------------------------------

    public int pop() {
        int target = this.peek();

        int front = (this.front() + 1) % this.capacity();
        this.front(front);

        this.size--;

        return target;
    }

    // ----------------------------------------------------------------

    public int peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return this.haystack[this.front];
    }

    // ----------------------------------------------------------------

    public int[] toArray() {
        int[] res = new int[this.size()];

        for (int i = 0, j = front; i < this.size; i++, j++) {
            res[i] = this.haystack[j % this.capacity()];
        }

        return res;
    }

    // ----------------------------------------------------------------

    private int front() {
        return front;
    }

    private void front(int front) {
        this.front = front;
    }

    // ----------------------------------------------------------------
}