package com.vcpf.jee202405110416.repository;
import java.util.List;

import com.vcpf.jee202405110416.entity.Author;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer>{
    /**
     * 查询作者名含有name的作者列表，并排序
     */
    List<Author> findByAnameContaining(String aname, Sort sort);
}