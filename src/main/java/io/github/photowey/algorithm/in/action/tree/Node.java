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
package io.github.photowey.algorithm.in.action.tree;

import java.io.Serializable;

/**
 * {@code Node}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/23
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 1284914871098831326L;

    public int value;
    public int height;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    // ----------------------------------------------------------------

    public int value() {
        return value;
    }

    public int height() {
        return height;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    // ----------------------------------------------------------------

    public Node value(int value) {
        this.value = value;

        return this;
    }

    public Node height(int height) {
        this.height = height;

        return this;
    }

    public Node left(Node left) {
        this.left = left;

        return this;
    }

    public Node right(Node right) {
        this.right = right;

        return this;
    }
}