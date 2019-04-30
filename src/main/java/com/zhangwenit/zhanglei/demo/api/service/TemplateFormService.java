package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.model.TemplateForm;
import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import com.zhangwenit.zhanglei.demo.api.repository.TemplateFormRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/30 3:43 PM
 * @Version 1.0
 **/
@Service
public class TemplateFormService {

    private final TemplateFormRepository templateFormRepository;

    public TemplateFormService(TemplateFormRepository templateFormRepository) {
        this.templateFormRepository = templateFormRepository;
    }

    /**
     * 添加表单id
     *
     * @param user
     * @param formId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void addForm(ThirdUser user, String formId) {
        if (StringUtils.isEmpty(formId)) {
            throw new IllegalArgumentException("formId can be not empty");
        }
        TemplateForm templateForm = new TemplateForm();
        templateForm.setFormId(formId);
        templateForm.setOpenId(user.getOpenId());
        templateForm.setState(1);
        templateFormRepository.save(templateForm);
    }

    /**
     * 获取某用户最早创建的表单
     *
     * @param openId
     * @return
     */
    public TemplateForm findOldestCanUseOne(String openId) {
        return templateFormRepository.findFirstByOpenIdAndStateOrderByIdAsc(openId, 1);
    }
}