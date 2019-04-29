package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantListDto;
import com.zhangwenit.zhanglei.demo.api.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 5:33 PM
 * @Version 1.0
 **/
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * 获取所有的正常的饭店列表
     *
     * @return
     */
    public List<RestaurantListDto> findAllNormalRestaurant() {
        return restaurantRepository.findAllByState(StateConstant.RESTAURANT_STATE_ACTIVE).stream().map(RestaurantListDto::new).collect(Collectors.toList());
    }
}