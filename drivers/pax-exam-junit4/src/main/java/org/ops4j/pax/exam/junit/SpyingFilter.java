/*
 * Copyright 2016 Harald Wellmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.exam.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public class SpyingFilter extends Filter {

    private Filter delegate;

    private List<Description> matchingChildren = new ArrayList<>();

    public SpyingFilter(Filter delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean shouldRun(Description description) {

        boolean matching = delegate.shouldRun(description);
        if (matching) {
            matchingChildren.add(description);
        }
        return matching;
    }

    @Override
    public String describe() {
        return delegate.describe();
    }


    /**
     * @return the matchingChildren
     */
    public List<Description> getMatchingChildren() {
        return matchingChildren;
    }



}