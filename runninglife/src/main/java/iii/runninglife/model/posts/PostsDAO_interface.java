package iii.runninglife.model.posts;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PostsDAO_interface {
      public void insert(PostsVO postsVO);
      public void update(PostsVO postsVO);
      public void delete(String postsID);
      public PostsVO findByPrimaryKey(String postsVO);
      public List<PostsVO> getAll();
      public List<PostsVO> getMemberPostAll(String memberID);
      public List<PostsVO> getResponseAll();
      public void changeStatus(PostsVO postsVO);
}
