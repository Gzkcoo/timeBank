package com.gzk.controller;

import com.gzk.entity.Produce;
import com.gzk.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProduceController {
    @Autowired
    @Qualifier("produceServiceImpl")
    private ProduceService produceService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addProduce(@RequestBody Produce produce){
        produceService.addProduce(produce);
        HashMap modleMap = new HashMap();
        modleMap.put("success","添加成功");
        return modleMap;
    }

    @RequestMapping("/delect")
    @ResponseBody
    public Map<String, Object> delectProduce(int id){
        produceService.deleteProduce(id);
        HashMap modleMap = new HashMap();
        modleMap.put("success","删除成功");
        return modleMap;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateProduce(@RequestBody Produce produce){
        produceService.updateProduce(produce);
        HashMap modleMap = new HashMap();
        modleMap.put("success","修改成功");
        return modleMap;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public Map<String, Object> queryall(){
        List<Produce> list = produceService.queryAllProduce();
        HashMap modleMap = new HashMap();
        modleMap.put("success","查找成功");
        modleMap.put("data",list);
        return modleMap;
    }

    @RequestMapping("/deleteMany")
    @ResponseBody
    public Map<String, Object> delectManyProduces(int[] ids){
        produceService.delectManyProduces(ids);
        HashMap modleMap = new HashMap();
        modleMap.put("success","批量删除成功");
        return modleMap;
    }

    @RequestMapping("/likequery")
    @ResponseBody
    public Map<String, Object> likeQueryByPage(String name,int pages,int limits){
        int start = (pages-1)*limits;
        List<Produce> list = produceService.likeQueryByPage(name,start,limits);
        System.out.println(name);
        System.out.println(list);
        System.out.println(limits);
        HashMap modleMap = new HashMap();
        modleMap.put("data",list);
        modleMap.put("success","模糊查询成功");
        return modleMap;
    }


}

