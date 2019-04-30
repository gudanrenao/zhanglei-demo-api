package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.TemplateForm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by zhangwen
 */
public interface TemplateFormRepository extends JpaRepository<TemplateForm, Long> {

    TemplateForm findFirstByOpenIdAndStateOrderByIdAsc(String openId,Integer state);

}
