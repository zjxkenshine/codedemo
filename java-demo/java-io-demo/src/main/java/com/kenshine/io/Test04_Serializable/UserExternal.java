package com.kenshine.io.Test04_Serializable;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 22:59
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class UserExternal implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int number;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(number);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException{
        this.name = in.readUTF();
        this.number = in.readInt();
    }
}
