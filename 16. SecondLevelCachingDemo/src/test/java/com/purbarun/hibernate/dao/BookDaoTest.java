package com.purbarun.hibernate.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.purbarun.hibernate.dto.Book;

import net.sf.ehcache.CacheManager;

@DisplayName("BookDao under Test")
class BookDaoTest {

	@Test
	@DisplayName("Second Level Cache Test")
	void cacheTest() {
		Book book = new Book();
		book.setName("Hibernate in Action");
		book.setPrice(400);
		BookDao dao = new BookDao();
		dao.saveBook(book);
		dao.findById(book.getId());
		int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.purbarun.hibernate.dto.Book").getSize();
		assertThat(size).isGreaterThan(0).withFailMessage("Cache size should not be zero");
	}

}
