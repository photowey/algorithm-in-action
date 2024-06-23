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

/**
 * {@code LinkedList}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public final class LinkedList {

    private LinkedList() {}

    public static void insert(Node root, Node p) {
        checkNPE(root, "Node root can't be null");
        checkNPE(p, "Node p can't be null");

        // root -> n1 -> n2 -> n3

        // n1 -> n2 -> n3
        Node n1 = root.next();
        // p -> n1 -> n2 -> n3
        p.next(n1);

        // root -> p -> n1 -> n2 -> n3
        root.next(p);
    }

    // ----------------------------------------------------------------

    public static void remove(Node root) {
        if (root.next() == null) {
            return;
        }

        // root -> n1 -> n2 -> n3

        // n1 -> n2 -> n3
        Node n1 = root.next();
        // n2 -> n3
        Node n2 = n1.next();

        // root -> n2 -> n3
        root.next(n2);
    }

    // ----------------------------------------------------------------

    public static Node access(Node root, int index) {
        for (int i = 0; i < index; i++) {
            if (root == null) {
                return null;
            }

            root = root.next();
        }

        return root;
    }

    // ----------------------------------------------------------------

    public static int find(Node root, int target) {
        int index = 0;

        while (root != null) {
            if (root.value() == target) {
                return index;
            }
            root = root.next();
            index++;
        }

        return -1;
    }

    // ----------------------------------------------------------------

    private static void checkNPE(Node root, String message) {
        if (null == root) {
            throw new NullPointerException(message);
        }
    }
}