package com.wony.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>,
        QuerydslPredicateExecutor<BoardEntity>,
        BoardCustomRepository {
}
