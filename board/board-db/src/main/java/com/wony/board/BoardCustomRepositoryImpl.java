package com.wony.board;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<BoardEntity> findByTitle(long boardId, String title) {
        JPAQuery<BoardEntity> query = new JPAQuery<>(entityManager);
        QBoardEntity qBoardEntity = QBoardEntity.boardEntity;
        return query.from(qBoardEntity)
                .where(qBoardEntity.title.eq(title).and(qBoardEntity.boardId.eq(boardId)))
                .stream().toList();
    }
}
