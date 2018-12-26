package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Product;
import net.skhu.model.Option;
import net.skhu.model.Pagination;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "제품명"), new Option(2, "카테고리") };

	Option[] orderBy = { new Option(0, "id"), new Option(1, "제품명"), new Option(2, "카테고리") };

	Sort[] sort = { new Sort(Sort.Direction.ASC, "id"), new Sort(Sort.Direction.ASC, "productName"), new Sort(Sort.Direction.ASC, "category")};
	
	public default List<Product> findAll(Pagination pagination) {
		Pageable pageable =
				 PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
		
		Page<Product> page;
		String searchText = pagination.getSt();
		switch (pagination.getSb()) {
		case 1 : page = this.findByProductNameStartingWith(searchText, pageable); break;
		case 2 : page = this.findByCategoryContaining(searchText, pageable); break;
		default : page = this.findAll(pageable); break;
		}
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}
	
	public Page<Product> findByProductNameStartingWith(String product, Pageable pageable);
	public Page<Product> findByCategoryContaining(String category, Pageable pageable);
}
