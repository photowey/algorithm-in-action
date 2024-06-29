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
 * {@code ArrayDeque}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/29
 */
public class ArrayDeque {

    private final int[] haystack;
    private int front;
    private int size;

    // ----------------------------------------------------------------

    public ArrayDeque(int capacity) {
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

    public int pushFirst(int num) {
        if (this.size() == this.capacity()) {
            return -1;
        }

        int newFront = this.index(this.front() - 1);
        this.front(newFront);
        this.haystack[this.front()] = num;

        this.size++;

        return 1;
    }

    public int pushLast(int num) {
        if (this.size() == this.capacity()) {
            return -1;
        }

        int rear = this.index(this.front() + this.size());
        this.haystack[rear] = num;

        this.size++;

        return 1;
    }

    public int popFirst() {
        int first = this.peekFirst();

        int front = this.index(this.front() + 1);
        this.front(front);
        this.size--;

        return first;
    }

    public int popLast() {
        int last = this.peekLast();

        this.size--;

        return last;
    }

    public int peekFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return this.haystack[this.front()];
    }

    public int peekLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int last = this.index(this.front() + this.size() - 1);

        return this.haystack[last];
    }

    // ----------------------------------------------------------------

    public int[] toArray() {
        int[] res = new int[this.size()];
        for (int i = 0, j = this.front(); i < this.size(); i++, j++) {
            res[i] = this.haystack[this.index(j)];
        }

        return res;
    }

    // ----------------------------------------------------------------

    private int index(int index) {
        return (index + this.capacity()) % this.capacity();
    }

    // ----------------------------------------------------------------

    private int front() {
        return front;
    }

    private void front(int front) {
        this.front = front;
    }
}