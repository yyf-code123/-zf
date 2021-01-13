package com.zf;

import com.zf.dao.ArticleDao;
import com.zf.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Resource
    ArticleDao articleDao;

    @Test
    @Rollback(value = false)
    public void Test(){
        Article article = new Article();
        article.setClassificationId(1);
        article.setContent("闽南师范大学");
        articleDao.save(article);
    }
}
