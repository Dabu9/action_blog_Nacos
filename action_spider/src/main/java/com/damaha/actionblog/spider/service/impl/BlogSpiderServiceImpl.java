package com.damaha.actionblog.spider.service.impl;


import com.damaha.actionblog.spider.entity.BlogSpider;
import com.damaha.actionblog.spider.mapper.BlogSpiderMapper;
import com.damaha.actionblog.spider.service.BlogSpiderService;
import com.damaha.actionblog.base.serviceImpl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客爬取服务实现类
 * </p>
 *
 * @author 陌溪
 * @since 2020年2月7日21:29:42
 */
@Slf4j
@Service
public class BlogSpiderServiceImpl extends SuperServiceImpl<BlogSpiderMapper, BlogSpider> implements BlogSpiderService {

}
