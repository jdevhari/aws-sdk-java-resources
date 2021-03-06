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
package com.amazonaws.resources.identitymanagement.internal;

import java.util.Iterator;

import com.amazonaws.resources.ResourcePage;
import com.amazonaws.resources.ResultCapture;
import com.amazonaws.resources.identitymanagement.Role;
import com.amazonaws.resources.identitymanagement.RoleCollection;
import com.amazonaws.resources.internal.ResourceCollectionImpl;
import com.amazonaws.resources.internal.StandardPageIterable;
import com.amazonaws.resources.internal.StandardResourceIterator;
import com.amazonaws.resources.internal.StandardResourcePage;

class RoleCollectionImpl implements RoleCollection {

    private final ResourceCollectionImpl impl;

    public RoleCollectionImpl(ResourceCollectionImpl impl) {
        this.impl = impl;
    }

    @Override
    public Iterator<Role> iterator() {
        return new StandardResourceIterator<Role>(impl.iterator(),
                RoleImpl.CODEC);
    }

    @Override
    public Iterable<ResourcePage<Role>> pages() {
        return new StandardPageIterable<Role>(impl.pages(), RoleImpl.CODEC);
    }

    @Override
    public ResourcePage<Role> firstPage() {
        return firstPage(null);
    }

    @Override
    public ResourcePage<Role> firstPage(ResultCapture<Object> extractor) {
        return new StandardResourcePage<Role>(impl.firstPage(extractor),
                RoleImpl.CODEC);
    }
}
