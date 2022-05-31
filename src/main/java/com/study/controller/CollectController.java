package com.study.controller;

import cn.hutool.core.util.StrUtil;
import com.study.base.annotaion.Login;
import com.study.base.dto.CollectDto;
import com.study.base.lang.Result;
import com.study.entity.Collect;
import com.study.entity.User;
import com.study.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectController extends BaseController {

	@Autowired
    SearchService searchService;

	@Login
	@GetMapping("/api/collects/{userId}/{dateline}")
	public Result userCollects(@PathVariable(name = "userId") long userId,
                               @PathVariable(name = "dateline") String dateline) {

		Page<CollectDto> page = collectService.findUserCollects(userId, dateline, getPage());

		return Result.success(page);
	}

	@Login
	@PostMapping("/api/collect/delete")
	public Result delCollect(long id) {

		Collect collect = collectService.findById(id);
		Assert.notNull(collect, "不存在该收藏");
		Assert.isTrue(getCurrentUserId() == collect.getUser().getId(), "无权限删除");

		collectService.deleteById(id);

		return Result.success();
	}

	@Login
	@PostMapping("/api/collect/save")
	public Result saveCollect(Collect collect) {

		Assert.hasLength(collect.getTitle(), "标题不能为空");
		Assert.hasLength(collect.getUrl(), "URL不能为空");

		if (collect.getId() != null) {
			Collect temp = collectService.findById(collect.getId());
			Assert.notNull(temp, "未找到对应收藏");
			Assert.isTrue(getCurrentUserId() == temp.getUser().getId(), "无权限编辑");
		}

		User user = new User();
		user.setId(getCurrentUserId());
		collect.setUser(user);

		collectService.save(collect);

		return Result.success();
	}

	@GetMapping("/api/collects/square")
	public Result collectsSquare(Long userId, String q) {

		Page<CollectDto> page;
		if (StrUtil.isNotBlank(q)) {
			// 正在搜索
			page = searchService.search(q, userId, getPage());
		} else {
			page = collectService.findSquareCollects(getPage());
		}

		return Result.success(page);
	}

}
