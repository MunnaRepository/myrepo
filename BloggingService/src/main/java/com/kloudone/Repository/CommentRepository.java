package com.kloudone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloudone.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

}
