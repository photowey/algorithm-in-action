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

import io.github.photowey.algorithm.in.action.util.Printer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code LinkedListTest}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public class LinkedListTest {

    @Test
    void testInit() {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        root.next(n2);
        n2.next(n3);
        n3.next(n4);
        n4.next(n5);

        String linkedList = Printer.printLinkedList(root);
        Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5", linkedList);
    }

    @Test
    void testInit_chain() {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        String linkedList = Printer.printLinkedList(root);
        Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5", linkedList);
    }

    @Test
    void testInsert() {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        Node p = new Node(6);
        LinkedList.insert(root, p);

        String linkedList = Printer.printLinkedList(root);
        Assertions.assertEquals("1 -> 6 -> 2 -> 3 -> 4 -> 5", linkedList);
    }

    @Test
    void testRemove() {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        LinkedList.remove(root);

        String linkedList = Printer.printLinkedList(root);
        Assertions.assertEquals("1 -> 3 -> 4 -> 5", linkedList);
    }

    @Test
    void testAccess() {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        Node target = LinkedList.access(root, 3);

        String linkedList = Printer.printLinkedList(target);
        Assertions.assertEquals("4 -> 5", linkedList);
    }

    @Test
    void testFind() {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        int index = LinkedList.find(root, 3);

        Assertions.assertEquals(2, index);
    }
}