package com.layui.dao.entity;

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
 * @since 2019-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lead extends Model<Lead> {

    private static final long serialVersionUID = 1L;
    
    private int id;

    private String name;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
