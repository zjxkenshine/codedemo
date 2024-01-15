package com.kenshine.graphviz;

import org.apache.maven.plugins.javadoc.options.Taglet;

/**
 * Support graphviz inside javadoc.
 * <p>
 * {@graphviz
 * graph test { a -- b }
 * }
 * </p>
 * So easy.
 */
public class GraphvizTagle extends Taglet {
    // graphviz在注释中使用
}
