package com.kenshine.arangodb.model;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 23:18
 * @description： Edge模型
 * @modified By：
 * @version: $
 */
@Edge
@Data
public class ChildOf {
    @Id
    private String id;

    @From
    private Character child;

    @To
    private Character parent;

    public ChildOf(final Character child, final Character parent) {
        super();
        this.child = child;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "ChildOf [id=" + id + ", child=" + child + ", parent=" + parent + "]";
    }

}
