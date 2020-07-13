package com.kloudone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kloudone.model.Post;
import com.kloudone.model.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository extends JpaRepository<Post,Long>{
	
	Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);

}
