package com.wei.springboottucao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wei.springboottucao.entity.Remark;

@Transactional(readOnly=true)
public interface RemarkRepository extends CrudRepository<Remark, Long> {

	List<Remark> findByCardId(Long id);
	
	@Modifying
	@Transactional
	@Query("update Remark r set r.praiseNum = r.praiseNum + 1 where r.id = ?1")
	void addPriseNumOne(Long id);
	
}
