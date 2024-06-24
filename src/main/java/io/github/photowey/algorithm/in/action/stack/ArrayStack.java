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

import java.util.ArrayList;
import java.util.List;

/**
 * {@code ArrayStack}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/06/24
 */
public class ArrayStack {

    private List<Integer> stack;

    public ArrayStack() {
        this.stack = new ArrayList<>();
    }

    // ----------------------------------------------------------------

    public int size() {
        return this.stack.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    // ----------------------------------------------------------------

    public void push(int num) {
        this.stack.add(num);
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return this.stack.remove(this.size() - 1);
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return this.stack.get(this.size() - 1);
    }

    // ----------------------------------------------------------------

    public Object[] toArray() {
        return this.stack.toArray();
    }

    // ----------------------------------------------------------------
}