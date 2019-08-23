package cn.gshkb.elasticsearch.test3;


import cn.gshkb.elasticsearch.model.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringElasticsearchApplicationTests {

	@Test
	public void contextLoads() {
	}

	/*@Autowired
	private ArticleSearchRepository articleSearchRepository;*/

	@Test
	public void testSaveArticleIndex(){
		Author author = new Author();
		author.setId(1L);
		author.setName("王龙");
		author.setRemark("标识");

		Tutorial tutorial = new Tutorial();
		tutorial.setId(1L);
		tutorial.setName("elastic search 是世界上最好的搜索引擎");

		Article article = new Article();
		article.setId(1L);
		article.setTitle("elastic search 是世界上最好的搜索引擎");
		article.setAbstracts("elastic search 是世界上最好的搜索引擎文章");
		article.setTutorial(tutorial);
		article.setAuthor(author);
		article.setContent("elastic search 是世界上最好的搜索引擎;elastic search 是世界上最好的搜索引擎文章");
		article.setPostTime("20180704");
		article.setClickCount("1");
		/*articleSearchRepository.save(article);*/

	}

	@Test
	public void testSearch(){
		String                  queryString  ="王超";//搜索关键字
	/*	QueryStringQueryBuilder builder      =new QueryStringQueryBuilder(queryString);
		Iterable<Article>       searchResult = articleSearchRepository.search(builder);
		Iterator<Article>       iterator     = searchResult.iterator();
		Page<Article>                search = articleSearchRepository.search(builder,new PageRequest(0,10));
		List<Article> list                = search.getContent();
		System.out.println(list.toString());*/
	}

}
