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
package io.github.photowey.algorithm.in.action.linkedlist;

import java.io.Serializable;

/**
 * {@code Node}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 6859236789513718452L;

    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value, int next) {
        this.value = value;
        this.next = new Node(next);
    }

    // ----------------------------------------------------------------

    public int value() {
        return value;
    }

    public Node next() {
        return next;
    }

    // ----------------------------------------------------------------

    public Node value(int value) {
        this.value = value;

        return this;
    }

    public Node next(Node next) {
        this.next = next;

        return this;
    }
}