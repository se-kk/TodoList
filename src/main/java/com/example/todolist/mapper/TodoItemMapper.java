package com.example.todolist.mapper; // マッパーパッケージ

import com.example.todolist.domain.TodoItem; // タスクドメインクラス
import org.apache.ibatis.annotations.Mapper; // MyBatisのマッパーアノテーション
import org.apache.ibatis.annotations.Param; // SQLクエリのパラメータ名指定用アノテーション

import java.util.List; // TodoItemオブジェクトのリスト

// MyBatisがこのインターフェースをマッパーとして認識
@Mapper
public interface TodoItemMapper {

    // すべてのタスクを取得
    List<TodoItem> findAll();

    // 新しいタスクを挿入
    void insert(TodoItem todoItem);

    // タスクを更新
    void update(TodoItem todoItem);

    // 特定のIDのタスクを削除
    void delete(Long id);

    // 特定のIDのタスクを取得
    TodoItem findById(@Param("id") Long id);
}
