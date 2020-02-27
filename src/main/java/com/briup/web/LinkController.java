package com.briup.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Link;
import com.briup.exception.CustomerException;
import com.briup.service.ILinkService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Link")
@Api(description="链接相关接口")
public class LinkController {
	@Autowired
	private ILinkService linkService;
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation("保存或者更新链接信息，如果id为空则为保存，否则为更新")
	public Message<String> saveOrUpdate(Link link){
		linkService.saveOrupdate(link);
		return MessageUtil.success("保存成功");
	}
	
	@GetMapping("/findAll")
	@ApiOperation("查询所有的链接信息")
	public Message<List<Link>> findAll(){
		List<Link> linklist = linkService.findAll();
		return MessageUtil.success(linklist);
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查询链接信息")
	@ApiImplicitParam(name="id",value="链接id",paramType="query",dataType="int",required=true)
	public Message<Link> findById(Integer id){
			/*	if(id!=null) {
			Link link = linkService.findById(id);
			return MessageUtil.success(link);
		}else {
			return MessageUtil.error(500, "id不存在");
		}*/
		/*try {
			Link link = linkService.findById(id);
			return MessageUtil.success(link);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return MessageUtil.error(500, "id不存在");
		}*/
		
		/*try {
			Link link = linkService.findById(id);
			return MessageUtil.success(link);
		} catch (CustomerException e) {
			// TODO: handle exception
			return MessageUtil.error(e.getCode(), e.getMessage());
		}*/
		Link link = linkService.findById(id);
		return MessageUtil.success(link);
	}
	
	@GetMapping("/deleteById")
	@ApiOperation("根据id删除一个链接")
	@ApiImplicitParam(name="id",value="链接id",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(Integer id){
		/*try {
			linkService.deleteById(id);
			return MessageUtil.success("删除成功");
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MessageUtil.error(500, "id并不存在");
		}*/
		try {
			linkService.deleteById(id);
			return MessageUtil.success("删除成功");
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), e.getMessage());
		}
		
		
	}
	
}
