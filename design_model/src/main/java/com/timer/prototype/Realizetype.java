package com.timer.prototype;

import java.io.*;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 0:31
 */
public class Realizetype implements Cloneable,Serializable{
    private Person person;
    private Integer num;
    public Realizetype() {
        System.out.println("具体原型类创建成功！");
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //浅克隆
    public Object clone() throws CloneNotSupportedException {
        return (Realizetype) super.clone();
    }
    //深克隆（通过重写clone方法）
    public Object deepClone() throws CloneNotSupportedException {
        Realizetype result = (Realizetype)super.clone();
        if (person !=null) {
            result.person = (Person)person.clone();
        }
        return result;
    }
    //深克隆（通过流实现深度克隆）
    public Object deepCloneByStream() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        ByteArrayInputStream bios = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bios);
        Object result = ois.readObject();
        ois.close();
        bios.close();
        oos.close();
        baos.close();
        return result;
    }

}
