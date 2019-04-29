package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author by zhangwen
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByState(Integer state);
}
