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

import io.github.photowey.algorithm.in.action.linkedlist.Node;

/**
 * {@code LinkedListQueue}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/24
 */
public class LinkedListQueue {

    private Node front;
    private Node rear;
    private int size;

    // ----------------------------------------------------------------

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // ----------------------------------------------------------------

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

    public void push(int num) {
        Node node = new Node(num);
        // front -> null
        // rear -> null
        if (this.front() == null) {
            this.front(node);
            this.rear(node);
        } else {
            // front -> n1
            // n1 -> n2 -> ... nN
            // rear -> nN

            // n1 -> n2 -> ... nN -> node
            // rear -> node
            this.rear().next(node);
            this.rear(node);
        }

        this.size++;
    }

    // ----------------------------------------------------------------

    public int pop() {
        int target = this.peek();

        // front -> n1
        // n1 -> n2 -> ... nN
        // rear -> nN

        // front -> n2
        // n2 -> ... nN
        // rear -> nN
        this.front(this.front().next());

        this.size--;

        return target;
    }

    // ----------------------------------------------------------------

    public int peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return this.front().value();
    }

    // ----------------------------------------------------------------

    public int[] toArray() {
        Node root = this.front();

        int[] res = new int[this.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = root.value();
            root = root.next();
        }

        return res;
    }

    // ----------------------------------------------------------------

    private Node front() {
        return front;
    }

    private void front(Node front) {
        this.front = front;
    }

    private Node rear() {
        return rear;
    }

    private void rear(Node rear) {
        this.rear = rear;
    }

    // ----------------------------------------------------------------
}