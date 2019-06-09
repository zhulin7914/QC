package cn.e3mall.service.impl;
import cn.e3mall.service.ItemService;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品管理Service
 */
@Service
class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Override
    public TbItem getItemByid(long id) {
        TbItem item = itemMapper.selectByPrimaryKey(id);
        return item;
    }
}