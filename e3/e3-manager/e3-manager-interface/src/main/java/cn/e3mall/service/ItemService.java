package cn.e3mall.service;

import cn.e3mall.pojo.TbItem;
import org.springframework.stereotype.Service;


@Service
public interface ItemService {
    /**
     * 根据商品id查询商品信息
     *
     * @param id
     * @return
     */
    public TbItem getItemByid(long id);
}