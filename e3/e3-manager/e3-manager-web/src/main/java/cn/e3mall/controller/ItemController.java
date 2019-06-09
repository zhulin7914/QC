package cn.e3mall.controller;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 商品管理Controller
 * controller注解中加上了 ResponseBody 注解，代表返回json格式
 */
@Controller
@RequestMapping("/mvc")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * PathVariable  注解，代表路径变量请求方式
     * ResponseBody  注解，代表返回json格式
     * http://localhost:8081/e3-manager-web/mvc/test/4444
     * @param itemId
     * @return
     */
    @RequestMapping(value = "/test/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        System.out.println(itemId);
        TbItem item = itemService.getItemByid(itemId);
        System.out.println(item.toString());
        return item;
    }

    /**
     * RequestParam  注解，代表参数请求方式
     * ResponseBody  注解，代表返回json格式
     * http://localhost:8081/e3-manager-web/mvc/test?page=1&limit=12
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public TbItem all(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
        System.out.println("page: " + page + "  limit：" + limit);
        TbItem item = itemService.getItemByid(page);
        System.out.println(item.toString());
        return item;
    }

    /**
     * RequestBody   注解，代表请求json格式
     * ResponseBody  注解，代表返回json格式
     *
     * @param tbItem
     * @return
     */
    @RequestMapping(value = "/test/json", method = RequestMethod.POST)
    @ResponseBody
    public TbItem testJson(@RequestBody TbItem tbItem) {
        System.out.println(tbItem.getId());
        return tbItem;
    }

    @RequestMapping("/update")
    public String update() {
        return "update";
    }

//    /**
//     * 文件上传
//     *
//     * @param req
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/uploadDate", method = RequestMethod.POST)
//    public String upload(HttpServletRequest req) throws Exception {
//        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
//        MultipartFile file = mreq.getFile("file");
//        String fileName = file.getOriginalFilename();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/") +
//                "upload/" + sdf.format(LocalDate.now()) + fileName.substring(fileName.lastIndexOf('.')));
//        fos.write(file.getBytes());
//        fos.flush();
//        fos.close();
//
//        return "hello";
//    }
}