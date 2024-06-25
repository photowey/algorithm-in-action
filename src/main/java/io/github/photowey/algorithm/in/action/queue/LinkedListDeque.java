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
 * {@code LinkedListDeque}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/26
 */
public class LinkedListDeque {

    private Node front;
    private Node rear;
    private int size;

    // ----------------------------------------------------------------

    public LinkedListDeque() {
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

    public void pushFirst(int num) {
        this.push(num, true);
    }

    public void pushLast(int num) {
        this.push(num, false);
    }

    private void push(int num, boolean fronted) {
        Node node = new Node(num);
        if (this.isEmpty()) {
            // front -> node
            this.front(node);
            // node <- rear
            this.rear(node);
            // ↓
            // front -> n1 <- rear
        } else if (fronted) {
            // front -> n1 <- -> n2 <- -> nN
            // ↓
            // node <- n1 <- -> n2 <- -> nN
            this.front().prev(node);
            // node <- -> n1 <- -> n2 <- -> nN
            node.next(this.front());
            // front -> node <- -> n1 <- -> n2 <- -> nN
            this.front(node);
        } else {
            // front -> n1 <- -> n2 <- -> nN <- rear
            // ↓
            // front -> n1 <- -> n2 <- -> nN -> node
            this.rear().next(node);
            // front -> n1 <- -> n2 <- -> nN <- -> node
            node.prev(this.rear());

            // front -> n1 <- -> n2 <- -> nN <- -> node <- rear
            // ↓
            // front -> n1 <- -> n2 <- -> nN_1' <- -> nN' <- rear
            this.rear(node);
        }

        this.size++;
    }

    // ----------------------------------------------------------------

    public int popFirst() {
        return this.pop(true);
    }

    public int popLast() {
        return this.pop(false);
    }

    public int pop(boolean fronted) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int target = 0;
        if (fronted) {
            target = this.front().value();

            // front -> n1
            // n1 <- -> n2 <- -> nN
            // rear -> nN

            // front -> n1 <- -> n2 <- -> nN
            // ↓
            // n1 <- -> n2 <- -> nN
            Node n1 = this.front().next();
            if (n1 != null) {
                // front -> n1 <- -> n2 <- -> nN
                n1.prev(null);
                // front -x- n1 <- -> n2 <- -> nN
                // n1 <- -> n2 <- -> nN
                this.front().next(null);
            }

            // front' -> n1 <- -> n2 <- -> nN
            this.front(n1);
        } else {
            // front <- -> n1 <- -> n2 <- -> nN
            // rear -> nN
            target = this.rear().value();

            // front -> n1 <- -> nN_1 <- -> nN <- rear
            Node nN_1 = this.rear().prev();
            if (nN_1 != null) {
                // front -> n1 <- -> nN_1 <- -x- [ nN ] <- rear
                nN_1.next(null);
                // front -> n1 <- -> nN_1 <- nN -x- [ rear ]
                this.rear().prev(null);
            }

            // front -> n1 <- -> nN_1'(nN_2) <- -> nN'(nN_1) <- rear
            this.rear(nN_1);
        }

        this.size--;

        return target;
    }

    // ----------------------------------------------------------------

    public int peekFirst() {
        return this.peek(true);
    }

    public int peekLast() {
        return this.peek(false);
    }

    public int peek(boolean fronted) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        if (fronted) {
            return this.front().value();
        }

        return this.rear().value();
    }

    // ----------------------------------------------------------------

    public int[] toArray() {
        int[] res = new int[this.size()];

        Node root = this.front();
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