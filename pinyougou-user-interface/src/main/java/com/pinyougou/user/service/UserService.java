package com.pinyougou.user.service;

import com.pinyougou.pojo.TbUser;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface UserService {

    /**
     * 返回全部列表
     *
     * @return
     */
    public List<TbUser> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    public void add(TbUser user);


    /**
     * 修改
     */
    public void update(TbUser user);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    public TbUser findOne(Long id);


    /**
     * 批量删除
     *
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 分页
     *
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(TbUser user, int pageNum, int pageSize);


    /**
     * 发送短信验证码
     *
     * @param phone
     */
    public void createSmsCode(String phone);

    /**
     * 校验验证码
     *
     * @param phone
     * @param code
     * @return
     */
    public boolean checkSmsCode(String phone, String code);

    /**
     * 成功后发送的短信验证码通知
     *
     * @param name
     */
    void succesMessage(String name,String phone);

}
