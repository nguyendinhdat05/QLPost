package com.example.qlpost.repository;

import com.example.qlpost.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserIdAndStatus ( Long id , String status );
    List<Post> findByStatus(String status);
    List<Post> findAllByOrderByLikesAsc();

    // câu lệnh truy vấn lấy ra 4 top like và có status là public
//    @Query( "SELECT s from Post s where s.status like'Public' order by s.likes desc limit 4")
//    List<Post> findTop4ByOrderByLikesDesc();
    List<Post> findTop4ByStatusOrderByLikesDesc(String status);


}
