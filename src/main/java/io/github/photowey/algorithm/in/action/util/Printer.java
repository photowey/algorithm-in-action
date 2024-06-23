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
package io.github.photowey.algorithm.in.action.util;

import io.github.photowey.algorithm.in.action.linkedlist.Node;

/**
 * {@code Printer}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public final class Printer {

    private static final String EMPTY_STRING = "";
    private static final String LINKED_LIST_SYMBOL = " -> ";
    private static final String LINKED_LIST_SYMBOL_PATTERN = " -> $";

    public static String printLinkedList(Node head) {
        return printLinkedList(head, false);
    }

    public static String printLinkedList(Node head, boolean printEnabled) {
        StringBuilder buffer = new StringBuilder();

        while (head != null) {
            buffer.append(head.value()).append(LINKED_LIST_SYMBOL);
            head = head.next();
        }

        String joined = buffer.toString().replaceAll(LINKED_LIST_SYMBOL_PATTERN, EMPTY_STRING);
        if (printEnabled) {
            System.out.println(joined);
        }

        return joined;
    }
}