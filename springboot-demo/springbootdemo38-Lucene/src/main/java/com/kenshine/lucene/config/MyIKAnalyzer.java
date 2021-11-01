package com.kenshine.lucene.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 9:24
 * @description：自定义IK分析器
 * @modified By：
 * @version: $
 */
public class MyIKAnalyzer extends Analyzer{

    private boolean useSmart;

    public boolean useSmart() {
        return this.useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public MyIKAnalyzer() {
        this(false);
    }

    @Override
    protected TokenStreamComponents createComponents(String s) {
        Tokenizer _MyIKTokenizer = new MyIKTokenizer(this.useSmart());
        return new TokenStreamComponents(_MyIKTokenizer);
    }

    public MyIKAnalyzer(boolean useSmart) {
        this.useSmart = useSmart;
    }

}
