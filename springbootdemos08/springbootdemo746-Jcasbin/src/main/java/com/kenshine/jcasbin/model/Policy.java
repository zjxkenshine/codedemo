package com.kenshine.jcasbin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kenshine
 * 策略模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
  /**想要访问资源的用户 或者角色*/
  private String sub;
  
  /**将要访问的资源，可以使用 * 作为通配符，例如/user/* */
  private String obj;
  
  /**用户对资源执行的操作。HTTP方法，GET、POST、PUT、DELETE等，可以使用 * 作为通配符*/
  private String act;
}
