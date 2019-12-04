package com.timer.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 0:42
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Cloneable, Serializable {
    /**
    * id
    */
    private Integer id;
    /**
    * name
    */
    private String name;
    /**
    * marriage
    */
    private Boolean marriage;
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
