package com.example.todolist.service; // サービスパッケージ

import com.example.todolist.domain.TodoItem; // タスクドメインクラス
import com.example.todolist.mapper.TodoItemMapper; // データベースと連携するマッパーインターフェース
import org.springframework.beans.factory.annotation.Autowired; // 依存性注入用アノテーション
import org.springframework.stereotype.Service; // サービス層を示すアノテーション
import java.util.List; // TodoItemオブジェクトのリスト

// サービスクラスを示すアノテーション
@Service
public class TodoItemService {

    // TodoItemMapperの自動注入
    @Autowired
    private TodoItemMapper todoItemMapper;

    // すべてのタスクを取得
    public List<TodoItem> getAllTodoItems() {
        return todoItemMapper.findAll();
    }

    // 新しいタスクを追加
    public void addTodoItem(TodoItem todoItem) {
        todoItemMapper.insert(todoItem);
    }

    // 特定のIDのタスクを取得
    public TodoItem getTodoItemById(Long id) {
        return todoItemMapper.findById(id);
    }

    // タスクを更新
    public void updateTodoItem(TodoItem todoItem) {
        todoItemMapper.update(todoItem);
    }

    // タスクを削除
    public void deleteTodoItem(Long id) {
        todoItemMapper.delete(id);
    }

    // タスクの完了状態をトグル
    public void toggleCompletion(Long id) {
        TodoItem todoItem = getTodoItemById(id);
        if (todoItem != null) { // タスクが存在する場合のみ実行
            todoItem.setCompleted(!todoItem.isCompleted()); // 完了状態を反転
            updateTodoItem(todoItem); // 更新された状態を保存
        }
    }
}
