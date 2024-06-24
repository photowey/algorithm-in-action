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
package io.github.photowey.algorithm.in.action.stack;

import io.github.photowey.algorithm.in.action.linkedlist.Node;

/**
 * {@code LinkedListStack}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/24
 */
public class LinkedListStack {

    private Node head;
    private int size;

    // ----------------------------------------------------------------

    public LinkedListStack() {
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

        node.next(this.head());
        this.head(node);

        this.size++;
    }

    // ----------------------------------------------------------------

    public int pop() {
        int target = this.peek();

        this.head(this.head().next());
        this.size--;

        return target;
    }

    // ----------------------------------------------------------------

    public int peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return this.head().value();
    }

    // ----------------------------------------------------------------

    public int[] toArray() {
        Node root = this.head();

        int[] res = new int[this.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = root.value();
            root = root.next();
        }

        return res;
    }

    // ----------------------------------------------------------------

    private Node head() {
        return head;
    }

    private void head(Node node) {
        this.head = node;
    }
}