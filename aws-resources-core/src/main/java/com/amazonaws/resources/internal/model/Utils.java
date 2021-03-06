/*
 * Copyright 2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.resources.internal.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Utils {

    public static <T> List<T> makeImmutable(List<? extends T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public static <T> List<T> makeImmutableOrNull(List<? extends T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public static <K, V> Map<K, V> makeImmutable(
            Map<? extends K, ? extends V> map) {

        if (map == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * Returns true if the given path expression contains wildcards and could be
     * expanded to match multiple values.
     */
    public static boolean isMultiValuedPath(List<String> expression) {
        for (String element : expression) {
            if ("*".equals(element) || element.startsWith("*:")) {
                return true;
            }
        }
        return false;
    }
}
