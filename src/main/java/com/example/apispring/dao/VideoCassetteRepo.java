package com.example.apispring.dao;

import com.example.apispring.dao.entity.VideoCassette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette,Long> {
}
