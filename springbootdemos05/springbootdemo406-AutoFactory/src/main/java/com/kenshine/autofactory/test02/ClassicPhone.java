package com.kenshine.autofactory.test02;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import lombok.Data;

/**
 *  @AutoFactory用在构造函数
 */
@Data
public class ClassicPhone {

    private final String dialpad;
    private final String ringer;
    private String otherParts;

    @AutoFactory
    public ClassicPhone(
            @Provided String dialpad, @Provided String ringer) {
        this.dialpad = dialpad;
        this.ringer = ringer;
    }

    @AutoFactory
    public ClassicPhone(String otherParts) {
        this("defaultDialPad","defaultRinger");
        this.otherParts = otherParts;
    }

    /**
     * 支持注解参数
     * AutoFactory将保留@Named @Qualifier，以便我们可以使用它，例如，在使用依赖注入框架时
     *  PhoneAssembler(
     *       @Provided @Named("Sony") Camera camera, String otherParts) {
     *         this.camera = camera;
     *         this.otherParts = otherParts;
     *     }
     */

}