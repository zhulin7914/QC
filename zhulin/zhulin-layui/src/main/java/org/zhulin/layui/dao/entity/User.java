package org.zhulin.layui.dao.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhulin
 * @since 2019-03-21
 */
@Data
//@EqualsAndHashCode生成自定义的equals()方法和HashCode()方法
//当callSuper = false 不会调用父类的equals()方法和HashCode()方法
//当callSuper = true 会调用父类的equals()方法和HashCode()方法
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true) 使用链式设置属性，set方法返回的是this对象。
//若chain = false set方法返回的是void。
@Accessors(chain = true) 
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private String id;
    
    private String email;

    private String nickName;

    private String passWord;

    private String regTime;

    private String userName;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
