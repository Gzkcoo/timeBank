package com.gzk.dao;

import com.gzk.entity.Produce;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceMapper {
    //增加
    int addProduce(Produce produce);

    //删除
    int deleteProduce(int id);

    //修改
    int updateProduce(Produce produce);

    //查询
    Produce queryProduceById(int id);

    //查询所有产品
    List<Produce> queryAllProduce();

    //批量删除产品
    int delectManyProduces(int[] ids);

    //分页查询
    List<Produce> likeQueryByPage(@Param("name") String name,@Param("start") int start,@Param("limits") int limits);

}
