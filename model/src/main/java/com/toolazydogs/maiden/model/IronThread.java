/**
 *
 * Copyright 2011 (C) The original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.toolazydogs.maiden.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class IronThread
{
    private final static ThreadLocal<List<IronMonitor>> locks = new ThreadLocal<List<IronMonitor>>()
    {
        @Override
        protected List<IronMonitor> initialValue()
        {
            return new ArrayList<IronMonitor>();
        }
    };

    public static void lock(IronMonitor object)
    {
        assert object != null;

        List<IronMonitor> list = locks.get();

        list.remove(object);
        list.add(object);
    }

    public static void unlock(IronMonitor object)
    {
        assert object != null;

        List<IronMonitor> list = locks.get();

        list.remove(object);
    }
}