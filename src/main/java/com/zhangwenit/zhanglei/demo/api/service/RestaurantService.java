package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantListDto;
import com.zhangwenit.zhanglei.demo.api.dto.criteria.RestaurantCriteria;
import com.zhangwenit.zhanglei.demo.api.model.Restaurant;
import com.zhangwenit.zhanglei.demo.api.repository.RestaurantRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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

    /**
     * 分页条件查询
     *
     * @param criteria
     * @return
     */
    public Page<RestaurantListDto> findByCriteria(RestaurantCriteria criteria) {
        criteria.check();
        PageRequest pageRequest = PageRequest.of(criteria.getCurrPage() - 1, criteria.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
        //todo: Example
////        Example<RestaurantCriteria> example = Example.of(criteria,matcher);
        Page<Restaurant> page = restaurantRepository.findAll(criteriaBuilder(criteria), pageRequest);
        return page.map(RestaurantListDto::new);
    }

    private Specification<Restaurant> criteriaBuilder(final RestaurantCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotEmpty(criteria.getRestaurantName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + criteria.getRestaurantName() + "%"));
            }
            if (criteria.getState() != null && (criteria.getState() == StateConstant.RESTAURANT_STATE_ACTIVE || criteria.getState() == StateConstant.RESTAURANT_STATE_FREEZE)) {
                predicates.add(criteriaBuilder.equal(root.get("state"), criteria.getState()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}