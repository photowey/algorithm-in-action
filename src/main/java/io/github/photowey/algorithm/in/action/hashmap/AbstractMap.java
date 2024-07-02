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
package io.github.photowey.algorithm.in.action.hashmap;

/**
 * {@code AbstractMap}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2024/07/03
 */
public abstract class AbstractMap {

    public static class Entry {

        private int key;

        private String value;


        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        // ----------------------------------------------------------------

        public int key() {
            return key;
        }

        public String value() {
            return value;
        }

        // ----------------------------------------------------------------

        public Entry key(int key) {
            this.key = key;

            return this;
        }

        public Entry value(String value) {
            this.value = value;

            return this;
        }

        // ----------------------------------------------------------------
    }

}