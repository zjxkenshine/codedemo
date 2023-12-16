// Copyright © 2011-2013 Esko Luontola <www.orfjackal.net>
// This software is released under the Apache License 2.0.
// The license text is at http://www.apache.org/licenses/LICENSE-2.0

package com.kenshine.buildtest;

import com.google.common.collect.AbstractIterator;
import com.google.common.io.Closeables;
import fi.luontola.buildtest.AsmUtils;
import org.objectweb.asm.tree.ClassNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StubClasses implements Iterable<ClassNode> {

    private final List<Class<?>> classes;

    public StubClasses(Class<?>... classes) {
        this.classes = Arrays.asList(classes);
    }

    @Override
    public Iterator<ClassNode> iterator() {
        final Iterator<Class<?>> it = classes.iterator();
        return new AbstractIterator<ClassNode>() {
            @Override
            protected ClassNode computeNext() {
                if (!it.hasNext()) {
                    return endOfData();
                }
                Class<?> clazz = it.next();
                InputStream in = getClass().getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".class");
                try {
                    return AsmUtils.readClass(in);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    Closeables.closeQuietly(in);
                }
            }
        };
    }
}
