package com.gzk.service;

import com.gzk.dao.ProduceMapper;
import com.gzk.entity.Produce;

import java.util.List;

public class ProduceServiceImpl implements ProduceService{
    private ProduceMapper produceMapper;

    public void setProduceMapper(ProduceMapper produceMapper) {
        this.produceMapper = produceMapper;
    }


    @Override
    public int addProduce(Produce produce) {
        return produceMapper.addProduce(produce);
    }

    @Override
    public int deleteProduce(int id) {
        return produceMapper.deleteProduce(id);
    }

    @Override
    public int updateProduce(Produce produce) {
        return produceMapper.updateProduce(produce);
    }

    @Override
    public Produce queryProduceById(int id) {
        return produceMapper.queryProduceById(id);
    }

    @Override
    public List<Produce> queryAllProduce() {
        return produceMapper.queryAllProduce();
    }

    @Override
    public int delectManyProduces(int[] ids){
        return produceMapper.delectManyProduces(ids);
    }

    @Override
    //分页查询
    public List<Produce> likeQueryByPage(String name,int start,int limits){
        return produceMapper.likeQueryByPage(name,start,limits);
    }


}
