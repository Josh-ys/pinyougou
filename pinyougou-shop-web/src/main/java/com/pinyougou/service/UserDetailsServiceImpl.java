package com.pinyougou.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;

/**
 * 认证类
 * 
 * @author Reasonless
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private SellerService sellerService;

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("UserDetailsServiceImpl------------");
		// 一个角色的集合
		List<GrantedAuthority> authorities = new ArrayList<>();
		// 往集合中添加角色,构建角色列表
		authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
		//得到商家对象
		TbSeller seller = sellerService.findOne(username);
		if (seller != null) {
			if (seller.getStatus().equals("1")) {
				return new User(username, seller.getPassword(), authorities);
			} else {
				return null;
			}
		} else {
			// 返回null标志登录不通过
			return null;
		}
	}

}
